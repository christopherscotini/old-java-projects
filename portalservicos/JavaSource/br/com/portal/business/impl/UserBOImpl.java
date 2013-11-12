/**
 * 
 */
package br.com.portal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.business.UserBO;
import br.com.portal.business.exception.RegistroJaCadastradoException;
import br.com.portal.dao.cadastro.UserDao;
import br.com.portal.model.UserEntity;
import br.com.portal.utils.CriptografiaUtil;
import br.com.portal.utils.ProjetoUtils;

/**
 * @author christopher.rozario
 *
 */

@Service
public class UserBOImpl implements UserBO{

	@Autowired
	private UserDao dao = null;

	@Override
	public UserEntity verificarLogin(UserEntity usuario) {
		
		return dao.findUserByLogin(usuario.getUsername(), CriptografiaUtil.criptografar(usuario.getPassword()));
		
	}

	@Override
	public UserEntity adicionarEntidade(UserEntity usuario) {
		if(!dao.existsUser(usuario)){
			usuario.setPassword(CriptografiaUtil.criptografar(usuario.getPassword()));
			return dao.insert(usuario);
		}else{
			throw new RegistroJaCadastradoException("Usuario "+usuario.getUsername());
		}
	}


	@Override
	public UserEntity editarEntidade(UserEntity usuario) {
		if(!dao.existsUser(usuario)){
			return dao.update(usuario);
		}else{
			throw new RegistroJaCadastradoException("Usuario "+usuario.getUsername());
		}

	}
	
	@Override
	public List<UserEntity> buscarEntidadePorFiltro(String username) {
		
		return dao.findUserbyFilter(ProjetoUtils.verificaStringNula(username));
	}

	@Override
	public List<UserEntity> listarTodos() {
		return getDao().findAll();
	}

	public UserDao getDao() {
		return dao;
	}
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	
}
