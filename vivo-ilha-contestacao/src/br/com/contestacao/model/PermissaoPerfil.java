package br.com.contestacao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.contestacao.persistence.jpa.AuditEntityPersistence;

@Entity
@Table(name = "REL_PERMISSAO_PERFIL")
public class PermissaoPerfil implements AuditEntityPersistence {

	private static final long serialVersionUID = 723983225472767456L;

	@Id
	@Column(name = "REPP_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REL_PERMISSAO_PERFIL")
	@SequenceGenerator(name = "SEQ_REL_PERMISSAO_PERFIL", sequenceName = "SEQ_REL_PERMISSAO_PERFIL", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PERF_CD_ID_FK", referencedColumnName = "PERF_CD_ID_PK")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "PERM_CD_ID_FK", referencedColumnName = "PERM_CD_ID_PK")
	private Permissao permissao;

	@Column(name = "REPP_DT_CRIACAO")
	private Date dataCriacao;

	@Column(name = "REPP_DT_ALTERACAO")
	private Date dataAlteracao;

	@Column(name = "REPP_DT_EXCLUSAO")
	private Date dataExclusao;

	public PermissaoPerfil() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
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
