package br.com.contestacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PERFIL")
public class Perfil implements AuditEntityPersistence {

	private static final long serialVersionUID = -1214294857980422553L;

	@Id
	@Column(name = "PERF_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERFIL")
	@SequenceGenerator(name = "SEQ_PERFIL", sequenceName = "SEQ_PERFIL", allocationSize = 1)
	private Long id;

	@Column(name = "PERF_NM_NOME")
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERF_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERF_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERF_DT_EXCLUSAO")
	private Date dataExclusao;

	@OneToMany(mappedBy="perfil", cascade={CascadeType.PERSIST})
	private List<PermissaoPerfil> permissoesPerfil;

	public Perfil() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<PermissaoPerfil> getPermissoesPerfil() {
		return permissoesPerfil;
	}

	public void setPermissoesPerfil(List<PermissaoPerfil> permissoesPerfil) {
		this.permissoesPerfil = permissoesPerfil;
	}

	public void addPermissaoPerfil(PermissaoPerfil e) {
		if (permissoesPerfil == null) {
			 permissoesPerfil = new ArrayList<PermissaoPerfil>();
		}

		permissoesPerfil.add(e);
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