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
@Table(name = "CLIENTE")
public class Cliente implements AuditEntityPersistence {

	private static final long serialVersionUID = 6072100852022266569L;

	@Id
	@Column(name = "CLIE_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Long id;

	@Column(name = "CLIE_TX_CNPJ")
	private String cnpj;

	@Column(name = "CLIE_NM_CLIENTE")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "UF_CD_ID_FK", referencedColumnName = "UF_CD_ID_PK")
	private Uf uf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLIE_DT_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLIE_DT_ALTERACAO")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLIE_DT_EXCLUSAO")
	private Date dataExclusao;

	public Cliente() {
		super();
		
		this.uf = new Uf();
	}

	public Cliente(Cliente cliente) {
		super();

		setId(cliente.getId());
		setCnpj(cliente.getCnpj());
		setNome(cliente.getNome());
		setUf(cliente.getUf());
		setDataCriacao(cliente.getDataAlteracao());
		setDataAlteracao(cliente.getDataAlteracao());
		setDataExclusao(cliente.getDataExclusao());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
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