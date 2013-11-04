package br.com.todo.gpes.model.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChaveMunicipio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9221022373359680070L;

	@Column(name = "cdMunicipio")
	private Integer codigoMunicipio;

	@Column(name = "cdUnidadeFederativa")
	private Integer codigoEstado;
	
	@Column(name = "cdPais")
	private Integer codigoPais;
	
	

	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChaveMunicipio)) {
			return false;
		}

		ChaveMunicipio other = (ChaveMunicipio) obj;
		return this.getCodigoEstado().equals(other.getCodigoEstado())
				&& this.getCodigoPais().equals(other.getCodigoPais())
				&& this.getCodigoMunicipio().equals(other.getCodigoMunicipio());
	}

	@Override
	public int hashCode() {
		int hash = getCodigoEstado().hashCode();
		hash = hash + getCodigoPais().hashCode();
		hash = hash + getCodigoMunicipio().hashCode();
		return hash;
	}
}
