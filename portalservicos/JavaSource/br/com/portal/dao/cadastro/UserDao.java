package br.com.portal.dao.cadastro;

import java.util.List;

import br.com.portal.dao.Dao;
import br.com.portal.model.UserEntity;

public interface UserDao extends Dao<UserEntity, Long> {

	public UserEntity findUserByLogin(String login, String password);
	public boolean existsUser(UserEntity usuario);
	public List<UserEntity> findUserbyFilter(String username);
	
}
