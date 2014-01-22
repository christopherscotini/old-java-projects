package br.com.utmanager.view.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.utmanager.model.Jogador;
import br.com.utmanager.view.utils.GlobalUtils;
import br.com.utmanager.view.utils.StringUtils;

@ManagedBean
@SessionScoped
public class SimuladorBean extends AbstractGenericBean{

	private final String TELA_SIMULADOR = "/content/simulador.xhtml";
	
	private Integer opcaoSimular;
	private BigDecimal valorPago;
	private BigDecimal valorVenda;
	private BigDecimal resultadoSimuladorVenda;
	
	@Override
	public String iniciarTela() {
		opcaoSimular = null;
		zerarValores();
		
		
		return TELA_SIMULADOR;
	}
	
	private void zerarValores() {
		valorPago = null;
		valorVenda = null;
		resultadoSimuladorVenda = null;
	}

	public void calculoSimuladorVenda(){
		if(!GlobalUtils.isBigDecimalNullOrZero(valorVenda)){
			efetuarCalculoSimuladorVenda();
		}
	}
	
	private void efetuarCalculoSimuladorVenda(){
		resultadoSimuladorVenda = BigDecimal.ZERO;
		resultadoSimuladorVenda = valorVenda.subtract(GlobalUtils.verificaBigDecimalNulo(valorVenda).multiply(new BigDecimal("0.05"))).subtract(GlobalUtils.verificaBigDecimalNulo(GlobalUtils.verificaBigDecimalNulo(valorPago)));
	}

	
	public Integer getOpcaoSimular() {
		return opcaoSimular;
	}

	public void setOpcaoSimular(Integer opcaoSimular) {
		this.opcaoSimular = opcaoSimular;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getResultadoSimuladorVenda() {
		return resultadoSimuladorVenda;
	}

	public void setResultadoSimuladorVenda(BigDecimal resultadoSimuladorVenda) {
		this.resultadoSimuladorVenda = resultadoSimuladorVenda;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

}
