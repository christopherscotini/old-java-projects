package br.com.todo.gpes.view.controller.cadastro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="contatoClienteBean")
@SessionScoped
public class ContatoClienteBean {

	private boolean cadastrar;

	private String tituloTelaIncluirAlterar;

	private static final String TELA_CONSULTA = "/content/cadastros/contatoCliente/conContatoCliente";

	private static final String INCLUIR_ALTERAR = "/content/cadastros/contatoCliente/incAltContatoCliente";


	public String consultarContato() {
		return TELA_CONSULTA;
	}
	
	
	public String cadastrarContatoCliente() {
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Incluir Dados do Contato");
		
		return INCLUIR_ALTERAR;
	}
	
	public String alterarContatoCliente() {
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alterar Dados do Contato");
		
		return INCLUIR_ALTERAR;
	}

	public String pesquisar() {
		return TELA_CONSULTA;
	}

	public String voltar() {
		return TELA_CONSULTA;
	}
	
	public String limpar() {
		return INCLUIR_ALTERAR;
	}
	
	public String salvarContato() {
		return TELA_CONSULTA;
	}
	
	public String tipoContato() {
		return INCLUIR_ALTERAR;
	}

	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}

	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}

	public static String getIncluirAlterar() {
		return INCLUIR_ALTERAR;
	}

	public boolean isCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}
	
}
