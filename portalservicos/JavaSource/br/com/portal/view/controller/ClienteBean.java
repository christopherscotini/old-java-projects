package br.com.portal.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;
import br.com.portal.security.LoginBean;

@ManagedBean
@SessionScoped
public class ClienteBean extends AbstractModelBean {

	private final String TELA_LISTAR_SOLICITACOES_CLIENTE = "/content/menu-cliente/listarSolicitacoesCliente.xhtml";
	private final String TELA_INCLUIR_SOLICITACAO_CLIENTE = "/content/menu-cliente/efetuarSolicitacao.xhtml";
	private final String TELA_DETALHAR_SOLICITACOES = "/content/menu-cliente/detalharSolicitacao.xhtml";

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean login = null;

	private List<EmpresaEntity> empresas;
	private List<SolicitacaoEntity> solicitacoes;
	private SolicitacaoEntity solicitacaoCadastro;
	private SolicitacaoEntity solicitacaoSelecionada;
	private SolicitacaoEntity filteredSolicitacao;
	private ClienteEntity cliente;

	public ClienteBean() {

	}

	@Override
	public String iniciarTela() {
		cliente = getClienteBO().buscarClientePorUserID(login.getUsuario());
		solicitacoes = getSolicitacaoBO().listarSolicitacaoCliente(cliente);
		filteredSolicitacao = null;
		solicitacaoSelecionada = null;

		return TELA_LISTAR_SOLICITACOES_CLIENTE;
	}

	@Override
	public void limparCamposFiltro() {

	}

	@Override
	public String pesquisarFiltro() {
		return null;
	}

	public String navegarDetalharSolicitacao() {

		return TELA_DETALHAR_SOLICITACOES;
	}

	public String navegarIncluirSolicitacao() {
		resetarFormulario();
		empresas = getEmpresaBO().listarTodos();
		solicitacaoCadastro.setEmpresaPrestadoraServico(empresas.get(0));
		if(cliente == null){
			cliente = getClienteBO().buscarClientePorUserID(login.getUsuario());
		}
		
		return TELA_INCLUIR_SOLICITACAO_CLIENTE;
	}

	public String executeSave() {
		try {
			solicitacaoCadastro.setClienteSolicitante(cliente);
			getSolicitacaoBO().adicionarEntidade(solicitacaoCadastro);
			Messages.addInfo(null, "Solicitação enviada com sucesso.");
		} catch (Exception e) {
			Messages.addError(null, "Erro inesperado.");
		}

		return iniciarTela();
	}

	public void resetarFormulario() {
		solicitacaoCadastro = new SolicitacaoEntity();

	}
	
	public String navegarVoltarEfetuarSolicitacao() {
		
		return TELA_LISTAR_SOLICITACOES_CLIENTE;
	}

	public List<SolicitacaoEntity> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEntity> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public SolicitacaoEntity getSolicitacaoCadastro() {
		return solicitacaoCadastro;
	}

	public void setSolicitacaoCadastro(SolicitacaoEntity solicitacaoCadastro) {
		this.solicitacaoCadastro = solicitacaoCadastro;
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public SolicitacaoEntity getSolicitacaoSelecionada() {
		return solicitacaoSelecionada;
	}

	public void setSolicitacaoSelecionada(
			SolicitacaoEntity solicitacaoSelecionada) {
		this.solicitacaoSelecionada = solicitacaoSelecionada;
	}

	public SolicitacaoEntity getFilteredSolicitacao() {
		return filteredSolicitacao;
	}

	public void setFilteredSolicitacao(SolicitacaoEntity filteredSolicitacao) {
		this.filteredSolicitacao = filteredSolicitacao;
	}

}
