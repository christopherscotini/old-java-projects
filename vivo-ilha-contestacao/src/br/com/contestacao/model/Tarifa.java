package br.com.contestacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TARIFA")
public class Tarifa implements AuditEntityPersistence {

	private static final long serialVersionUID = 6296108949605507669L;

	@Id
	@Column(name = "TARI_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TARIFA")
	@SequenceGenerator(name = "SEQ_TARIFA", sequenceName = "SEQ_TARIFA", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CONT_CD_ID_FK", referencedColumnName = "CONT_CD_ID_PK")
	private Contrato contrato;

	@ManyToOne
	@JoinColumn(name = "TITA_CD_ID_FK", referencedColumnName = "TITA_CD_ID_PK")
	private TipoTarifa tipoTarifa;

	@ManyToOne
	@JoinColumn(name = "SUSE_CD_ID_FK", referencedColumnName = "SUSE_CD_ID_PK")
	private SubServico subServico;

	@Column(name = "TARI_NR_VALOR")
	private BigDecimal valor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TARI_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TARI_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TARI_DT_EXCLUSAO")
	private Date dataExclusao;

	public Tarifa() {
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

	public TipoTarifa getTipoTarifa() {
		return tipoTarifa;
	}

	public void setTipoTarifa(TipoTarifa tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}

	public SubServico getSubServico() {
		return subServico;
	}

	public void setSubServico(SubServico subServico) {
		this.subServico = subServico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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