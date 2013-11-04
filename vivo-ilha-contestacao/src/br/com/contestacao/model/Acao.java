package br.com.contestacao.model;

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

@Entity
@Table(name = "ACAO")
public class Acao {

	@Id
	@Column(name = "ACAO_CD_ID_PK")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACAO")
	@SequenceGenerator(name = "SEQ_ACAO", sequenceName = "SEQ_ACAO", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "TELA_CD_ID_FK", referencedColumnName = "TELA_CD_ID_PK")
	private Tela tela;

	@Column(name = "ACAO_NM_NOME")
	private String nome;

	@Column(name = "ACAO_DT_CRIACAO")
	private Date dataCriacao;

	@Column(name = "ACAO_DT_ALTERACAO")
	private Date dataAlteracao;

	@Column(name = "ACAO_DT_EXCLUSAO")
	private Date dataExclusao;

	public Acao() {
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
}