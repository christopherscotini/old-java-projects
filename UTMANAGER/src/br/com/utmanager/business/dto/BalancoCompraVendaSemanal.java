package br.com.utmanager.business.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.utmanager.model.TipoMovimentacaoEnum;

public class BalancoCompraVendaSemanal {
	
	private Date dia;
	private Integer quantidadeVendas;
	private Integer quantidadeCompras;
	private BigDecimal valorVendas;
	private BigDecimal valorCompras;
	private TipoMovimentacaoEnum tipoMov;
	
	public BalancoCompraVendaSemanal(Date dia, Integer quantidadeVendas,
			Integer quantidadeCompras, BigDecimal valorVendas,
			BigDecimal valorCompras) {
		super();
		this.dia = dia;
		this.quantidadeVendas = quantidadeVendas;
		this.quantidadeCompras = quantidadeCompras;
		this.valorVendas = valorVendas;
		this.valorCompras = valorCompras;
	}

	public BalancoCompraVendaSemanal() {

	}
	
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Integer getQuantidadeVendas() {
		return quantidadeVendas;
	}
	public void setQuantidadeVendas(Integer quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}
	public Integer getQuantidadeCompras() {
		return quantidadeCompras;
	}
	public void setQuantidadeCompras(Integer quantidadeCompras) {
		this.quantidadeCompras = quantidadeCompras;
	}
	public BigDecimal getValorVendas() {
		return valorVendas;
	}
	public void setValorVendas(BigDecimal valorVendas) {
		this.valorVendas = valorVendas;
	}
	public BigDecimal getValorCompras() {
		return valorCompras;
	}
	public void setValorCompras(BigDecimal valorCompras) {
		this.valorCompras = valorCompras;
	}

	public TipoMovimentacaoEnum getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(TipoMovimentacaoEnum tipoMov) {
		this.tipoMov = tipoMov;
	}

}
