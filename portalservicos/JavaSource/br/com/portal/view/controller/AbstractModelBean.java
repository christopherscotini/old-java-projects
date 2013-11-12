package br.com.portal.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import br.com.portal.business.ClienteBO;
import br.com.portal.business.EmpresaBO;
import br.com.portal.business.PerfilBO;
import br.com.portal.business.SolicitacaoBO;
import br.com.portal.business.UserBO;

public abstract class AbstractModelBean {

	public abstract String iniciarTela();

	public abstract void limparCamposFiltro();

	public abstract String pesquisarFiltro();

	public List<SelectItem> getComboUf() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		retorno.add(new SelectItem("AC"));
		retorno.add(new SelectItem("AL"));
		retorno.add(new SelectItem("AM"));
		retorno.add(new SelectItem("AP"));
		retorno.add(new SelectItem("BA"));
		retorno.add(new SelectItem("CE"));
		retorno.add(new SelectItem("DF"));
		retorno.add(new SelectItem("ES"));
		retorno.add(new SelectItem("GO"));
		retorno.add(new SelectItem("MA"));
		retorno.add(new SelectItem("MG"));
		retorno.add(new SelectItem("MS"));
		retorno.add(new SelectItem("MT"));
		retorno.add(new SelectItem("PA"));
		retorno.add(new SelectItem("PB"));
		retorno.add(new SelectItem("PE"));
		retorno.add(new SelectItem("PI"));
		retorno.add(new SelectItem("PR"));
		retorno.add(new SelectItem("RJ"));
		retorno.add(new SelectItem("RN"));
		retorno.add(new SelectItem("RO"));
		retorno.add(new SelectItem("RR"));
		retorno.add(new SelectItem("RS"));
		retorno.add(new SelectItem("SC"));
		retorno.add(new SelectItem("SE"));
		retorno.add(new SelectItem("SP"));
		retorno.add(new SelectItem("TO"));
		return retorno;
	}

	@ManagedProperty(value = "#{clienteBOImpl}")
	private ClienteBO clienteBO = null;

	@ManagedProperty(value = "#{empresaBOImpl}")
	private EmpresaBO empresaBO = null;

	@ManagedProperty(value = "#{perfilBOImpl}")
	private PerfilBO perfilBO = null;

	@ManagedProperty(value = "#{solicitacaoBOImpl}")
	private SolicitacaoBO solicitacaoBO = null;

	@ManagedProperty(value = "#{userBOImpl}")
	private UserBO userBO = null;

	public SolicitacaoBO getSolicitacaoBO() {
		return solicitacaoBO;
	}

	public void setSolicitacaoBO(SolicitacaoBO solicitacaoBO) {
		this.solicitacaoBO = solicitacaoBO;
	}

	public ClienteBO getClienteBO() {
		return clienteBO;
	}

	public void setClienteBO(ClienteBO clienteBO) {
		this.clienteBO = clienteBO;
	}

	public EmpresaBO getEmpresaBO() {
		return empresaBO;
	}

	public void setEmpresaBO(EmpresaBO empresaBO) {
		this.empresaBO = empresaBO;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public PerfilBO getPerfilBO() {
		return perfilBO;
	}

	public void setPerfilBO(PerfilBO perfilBO) {
		this.perfilBO = perfilBO;
	}

}
