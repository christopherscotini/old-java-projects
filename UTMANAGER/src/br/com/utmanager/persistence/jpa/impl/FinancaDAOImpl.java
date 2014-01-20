package br.com.utmanager.persistence.jpa.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Jogador;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.persistence.dao.FinancaDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class FinancaDAOImpl extends JpaGenericDao<Financa, Long> implements FinancaDAO{

	@Override
	@Transactional
	public List<Financa> findAll() {

		return getEntityManager().createQuery("FROM Financa f ORDER BY f.dataMovimentacao DESC").getResultList();
	}
	
	@Override
	public BigDecimal getSaldoAtual() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT f.valorAtual FROM Financa f ");
		query.append(" ORDER BY f.valorAtual DESC");
		query.append("");

		try{
			BigDecimal saldo = (BigDecimal) getEntityManager().createQuery(query.toString()).setMaxResults(1).getSingleResult();
			return saldo;
		}catch(NoResultException nre){
			return BigDecimal.ZERO;
		}
		
	}

	@Override
	@Transactional
	public Financa update(Financa entity) {
		
		Financa returnzz = super.update(entity);
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT f FROM Financa f ");
		query.append(" ORDER BY f.id ASC");
		
		List<Financa> listaFinanca = getEntityManager().createQuery(query.toString()).getResultList();
		for (int i = 1; i < listaFinanca.size(); i++) {
			listaFinanca.get(i).setValorAtual(listaFinanca.get(i).getValorMovimentado().add(listaFinanca.get(i-1).getValorAtual()));
		
			super.update(listaFinanca.get(i));
		}
		
		return returnzz;
	}
	
	@Override
	public Financa verificaMovimentacaoJogador(Jogador jogador) {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT f FROM Financa f ");
		query.append(" WHERE f.jogador.id = :idJogador");
		query.append(" ");

		try{
			return (Financa) getEntityManager().createQuery(query.toString()).setParameter("idJogador", jogador.getId()).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}

	}

	@Override
	public BigDecimal getLucroTotalTransferencias() {
	
		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(j.lucro),0) FROM Jogador j ");
		query.append(" ");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

	@Override
	public BigDecimal getGastoTotalTransferencias() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(f.valorMovimentado),0) FROM Financa f ");
		query.append(" WHERE f.tipoMovimentacao = '"+TipoMovimentacaoEnum.COMPRA_JOGADOR.name()+"'");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

	@Override
	public BigDecimal getGanhoTotalTransferencias() {

		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(f.valorMovimentado),0) FROM Financa f ");
		query.append(" WHERE f.tipoMovimentacao = '"+TipoMovimentacaoEnum.VENDA_JOGADOR.name()+"'");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

	@Override
	public BigDecimal getGanhoTotalPartidas() {

		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(f.valorMovimentado),0) FROM Financa f ");
		query.append(" WHERE f.tipoMovimentacao = '"+TipoMovimentacaoEnum.GANHO_PARTIDA.name()+"'");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

	@Override
	public BigDecimal getGanhoTotalPremiacoes() {

		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(f.valorMovimentado),0) FROM Financa f ");
		query.append(" WHERE f.tipoMovimentacao = '"+TipoMovimentacaoEnum.GANHO_TORNEIO.name()+"'");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

	@Override
	public BigDecimal getGastoTotalOutros() {

		StringBuilder query = new StringBuilder();
		query.append(" SELECT COALESCE(SUM(f.valorMovimentado),0) FROM Financa f ");
		query.append(" WHERE f.tipoMovimentacao = '"+TipoMovimentacaoEnum.COMPRA_OUTROS.name()+"'");
		
		return (BigDecimal) getEntityManager().createQuery(query.toString()).getSingleResult();
	}

}
