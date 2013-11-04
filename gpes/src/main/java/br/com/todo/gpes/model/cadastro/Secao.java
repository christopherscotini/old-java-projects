package br.com.todo.gpes.model.cadastro;

public class Secao {
	
	/*********************
	 * Variaveis *
	 * *******************/
	private String departamento;
	private String codigoJuncao;
	private String secao;
	private String local;
	private String complemento;
	private boolean status;
	
	/*********************
	 * Construtores *
	 * *******************/
	public Secao(Secao obj) {
		super();
		setDepartamento(obj.getDepartamento());
		setCodigoJuncao(obj.getCodigoJuncao());
		setSecao(obj.getSecao());
		setLocal(obj.getLocal());
		setComplemento(obj.getComplemento());
		setStatus(obj.isStatus());
	}
	
	public Secao(){
		super();
	}
	/*********************
	 * Getters e Setters *
	 * *******************/
	
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCodigoJuncao() {
		return codigoJuncao;
	}
	public void setCodigoJuncao(String codigoJuncao) {
		this.codigoJuncao = codigoJuncao;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
