package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.todo.gpes.model.cadastro.Funcionario;
import br.com.todo.gpes.service.cadastro.FuncionarioService;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

	@ManagedProperty(value = "#{funcionarioServiceImpl}")
	private FuncionarioService funcionarioService = null;

	private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	public String consultar() {
		listaFuncionarios = funcionarioService.obterFuncionarios();

		return null;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

}
