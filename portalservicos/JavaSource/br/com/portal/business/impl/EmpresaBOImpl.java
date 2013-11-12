/**
 * 
 */
package br.com.portal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.business.EmpresaBO;
import br.com.portal.business.exception.RegistroJaCadastradoException;
import br.com.portal.dao.cadastro.EmpresaDao;
import br.com.portal.dao.cadastro.UserDao;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.utils.CriptografiaUtil;

/**
 * @author christopher.rozario
 *
 */

@Service
public class EmpresaBOImpl implements EmpresaBO{

	@Autowired
	private UserDao userDao = null;

	@Autowired
	private EmpresaDao dao = null;

	@Override
	public List<EmpresaEntity> listarTodos() {
		return dao.findAll();
	}

	@Override
	public EmpresaEntity adicionarEntidade(EmpresaEntity entidade) {
		
		if(userDao.existsUser(entidade.getUsuario())){
			throw new RegistroJaCadastradoException("Esse usuario já esta cadastrado.");
		}		
		
		if(dao.existsEmpresa(entidade)){
			throw new RegistroJaCadastradoException("Essa empresa já esta cadastrada.");
		}
		
		entidade.getUsuario().setPassword(CriptografiaUtil.criptografar(entidade.getUsuario().getPassword()));
		entidade.setUsuario(userDao.insert(entidade.getUsuario()));
		
		return dao.insert(entidade);
		
	}

	@Override
	public EmpresaEntity editarEntidade(EmpresaEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmpresaDao getDao() {
		return dao;
	}

	public void setDao(EmpresaDao dao) {
		this.dao = dao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
