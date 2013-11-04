package br.com.contestacao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.contestacao.persistence.jpa.EntityPersistence;

@Entity
@Table(name = "UF")
public class Uf implements EntityPersistence {

	private static final long serialVersionUID = -148148220231545219L;

	@Id
	@Column(name = "UF_CD_ID_PK")
	private String id;

	@Column(name = "UF_NM_ESTADO")
	private String estado;

	public Uf() {
		super();
	}

	public Uf(String id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public Serializable getPrimaryKey() {
		return getId();
	}
}