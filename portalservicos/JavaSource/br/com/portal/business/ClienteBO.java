package br.com.portal.business;

import br.com.portal.model.ClienteEntity;
import br.com.portal.model.UserEntity;


public interface ClienteBO extends ServiceModel<ClienteEntity>{

	public ClienteEntity buscarClientePorUserID(UserEntity user);

}
