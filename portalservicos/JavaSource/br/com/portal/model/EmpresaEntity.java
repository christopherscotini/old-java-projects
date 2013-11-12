package br.com.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.portal.model.embeddable.Endereco;
import br.com.portal.utils.CpfCnpjUtils;

/**
 * Entity implementation class for Entity: EmpresaEntity
 * 
 */

@Entity
@Table(name = "TB_EMPRESA")
public class EmpresaEntity extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "USUARIO_FK")
	private UserEntity usuario;

	@Column(name = "NU_CNPJ", length=14, unique=true)
	private long cnpj;
	
	@Column(name = "DS_RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "NU_TELEFONE_1")
	private Long telefone1;
	
	@Column(name = "NU_TELEFONE_2")
	private Long telefone2;
	
	@Column(name = "NU_TELEFONE_3")
	private Long telefone3;
	
	private Endereco endereco;
	
	@Transient
	private String cnpjString;
	@Transient
	private String telefone1String;
	@Transient
	private String telefone2String;
	@Transient
	private String telefone3String;
	
	public EmpresaEntity() {
		super();
	}

	public UserEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpjString() {
		if((cnpjString == null || cnpjString.equals(""))){
			return CpfCnpjUtils.formatarCpfCnpjString(cnpj);
		}
		return cnpjString;
	}

	public void setCnpjString(String numCpfString) {
		this.cnpjString = numCpfString;
	}

	public Long getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(Long telefone1) {
		this.telefone1 = telefone1;
	}

	public Long getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(Long telefone2) {
		this.telefone2 = telefone2;
	}

	public Long getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(Long telefone3) {
		this.telefone3 = telefone3;
	}

	public String getTelefone1String() {
		return telefone1String;
	}

	public void setTelefone1String(String telefone1String) {
		this.telefone1String = telefone1String;
	}

	public String getTelefone2String() {
		return telefone2String;
	}

	public void setTelefone2String(String telefone2String) {
		this.telefone2String = telefone2String;
	}

	public String getTelefone3String() {
		return telefone3String;
	}

	public void setTelefone3String(String telefone3String) {
		this.telefone3String = telefone3String;
	}
	
}
