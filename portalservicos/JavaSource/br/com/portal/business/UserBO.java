package br.com.portal.business;

import java.util.List;

import br.com.portal.model.UserEntity;


public interface UserBO extends ServiceModel<UserEntity>{


	public UserEntity verificarLogin(UserEntity usuario);
	public List<UserEntity> buscarEntidadePorFiltro(String username);
	
}
