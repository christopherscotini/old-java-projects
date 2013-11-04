package br.com.todo.gpes.service.cadastro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.gpes.model.cadastro.Cliente;
import br.com.todo.gpes.persistence.dao.cadastro.ClienteDao;
import br.com.todo.gpes.service.cadastro.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao = null;
	
	public void incluirCliente(Cliente cliente) {
		clienteDao.insert(cliente);
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

}
