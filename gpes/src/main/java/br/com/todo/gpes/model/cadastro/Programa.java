package br.com.todo.gpes.model.cadastro;

public class Programa {
	
	//Variáveis
	private String programa;
	private String descricao;
	
	//Contrutor Cheio
	public Programa(String programa, String descricao) {
		super();
		this.programa = programa;
		this.descricao = descricao;
	}
	
	//Contrutor Vazio	
	public Programa(){
		
	}

	//Getters e Setters
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
