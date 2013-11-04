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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.contestacao.persistence.jpa.AuditEntityPersistence;

@Entity
@Table(name = "PERMISSAO")
public class Permissao implements AuditEntityPersistence {

	private static final long serialVersionUID = 4638096896342644175L;

	@Id
	@Column(name = "PERM_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERMISSAO")
	@SequenceGenerator(name = "SEQ_PERMISSAO", sequenceName = "SEQ_PERMISSAO", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "TELA_CD_ID_FK", referencedColumnName = "TELA_CD_ID_PK")
	private Tela tela;

	@ManyToOne
	@JoinColumn(name = "ACAO_CD_ID_FK", referencedColumnName = "ACAO_CD_ID_PK")
	private Acao acao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERM_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERM_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERM_DT_EXCLUSAO")
	private Date dataExclusao;

	public Permissao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tela getTela() {
		return tela;
	}

	public void setTela(Tela tela) {
		this.tela = tela;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
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
		return getPrimaryKey();
	}

	@Override
	public void setCreatedDate(Date date) {
		setCreatedDate(date);
	}

	@Override
	public void setUpdatedDate(Date date) {
		setUpdatedDate(date);
	}
}
