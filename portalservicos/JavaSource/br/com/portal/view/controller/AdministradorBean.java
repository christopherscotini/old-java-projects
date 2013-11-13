package br.com.portal.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;

@ManagedBean
@SessionScoped
public class AdministradorBean extends AbstractModelBean {

	private final String TELA_LISTAR_SOLICITACOES = "/content/menu-admin/listarSolicitacoesAdmin.xhtml";
	private final String TELA_DETALHE_SOLICITACOES = "/content/menu-admin/detalharSolicitacaoAdmin.xhtml";
	private final String TELA_LISTAR_CLIENTES = "/content/menu-admin/listarClientesAdmin.xhtml";
	private final String TELA_DETALHE_CLIENTE = "/content/menu-admin/detalharClienteAdmin.xhtml";
	private final String TELA_LISTAR_EMPRESAS = "/content/menu-admin/listarEmpresasAdmin.xhtml";
	private final String TELA_DETALHE_EMPRESA = "/content/menu-admin/detalharEmpresaAdmin.xhtml";

	private List<SolicitacaoEntity>solicitacoes = null;
	private List<SolicitacaoEntity>filteredSolicitacoes = null;
	private SolicitacaoEntity solicitacaoSelecionada = null;
	private List<ClienteEntity>clientes = null;
	private List<ClienteEntity>filteredClientes = null;
	private ClienteEntity clienteSelecionado = null;
	private List<EmpresaEntity>empresas = null;
	private List<EmpresaEntity>filteredEmpresas = null;
	private EmpresaEntity empresaSelecionada = null;
	
	
	public String iniciarTelaSolicitacoes(){
		solicitacoes = getSolicitacaoBO().listarSolicitacaoAdmin();
		solicitacaoSelecionada = null;
		
		return TELA_LISTAR_SOLICITACOES;
	}
	
	public String navegarDetalharSolicitacao(){

		return TELA_DETALHE_SOLICITACOES;
	}
	
	public String iniciarTelaClientes(){
		clientes = getClienteBO().listarTodos();
		clienteSelecionado = null;
		
		return TELA_LISTAR_CLIENTES;
	}

	public String navegarDetalharCliente(){
		
		return TELA_DETALHE_CLIENTE;
	}
	
	public String iniciarTelaEmpresas(){
		empresas = getEmpresaBO().listarTodos();
		empresaSelecionada = null;
		
		return TELA_LISTAR_EMPRESAS;
	}

	public String navegarDetalharEmpresa(){
		
		return TELA_DETALHE_EMPRESA;
	}

	public List<SolicitacaoEntity> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEntity> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public List<SolicitacaoEntity> getFilteredSolicitacoes() {
		return filteredSolicitacoes;
	}

	public void setFilteredSolicitacoes(List<SolicitacaoEntity> filteredSolicitacoes) {
		this.filteredSolicitacoes = filteredSolicitacoes;
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

	public List<ClienteEntity> getFilteredClientes() {
		return filteredClientes;
	}

	public void setFilteredClientes(List<ClienteEntity> filteredClientes) {
		this.filteredClientes = filteredClientes;
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<EmpresaEntity> getFilteredEmpresas() {
		return filteredEmpresas;
	}

	public void setFilteredEmpresas(List<EmpresaEntity> filteredEmpresas) {
		this.filteredEmpresas = filteredEmpresas;
	}

	public SolicitacaoEntity getSolicitacaoSelecionada() {
		return solicitacaoSelecionada;
	}
	public void setSolicitacaoSelecionada(SolicitacaoEntity solicitacaoSelecionada) {
		this.solicitacaoSelecionada = solicitacaoSelecionada;
	}
	public ClienteEntity getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(ClienteEntity clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public EmpresaEntity getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	@Override
	public String iniciarTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparCamposFiltro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pesquisarFiltro() {
		// TODO Auto-generated method stub
		return null;
	}
}
