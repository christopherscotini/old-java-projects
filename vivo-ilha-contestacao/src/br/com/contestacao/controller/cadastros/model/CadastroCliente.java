package br.com.contestacao.controller.cadastros.model;

import java.math.BigDecimal;

import br.com.contestacao.model.ServicoEnum;

public class CadastroCliente {

	private boolean novo = true;

	private String cnpj = null;

	private String nome = null;

	private Boolean flagAtivo = Boolean.TRUE;
	
	private String uf = null;

	private Long idContrato = null;

	private String contrato = null;

	private Long servico = null;

	private String nomeServico = null;

	private Long subServico = null;

	private String nomeSubServico = null;

	private BigDecimal vc1 = null;

	private BigDecimal vc2 = null;

	private BigDecimal vc3 = null;

	private BigDecimal nacional = null;

	private BigDecimal internacional = null;

	private BigDecimal valor = null;

	public CadastroCliente() {
		super();
	}

	public CadastroCliente(CadastroCliente cadastroCliente) {
		super();
		this.novo = false;
		this.cnpj = cadastroCliente.getCnpj();
		this.nome = cadastroCliente.getNome();
		this.flagAtivo = cadastroCliente.getFlagAtivo();
		this.uf = cadastroCliente.getUf();
		this.idContrato = cadastroCliente.getIdContrato();
		this.contrato = cadastroCliente.getContrato();
		this.servico = cadastroCliente.getServico();
		this.nomeServico = cadastroCliente.getNomeServico();
		this.subServico = cadastroCliente.getSubServico();
		this.nomeSubServico = cadastroCliente.getNomeSubServico();
		this.vc1 = cadastroCliente.getVc1();
		this.vc2 = cadastroCliente.getVc2();
		this.vc3 = cadastroCliente.getVc3();
		this.nacional = cadastroCliente.getNacional();
		this.internacional = cadastroCliente.getInternacional();
		this.valor = cadastroCliente.getValor();
	}

	public boolean isNovo() {
		return novo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Long getServico() {
		return servico;
	}

	public void setServico(Long servico) {
		this.servico = servico;
	}

	public Long getSubServico() {
		return subServico;
	}

	public void setSubServico(Long subServico) {
		this.subServico = subServico;
	}

	public BigDecimal getVc1() {
		return vc1;
	}

	public void setVc1(BigDecimal vc1) {
		this.vc1 = vc1;
	}

	public BigDecimal getVc2() {
		return vc2;
	}

	public void setVc2(BigDecimal vc2) {
		this.vc2 = vc2;
	}

	public BigDecimal getVc3() {
		return vc3;
	}

	public void setVc3(BigDecimal vc3) {
		this.vc3 = vc3;
	}

	public BigDecimal getNacional() {
		return nacional;
	}

	public void setNacional(BigDecimal nacional) {
		this.nacional = nacional;
	}

	public BigDecimal getInternacional() {
		return internacional;
	}

	public void setInternacional(BigDecimal internacional) {
		this.internacional = internacional;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getNomeSubServico() {
		return nomeSubServico;
	}

	public void setNomeSubServico(String nomeSubServico) {
		this.nomeSubServico = nomeSubServico;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public boolean isServicoTelefonia() {
		return ServicoEnum.TELEFONIA.getCodigo().equals(servico);
	}

	public boolean isServicoSms() {
		return ServicoEnum.SMS.getCodigo().equals(servico);
	}

	public boolean isServicoInternetOutros() {
		return !isServicoTelefonia() && !isServicoSms();
	}
}
