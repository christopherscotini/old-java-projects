package br.com.utmanager.view.controller;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FinancasBean extends AbstractGenericBean{

	private final String TELA_DASHBOARD_FINANCAS = "/content/dashboardFinancas.xhtml";
	
	@PostConstruct
	public void init(){

	}
	
	@Override
	public String iniciarTela() {
		
		return TELA_DASHBOARD_FINANCAS;
	}
	
	public BigDecimal getSaldoFinanceiro() {
		return getFinancaBO().getSaldoAtual();
	}
	
}
