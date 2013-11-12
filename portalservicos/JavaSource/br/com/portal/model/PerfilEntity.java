package br.com.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PERFIL")
public class PerfilEntity extends GenericEntity implements Serializable {
	
	private static final long serialVersionUID = -7315905366603156964L;

	@Column(name = "DS_PERFIL")
	private String descPerfil;
	
	public PerfilEntity() {

	}

	public String getDescPerfil() {
		return descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

}
