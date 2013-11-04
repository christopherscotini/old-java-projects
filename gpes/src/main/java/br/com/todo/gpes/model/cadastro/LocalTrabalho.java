package br.com.todo.gpes.model.cadastro;

public class LocalTrabalho {
	private String cliente;
	private String descricao;
	private String ruaAv;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private boolean status;
	
	public LocalTrabalho(){
		super();
	}
	
	public LocalTrabalho(LocalTrabalho local){
		super();
		this.cliente = local.getCliente();
		this.descricao = local.getDescricao();
		this.ruaAv = local.getRuaAv();
		this.numero = local.getNumero();
		this.bairro = local.getBairro();
		this.cidade = local.getCidade();
		this.estado = local.getEstado();
		this.cep = local.getCep();
		this.status = local.isStatus();
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRuaAv() {
		return ruaAv;
	}
	public void setRuaAv(String ruaAv) {
		this.ruaAv = ruaAv;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
