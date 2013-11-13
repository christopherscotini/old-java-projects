package br.com.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.portal.model.embeddable.Endereco;
import br.com.portal.utils.CpfCnpjUtils;
import br.com.portal.utils.ProjetoUtils;

/**
 * Entity implementation class for Entity: EmpresaEntity
 * 
 */

@Entity
@Table(name = "TB_EMPRESA")
public class EmpresaEntity implements Serializable {

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
		if((telefone1String == null || telefone1String.equals("")) && !(telefone1 == null)){
			return ProjetoUtils.formatarNumTelefoneCelularString(telefone1);
		}
		return telefone1String;
	}
	
	public void setTelefone1String(String telefone1String) {
		this.telefone1String = telefone1String;
	}

	public String getTelefone2String() {
		if((telefone2String == null || telefone2String.equals("")) && !(telefone2 == null)){
			return ProjetoUtils.formatarNumTelefoneCelularString(telefone2);
		}
		return telefone2String;
	}

	public void setTelefone2String(String telefone2String) {
		this.telefone2String = telefone2String;
	}

	public String getTelefone3String() {
		if((telefone3String == null || telefone3String.equals("")) && !(telefone3 == null)){
			return ProjetoUtils.formatarNumTelefoneCelularString(telefone3);
		}
		return telefone3String;
	}

	public void setTelefone3String(String telefone3String) {
		this.telefone3String = telefone3String;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TB_CD_ID_PK")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaEntity other = (EmpresaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
