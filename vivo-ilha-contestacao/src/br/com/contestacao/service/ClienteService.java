package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.controller.cadastros.model.CadastroCliente;
import br.com.contestacao.model.Cliente;

public interface ClienteService extends Serializable {

	void salvar(CadastroCliente cliente);

	List<Cliente> listar();

	List<CadastroCliente> listar(CadastroCliente cliente);

	Cliente buscarPorCnpj(String cnpj);

}
