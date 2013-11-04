package br.com.todo.gpes.model.cadastro;

public class Departamento {
	
	/*
	 * Variáveis
	 * */
	private String nomeCliente;
	private String departamento;
	private String local;
	private String status;
	private Integer codigoJuncao;
	private String complemento;
	
	/*
	 * Construtor Vazio
	 * */
	public Departamento(){
		super();
	}
	
	
	/*
	 * Construtor Cheio
	 * */
	public Departamento(Departamento dpto) {
		super();
		this.nomeCliente = dpto.getNomeCliente();
		this.departamento = dpto.getDepartamento();
		this.local = dpto.getLocal();
		this.status = dpto.getStatus();
		this.codigoJuncao = dpto.getCodigoJuncao();
		this.complemento = dpto.getComplemento();
	}

	
	
	/*
	 * Getters e Setters
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCodigoJuncao() {
		return codigoJuncao;
	}
	public void setCodigoJuncao(Integer codigoJuncao) {
		this.codigoJuncao = codigoJuncao;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
