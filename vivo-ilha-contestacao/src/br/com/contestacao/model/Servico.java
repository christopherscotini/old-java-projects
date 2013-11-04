package br.com.contestacao.model;

import static br.com.contestacao.model.ServicoEnum.SMS;
import static br.com.contestacao.model.ServicoEnum.TELEFONIA;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.contestacao.persistence.jpa.AuditEntityPersistence;

@Entity
@Table(name = "SERVICO")
public class Servico implements AuditEntityPersistence {

	private static final long serialVersionUID = 3866034568517445379L;

	@Id
	@Column(name = "SERV_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SERVICO")
	@SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private Long id;

	@Column(name = "SERV_TX_DESC")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "SERV_BL_ATIVO")
	private SimNaoEnum ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SERV_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SERV_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SERV_DT_EXCLUSAO")
	private Date dataExclusao;

	public Servico() {
		super();
	}

	public Servico(Servico servico) {
		super();

		this.id = servico.getId();
		this.descricao = servico.getDescricao();
		this.ativo = servico.getAtivo();
		this.dataCriacao = servico.getDataCriacao();
		this.dataAlteracao = servico.getDataAlteracao();
		this.dataExclusao = servico.getDataExclusao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isTelefonia() {
		return TELEFONIA.getCodigo().equals(id);
	}

	public boolean isSms() {
		return SMS.getCodigo().equals(id);
	}

	public boolean isInternetOutrosServicos() {
		return !isTelefonia() && !isSms();
	}
}