package br.com.todo.gpes.model.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2472904432865349993L;

	@EmbeddedId
	private ChaveMunicipio chave;
	
	@Column(name = "nmMunicipio")
	private String descMunicipio;
	
	public Municipio() {
		super();
	}
	
	public Municipio(ChaveMunicipio chave, String descMunicipio) {
		super();
		this.chave = chave;
		this.descMunicipio = descMunicipio;
	}

	public ChaveMunicipio getChave() {
		return chave;
	}

	public void setChave(ChaveMunicipio chave) {
		this.chave = chave;
	}

	public String getDescMunicipio() {
		return descMunicipio;
	}

	public void setDescMunicipio(String descMunicipio) {
		this.descMunicipio = descMunicipio;
	}

}
