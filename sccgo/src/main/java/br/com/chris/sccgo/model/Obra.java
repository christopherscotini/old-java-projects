package br.com.chris.sccgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Obra {

//	Para cada obra, mant�m-se o 
//	c�digo de identifica��o, 
//	o endere�o da obra e 
//	o n�mero de registro da licen�a de constru��o;
	
	@Id @GeneratedValue
	@Column(name="obra_id")
	private Long id;
	
	@Column(name="end_obra")
	private String endereco;

	@Column(name="nome_obra")
	private String nome;
	
	@Column(name="reg_licenca_obra")
	private String registro;
	
	@Column(name="mestre_obra")
	private String responsavelPelaObra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getResponsavelPelaObra() {
		return responsavelPelaObra;
	}

	public void setResponsavelPelaObra(String responsavelPelaObra) {
		this.responsavelPelaObra = responsavelPelaObra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
