package br.com.todo.gpes.model.cadastro;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EnderecoCliente")
public class EnderecoCliente {
	
	@Column(name = "nmLogradouroEnderecoCliente")
	private String descEndereco;
	
	@Column(name = "nuLogradouroEnderecoCliente")
	private Integer numEndereco;
	
	@Column(name = "dsComplementoEnderecoCliente")
	private String descComplementoEndereco;
	
	@Column(name = "nmBairroEnderecoCliente")
	private String descBairro;
	
	@Column(name = "cdCepEnderecoCliente")
	private Integer numCep;
	
	@Column(name = "cdComplementoCepEnderecoCliente")
	private Integer controleCep;
	
	@Column(name = "cdTipoEndereco")
	private Integer codigoTipoEndereco;
	
	@Column(name = "cdPais")
	private Integer codigoPais;
	
	@Column(name = "cdUnidadeFederativa")
	private Integer codigoEstado;
	
	@Column(name = "cdMunicipio")
	private Integer codigoMunicipio;

	@Column(name = "cdCliente", insertable=false, updatable=false)
	private Integer codigoCliente;

	@EmbeddedId
	private ChaveEnderecoCliente chaveEnderecoCliente;

	public EnderecoCliente() {
		super();
	}
	
	public String getDescEndereco() {
		return descEndereco;
	}

	public void setDescEndereco(String descEndereco) {
		this.descEndereco = descEndereco;
	}

	public Integer getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco(Integer numEndereco) {
		this.numEndereco = numEndereco;
	}

	public String getDescComplementoEndereco() {
		return descComplementoEndereco;
	}

	public void setDescComplementoEndereco(String descComplementoEndereco) {
		this.descComplementoEndereco = descComplementoEndereco;
	}

	public String getDescBairro() {
		return descBairro;
	}

	public void setDescBairro(String descBairro) {
		this.descBairro = descBairro;
	}

	public Integer getNumCep() {
		return numCep;
	}

	public void setNumCep(Integer numCep) {
		this.numCep = numCep;
	}

	public Integer getControleCep() {
		return controleCep;
	}

	public void setControleCep(Integer controleCep) {
		this.controleCep = controleCep;
	}

	public ChaveEnderecoCliente getChaveEnderecoCliente() {
		return chaveEnderecoCliente;
	}

	public void setChaveEnderecoCliente(ChaveEnderecoCliente chaveEnderecoCliente) {
		this.chaveEnderecoCliente = chaveEnderecoCliente;
	}

	public Integer getCodigoTipoEndereco() {
		return codigoTipoEndereco;
	}

	public void setCodigoTipoEndereco(Integer codigoTipoEndereco) {
		this.codigoTipoEndereco = codigoTipoEndereco;
	}

	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
