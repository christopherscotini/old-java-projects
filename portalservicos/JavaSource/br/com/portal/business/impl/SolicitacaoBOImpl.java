/**
 * 
 */
package br.com.portal.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.business.SolicitacaoBO;
import br.com.portal.dao.cadastro.SolicitacaoDao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;
import br.com.portal.model.StatusSolicitacao;

/**
 * @author christopher.rozario
 * 
 */

@Service
public class SolicitacaoBOImpl implements SolicitacaoBO {

	@Autowired
	private SolicitacaoDao dao = null;

	@Override
	public List<SolicitacaoEntity> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitacaoEntity adicionarEntidade(SolicitacaoEntity entidade) {
		entidade.setStatus(StatusSolicitacao.PENDENTE.getCodigo());
		entidade.setDataSolicitacao(new Date());
		
		return dao.insert(entidade);
	}

	@Override
	public SolicitacaoEntity editarEntidade(SolicitacaoEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitacaoEntity> listarSolicitacaoCliente(
			ClienteEntity cliente) {
		return dao.findByClientId(cliente);
	}

	@Override
	public List<SolicitacaoEntity> listarSolicitacaoEmpresa(
			EmpresaEntity empresa) {
		return dao.findByEmpresaId(empresa);
	}

	public SolicitacaoDao getDao() {
		return dao;
	}

	public void setDao(SolicitacaoDao dao) {
		this.dao = dao;
	}

}
