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
@Table(name = "TIPO_TARIFA")
public class TipoTarifa implements AuditEntityPersistence {

	private static final long serialVersionUID = -5202250961049650184L;

	@Id
	@Column(name = "TITA_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_TARIFA")
	@SequenceGenerator(name = "SEQ_TIPO_TARIFA", sequenceName = "SEQ_TIPO_TARIFA", allocationSize = 1)
	private Long id;

	@Column(name = "TITA_NM_TIPO_TARIFA")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "SERV_CD_ID_FK", referencedColumnName = "SERV_CD_ID_PK")
	private Servico servico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TITA_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TITA_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TITA_DT_EXCLUSAO")
	private Date dataExclusao;

	public TipoTarifa() {
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