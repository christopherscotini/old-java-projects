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
@Table(name = "REL_CONTRATO_SERVICO")
public class ContratoServico implements AuditEntityPersistence {

	private static final long serialVersionUID = 6717827117016828118L;

	@Id
	@Column(name = "RECS_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REL_CONTRATO_SERVICO")
	@SequenceGenerator(name = "SEQ_REL_CONTRATO_SERVICO", sequenceName = "SEQ_REL_CONTRATO_SERVICO", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CONT_CD_ID_FK", referencedColumnName = "CONT_CD_ID_PK")
	private Contrato contrato;

	@ManyToOne
	@JoinColumn(name = "SERV_CD_ID_FK", referencedColumnName = "SERV_CD_ID_PK")
	private Servico servico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECS_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECS_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECS_DT_EXCLUSAO")
	private Date dataExclusao;

	public ContratoServico() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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