package br.com.todo.gpes.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChaveContratoClienteDepartamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7201813219906535303L;

	@Column(name = "cdContrato")
	private Integer codigoContrato;
	
	@Column(name = "cdCliente")
	private Integer codigoCliente;
	
	@Column(name = "nuSequencialDepartamentoCliente")
	private Integer codigoDepartamentoCliente;

	public Integer getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(Integer codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Integer getCodigoDepartamentoCliente() {
		return codigoDepartamentoCliente;
	}

	public void setCodigoDepartamentoCliente(Integer codigoDepartamentoCliente) {
		this.codigoDepartamentoCliente = codigoDepartamentoCliente;
	}
	
}
