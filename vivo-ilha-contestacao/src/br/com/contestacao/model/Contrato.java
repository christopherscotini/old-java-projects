package br.com.contestacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.contestacao.persistence.jpa.AuditEntityPersistence;

@Entity
@Table(name = "CONTRATO")
public class Contrato implements AuditEntityPersistence {

	private static final long serialVersionUID = -3269599640378921012L;

	@Id
	@Column(name = "CONT_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTRATO")
	@SequenceGenerator(name = "SEQ_CONTRATO", sequenceName = "SEQ_CONTRATO", allocationSize = 1)
	private Long id;

	@Column(name = "CONT_TX_CHAVE")
	private String chave;

	@Column(name = "CONT_TX_DESC")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "CLIE_CD_ID_FK", referencedColumnName = "CLIE_CD_ID_PK")
	private Cliente cliente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONT_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONT_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONT_DT_EXCLUSAO")
	private Date dataExclusao;

	@OneToMany(mappedBy = "contrato")
	private List<ContratoServico> servicosContrato;

	public Contrato() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public List<ContratoServico> getServicosContrato() {
		return servicosContrato;
	}

	public void setServicosContrato(List<ContratoServico> servicosContrato) {
		this.servicosContrato = servicosContrato;
	}

	public void addContratoServico(ContratoServico e) {
		if (servicosContrato == null) {
			servicosContrato = new ArrayList<ContratoServico>();
		}

		servicosContrato.add(e);
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