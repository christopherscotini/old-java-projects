package br.com.todo.gpes.view.controller.cadastro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="tipoProjetoBean")
@SessionScoped
public class TipoProjetoBean {
	
	private boolean cadastrar;
	
	private String tituloTelaIncluirAlterar;
	
	private final String TELA_CONSULTA = "/content/cadastros/tipoProjeto/conTipoProjeto";
	
	private final String INCLUIR_ALTERAR = "/content/cadastros/tipoProjeto/incAltTipoProjeto";

	public String consultarTipoProjeto() {
		return TELA_CONSULTA;
	}
	
	public String cadastrarTipoProjeto() {
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inserir Tipo de Projeto");
		
		return INCLUIR_ALTERAR;
	}
	
	public String alterarTipoProjeto() {
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alterar Tipo de Projeto");
		
		return INCLUIR_ALTERAR;
	}
	
	public String pesquisar() {
		return TELA_CONSULTA;
	}
	
	public String limpar(){
		return INCLUIR_ALTERAR;
	}
	
	public String salvarTipoProjeto() {
		return TELA_CONSULTA;
	}
	
	public String voltarConsultaTipoProjeto() {
		return TELA_CONSULTA;
	}

	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}

	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}

	public boolean isCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}

}
