package br.com.todo.gpes.model.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChaveEstado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -331801569507262643L;

	@Column(name = "cdUnidadeFederativa")
	private Integer codigoEstado;
	
	@Column(name = "cdPais")
	private Integer codigoPais;

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

		if (!(obj instanceof ChaveEstado)) {
			return false;
		}

		ChaveEstado other = (ChaveEstado) obj;
		return this.getCodigoEstado().equals(other.getCodigoEstado())
				&& this.getCodigoPais().equals(other.getCodigoPais());
	}

	@Override
	public int hashCode() {
		int hash = getCodigoEstado().hashCode();
		hash = hash + getCodigoPais().hashCode();
		return hash;
	}
}
