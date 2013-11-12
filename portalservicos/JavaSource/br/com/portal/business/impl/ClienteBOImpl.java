/**
 * 
 */
package br.com.portal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.business.ClienteBO;
import br.com.portal.business.exception.RegistroJaCadastradoException;
import br.com.portal.dao.cadastro.ClienteDao;
import br.com.portal.dao.cadastro.UserDao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.UserEntity;
import br.com.portal.utils.CriptografiaUtil;

/**
 * @author christopher.rozario
 *
 */

@Service
public class ClienteBOImpl implements ClienteBO{

	@Autowired
	private ClienteDao dao = null;

	@Autowired
	private UserDao usuarioDao = null;
	

	@Override
	public List<ClienteEntity> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ClienteEntity adicionarEntidade(ClienteEntity entidade) {
		if(usuarioDao.existsUser(entidade.getUsuario())){
			throw new RegistroJaCadastradoException("Esse usuario já esta cadastrado.");
		}		
		
		if(dao.existsCliente(entidade)){
			throw new RegistroJaCadastradoException("Esse cliente já esta cadastrado.");
		}
		
		entidade.getUsuario().setPassword(CriptografiaUtil.criptografar(entidade.getUsuario().getPassword()));
		entidade.setUsuario(usuarioDao.insert(entidade.getUsuario()));
		
		return dao.insert(entidade);
	}

	@Override
	public ClienteEntity editarEntidade(ClienteEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity buscarClientePorUserID(UserEntity user) {

		return dao.findByUserId(user);
	}
	
	public ClienteDao getDao() {
		return dao;
	}

	public void setDao(ClienteDao dao) {
		this.dao = dao;
	}

	public UserDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UserDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
}
