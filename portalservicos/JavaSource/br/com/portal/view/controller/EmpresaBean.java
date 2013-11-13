package br.com.portal.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.portal.exceptions.BusinessException;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;
import br.com.portal.security.LoginBean;

@ManagedBean
@SessionScoped
public class EmpresaBean extends AbstractModelBean {

	private final String TELA_LISTAR_SOLICITACOES_EMPRESA = "/content/menu-empresa/listarSolicitacoesEmpresa.xhtml";
	private final String TELA_VISUALIZAR_SOLICITACOES_EMPRESA = "/content/menu-empresa/detalharSolicitacao.xhtml";

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean login = null;

	private List<SolicitacaoEntity> solicitacoes;
	private SolicitacaoEntity solicitacaoSelecionada;
	private SolicitacaoEntity filteredSolicitacao;
	private EmpresaEntity empresa;
	
	public EmpresaBean() {

	}

	@Override
	public String iniciarTela() {
		empresa = getEmpresaBO().buscarEmpresaPorUserID(login.getUsuario());
		solicitacoes = getSolicitacaoBO().listarSolicitacaoEmpresa(empresa);
		filteredSolicitacao = null;
		solicitacaoSelecionada = null;

		return TELA_LISTAR_SOLICITACOES_EMPRESA;
	}

	@Override
	public void limparCamposFiltro() {

	}

	@Override
	public String pesquisarFiltro() {
		return null;
	}

	public String navegarDetalharSolicitacao() {

		return "";
	}

	public String prepareChangeStatus(){
		
		return TELA_VISUALIZAR_SOLICITACOES_EMPRESA;
	}
	
	public String executeChangeStatus() {
		if(!solicitacaoSelecionada.getStatus().equals(0)){
			try{
				getSolicitacaoBO().atualizarStatusSolicitacaoEmpresa(solicitacaoSelecionada);
				Messages.addInfo(null, "Status Atualizado com sucesso.");
			}catch(BusinessException b){
				Messages.addError(null, b.getMessage());
				return "";
			}
		}
		
		return iniciarTela();
	}

	public String navegarVoltarEfetuarSolicitacao() {
		
		return TELA_LISTAR_SOLICITACOES_EMPRESA;
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

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
