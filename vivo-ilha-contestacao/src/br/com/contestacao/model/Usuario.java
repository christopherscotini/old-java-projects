package br.com.contestacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.contestacao.persistence.jpa.AuditEntityPersistence;

@Entity
@Table(name = "USUARIO")
public class Usuario implements AuditEntityPersistence {

	private static final long serialVersionUID = 4465690882497127961L;

	@Id
	@Column(name = "USUA_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	private Long id;

	@Column(name = "USUA_TX_LOGIN")
	private String login;

	@Column(name = "USUA_TX_SENHA")
	private String senha;

	@Column(name = "USUA_TX_CPF")
	private Long cpf;

	@Column(name = "USUA_NM_NOME")
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "USUA_BL_ADMIN")
	private SimNaoEnum admin;

	@Column(name = "USUA_NR_TENTATIVA_LOG")
	private Long tentativaLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USUA_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USUA_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USUA_DT_EXCLUSAO")
	private Date dataExclusao;

	@OneToMany(mappedBy="usuario", cascade={CascadeType.ALL})
	private List<UsuarioPerfil> usuarioPerfil;

	public Usuario() {
		super();
	}

	public Usuario(Usuario u) {
		super();

		this.id = u.getId();
		this.login = u.getLogin();
		this.senha = u.getSenha();
		this.cpf = u.getCpf();
		this.nome = u.getNome();
		this.admin = u.getAdmin();
		this.tentativaLog = u.getTentativaLog();
		this.dataCriacao = u.getDataCriacao();
		this.dataAlteracao = u.getDataAlteracao();
		this.dataExclusao = u.getDataExclusao();
		this.usuarioPerfil = u.getUsuarioPerfil();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SimNaoEnum getAdmin() {
		return admin;
	}

	public void setAdmin(SimNaoEnum admin) {
		this.admin = admin;
	}

	public Long getTentativaLog() {
		return tentativaLog;
	}

	public void setTentativaLog(Long tentativaLog) {
		this.tentativaLog = tentativaLog;
	}

	public List<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(List<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public void addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		if (this.usuarioPerfil == null) {
			this.usuarioPerfil = new ArrayList<UsuarioPerfil>();
		}

		this.usuarioPerfil.add(usuarioPerfil);
	}

	public Perfil getPerfil() {
		if (this.usuarioPerfil != null && !this.usuarioPerfil.isEmpty()) {
			return this.usuarioPerfil.iterator().next().getPerfil();
		}

		return null;
	}

	public String getNomePerfil() {
		Perfil p = getPerfil();
		if (p != null) {
			return p.getNome();
		}
		return "";
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	@Override
	public Serializable getPrimaryKey() {
		return getId();
	}

	@Override
	public void setCreatedDate(Date date) {
		setDataCriacao(date);
	}

	@Override
	public void setUpdatedDate(Date date) {
		setDataAlteracao(date);
	}
}