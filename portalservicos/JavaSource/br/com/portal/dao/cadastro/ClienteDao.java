package br.com.portal.dao.cadastro;

import br.com.portal.dao.Dao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.UserEntity;

public interface ClienteDao extends Dao<ClienteEntity, Long> {

	public boolean existsCliente(ClienteEntity cliente);
	
	public ClienteEntity findByUserId(UserEntity user);
}
