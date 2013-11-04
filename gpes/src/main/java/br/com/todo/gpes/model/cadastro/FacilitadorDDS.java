package br.com.todo.gpes.model.cadastro;

public class FacilitadorDDS {
	
	//Variaives
	private String nome;
	private String grupoDDS;
	
	
	//Construtores
	public FacilitadorDDS(){
		
	}
	public FacilitadorDDS(String nome, String grupoDDS) {
		super();
		this.nome = nome;
		this.grupoDDS = grupoDDS;
	}
	
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrupoDDS() {
		return grupoDDS;
	}
	public void setGrupoDDS(String grupoDDS) {
		this.grupoDDS = grupoDDS;
	}
	
	
}
