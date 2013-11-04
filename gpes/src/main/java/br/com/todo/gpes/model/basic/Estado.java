package br.com.todo.gpes.model.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "UnidadeFederativa")
public class Estado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 181125174673612918L;

	@EmbeddedId
	private ChaveEstado chave;

	@Column(name = "nmUnidadeFederativa")
	private String descEstado;

	public Estado() {
		super();
	}

	public Estado(ChaveEstado chave, String descEstado) {
		super();
		this.chave = chave;
		this.descEstado = descEstado;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public ChaveEstado getChave() {
		return chave;
	}

	public void setChave(ChaveEstado chave) {
		this.chave = chave;
	}
	
}
