package br.com.utmanager.persistence.jpa.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.utmanager.business.dto.BalancoCompraVendaSemanal;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.persistence.dao.DashboardTradingDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;
import br.com.utmanager.view.utils.DataUtils;

@Repository
public class DashboardTradingDAOImpl<T> extends JpaGenericDao<T, Long> implements DashboardTradingDAO<T>{

	@Override
	public List<BalancoCompraVendaSemanal> balancoCompraVendaSemanal(
			Date now,
			Date last7Days) {
		
		List<BalancoCompraVendaSemanal> returnzz = new ArrayList<BalancoCompraVendaSemanal>();
		
		StringBuilder query = new StringBuilder();
		querybalancoCompraVendaSemanal(query, now, last7Days, TipoMovimentacaoEnum.VENDA_JOGADOR);
		convertResultSet(getEntityManager().createNativeQuery(query.toString()).getResultList(), TipoMovimentacaoEnum.VENDA_JOGADOR, returnzz);

		query = new StringBuilder();
		querybalancoCompraVendaSemanal(query, now, last7Days, TipoMovimentacaoEnum.COMPRA_JOGADOR);
		convertResultSet(getEntityManager().createNativeQuery(query.toString()).getResultList(), TipoMovimentacaoEnum.COMPRA_JOGADOR, returnzz);
		
		return returnzz;
	}

	private List<BalancoCompraVendaSemanal> convertResultSet(List<Object[]> resultList, TipoMovimentacaoEnum tipoMov, List<BalancoCompraVendaSemanal> returnzz) {
		
			for (int i = 0; i < resultList.size(); i++) {
				BalancoCompraVendaSemanal obj = new BalancoCompraVendaSemanal();
				if(tipoMov.equals(TipoMovimentacaoEnum.VENDA_JOGADOR)){
					obj.setQuantidadeVendas(Integer.parseInt(resultList.get(i)[0].toString()));
				}else{
					if(tipoMov.equals(TipoMovimentacaoEnum.COMPRA_JOGADOR)){
						obj.setQuantidadeCompras(Integer.parseInt(resultList.get(i)[0].toString()));
					}
				}
				obj.setTipoMov(tipoMov);
				obj.setDia((Date)resultList.get(i)[1]);
				returnzz.add(obj);
			}
		
		return returnzz;
	}

	private void querybalancoCompraVendaSemanal(StringBuilder query, Date now, Date last7Days, TipoMovimentacaoEnum tipoMov) {
		
		query.append(" SELECT count(*) AS QTDE, CAST(f.DT_MOVIMENTACAO AS DATE) FROM tb_financa AS f");
		query.append(" WHERE f.DT_MOVIMENTACAO BETWEEN '"
				+ DataUtils.parseString(last7Days, "dd/MM/yyyy")
				+ " 00:00:00' AND '"
				+ DataUtils.parseString(now, "yyyy-MM-dd")
				+ " 23:59:59'");
		query.append(" AND f.TP_MOVIMENTACAO = '"+tipoMov.name()+"'");
		query.append(" GROUP BY CAST(f.DT_MOVIMENTACAO AS DATE)");
		
	}

	
}
