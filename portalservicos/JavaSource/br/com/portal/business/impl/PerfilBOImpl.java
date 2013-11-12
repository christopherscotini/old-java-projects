/**
 * 
 */
package br.com.portal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.business.PerfilBO;
import br.com.portal.dao.cadastro.PerfilDao;
import br.com.portal.model.PerfilEntity;

/**
 * @author christopher.rozario
 *
 */

@Service
public class PerfilBOImpl implements PerfilBO{

	@Autowired
	private PerfilDao dao = null;

	@Override
	public List<PerfilEntity> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PerfilEntity> listarTodosExcetoAdmin() {
		return dao.findAllExcludeAdmin();
	}

	@Override
	public PerfilEntity adicionarEntidade(PerfilEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerfilEntity editarEntidade(PerfilEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfilDao getDao() {
		return dao;
	}

	public void setDao(PerfilDao dao) {
		this.dao = dao;
	}
	
}
