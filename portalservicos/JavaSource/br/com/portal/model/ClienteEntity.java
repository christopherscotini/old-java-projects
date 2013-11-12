package br.com.portal.model;

import java.io.Serializable;
import java.util.Date;

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
 * Entity implementation class for Entity: ClienteEntity
 * 
 */

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "USUARIO_FK", nullable = false)
	private UserEntity usuario;
	
	@Column(name = "DS_NOME")
	private String nome;
	
	@Column(name = "NU_CPF", length=11, unique=true)
	private Long cpf;
	
	@Column(name = "NU_TELEFONE")
	private Long numTelefone;

	@Column(name = "NU_CELULAR")
	private Long numCelular;

	@Column(name = "DS_EMAIL")
	private String email;

	@Column(name = "DT_NASCIMENTO")
	private Date dataNascimento;
	
	private Endereco endereco;
	
	public ClienteEntity() {
		super();
	}

	public UserEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(Long numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Long getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(Long numCelular) {
		this.numCelular = numCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Transient
	private String numCpfString;
	@Transient
	private String numTelefoneString;
	@Transient
	private String numCelularString;
	
	public String getNumTelefoneString() {
		if ((numTelefoneString == null || numTelefoneString.equals(""))
				&& !(getNumTelefone() == null)) {
			return ProjetoUtils.formatarNumTelefoneCelularString(getNumTelefone());
		}
		return numTelefoneString;
	}

	public String getNumCelularString() {
		if ((numCelularString == null || numCelularString.equals("")) && !(getNumCelular() == null)) {
			return ProjetoUtils.formatarNumTelefoneCelularString(getNumCelular());
		}
		return numCelularString;
	}
	
	public String getDataNascimentoFormatado() {
		return ProjetoUtils.converterDataString(dataNascimento, "dd/MM/yyyy");
	}
	
	public String getNumCpfString() {
		if((numCpfString == null || numCpfString.equals("")) && !(cpf == null)){
			return CpfCnpjUtils.formatarCpfCnpjString(cpf);
		}
		return numCpfString;
	}

	public void setNumCpfString(String numCpfString) {
		this.numCpfString = numCpfString;
	}

	public void setNumTelefoneString(String numTelefoneString) {
		this.numTelefoneString = numTelefoneString;
	}

	public void setNumCelularString(String numCelularString) {
		this.numCelularString = numCelularString;
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
		ClienteEntity other = (ClienteEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
