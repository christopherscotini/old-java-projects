package br.com.todo.gpes.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChaveEnderecoCliente implements Serializable {

	private static final long serialVersionUID = -4403730815830887406L;

	@Column(name = "nuSequencialEnderecoCliente")
	private Integer numSequencial;

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}
}
