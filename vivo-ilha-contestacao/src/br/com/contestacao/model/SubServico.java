package br.com.contestacao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "SUB_SERVICO")
public class SubServico implements AuditEntityPersistence {

	private static final long serialVersionUID = -794510190198951959L;

	@Id
	@Column(name = "SUSE_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUB_SERVICO")
	@SequenceGenerator(name = "SEQ_SUB_SERVICO", sequenceName = "SEQ_SUB_SERVICO", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "SERV_CD_ID_FK", referencedColumnName = "SERV_CD_ID_PK")
	private Servico servico;

	@Column(name = "SUSE_TX_DESC")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "SUSE_BL_ATIVO")
	private SimNaoEnum ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUSE_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUSE_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUSE_DT_EXCLUSAO")
	private Date dataExclusao;

	public SubServico() {
		super();

		this.servico = new Servico();
	}

	public SubServico(SubServico subServico) {
		super();

		setId(subServico.getId());
		setServico(subServico.getServico());
		setDescricao(subServico.getDescricao());
		setAtivo(subServico.getAtivo());
		setDataCriacao(subServico.getDataCriacao());
		setDataAlteracao(subServico.getDataAlteracao());
		setDataExclusao(subServico.getDataExclusao());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SimNaoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNaoEnum ativo) {
		this.ativo = ativo;
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