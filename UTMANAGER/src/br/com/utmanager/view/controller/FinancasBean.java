package br.com.utmanager.view.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.utmanager.exceptions.BusinessException;
import br.com.utmanager.model.Financa;

@ManagedBean
@SessionScoped
public class FinancasBean extends AbstractGenericBean{

	private final String TELA_DASHBOARD_FINANCAS = "/content/dashboard-financas/dashboardFinancas.xhtml";
	private final String TELA_ADICONAR_PREMIACAO_FINANCAS = "/content/adicionarPremiacao.xhtml";
	
	private BigDecimal lucroTotalTransferencias;
	private BigDecimal gastoTotalTransferencias;
	private BigDecimal ganhoTotalTransferencias;

	private BigDecimal ganhoTotalPartidas;
	private BigDecimal ganhoTotalPremiacoes;
	private BigDecimal gastoTotalOutros;
	private List<Financa>extrato;
	private Financa premiacaoCadastro;
	
	@PostConstruct
	public void init(){
		getAllValues();
	}
	
	@Override
	public String iniciarTela() {
		getAllValues();
		
		return TELA_DASHBOARD_FINANCAS;
	}
	
	private void getAllValues(){
		lucroTotalTransferencias = getFinancaBO().getLucroTransferenciaAtual();
		gastoTotalTransferencias = getFinancaBO().getGastoTotalTransferencia();
		ganhoTotalTransferencias = getFinancaBO().getGanhoTotalTransferencias();
		
		ganhoTotalPartidas = getFinancaBO().getGanhoTotalPartidas();
		ganhoTotalPremiacoes = getFinancaBO().getGanhoTotalPremiacoes();
		gastoTotalOutros = getFinancaBO().getGastoTotalOutros();
		extrato = getFinancaBO().getExtrato();
		
	}
	
	public String adicionarPremiacao(){
		premiacaoCadastro = new Financa();
		
		return TELA_ADICONAR_PREMIACAO_FINANCAS;
	}
	
	public String salvarPremiacao(){
		
		try{
			getFinancaBO().adicionarPremiacao(premiacaoCadastro);
		}catch(BusinessException b){
			Messages.addError(null, b.getMessage());
			return "";
		}
		return iniciarTela();
	}
	
	public BigDecimal getSaldoFinanceiro() {
		return getFinancaBO().getSaldoAtual();
	}

	public BigDecimal getLucroTotalTransferencias() {
		return lucroTotalTransferencias;
	}

	public void setLucroTotalTransferencias(BigDecimal lucroTotalTransferencias) {
		this.lucroTotalTransferencias = lucroTotalTransferencias;
	}

	public BigDecimal getGastoTotalTransferencias() {
		return gastoTotalTransferencias;
	}

	public void setGastoTotalTransferencias(BigDecimal gastoTotalTransferencias) {
		this.gastoTotalTransferencias = gastoTotalTransferencias;
	}

	public BigDecimal getGanhoTotalTransferencias() {
		return ganhoTotalTransferencias;
	}

	public void setGanhoTotalTransferencias(BigDecimal ganhoTotalTransferencias) {
		this.ganhoTotalTransferencias = ganhoTotalTransferencias;
	}

	public BigDecimal getGanhoTotalPartidas() {
		return ganhoTotalPartidas;
	}

	public void setGanhoTotalPartidas(BigDecimal ganhoTotalPartidas) {
		this.ganhoTotalPartidas = ganhoTotalPartidas;
	}

	public BigDecimal getGanhoTotalPremiacoes() {
		return ganhoTotalPremiacoes;
	}

	public void setGanhoTotalPremiacoes(BigDecimal ganhoTotalPremiacoes) {
		this.ganhoTotalPremiacoes = ganhoTotalPremiacoes;
	}

	public BigDecimal getGastoTotalOutros() {
		return gastoTotalOutros;
	}

	public void setGastoTotalOutros(BigDecimal gastoTotalOutros) {
		this.gastoTotalOutros = gastoTotalOutros;
	}

	public List<Financa> getExtrato() {
		return extrato;
	}

	public void setExtrato(List<Financa> extrato) {
		this.extrato = extrato;
	}

	public Financa getPremiacaoCadastro() {
		return premiacaoCadastro;
	}

	public void setPremiacaoCadastro(Financa premiacaoCadastro) {
		this.premiacaoCadastro = premiacaoCadastro;
	}

}
