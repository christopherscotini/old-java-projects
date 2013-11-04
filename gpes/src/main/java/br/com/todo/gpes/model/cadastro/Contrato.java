package br.com.todo.gpes.model.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Contrato")
public class Contrato {
	
	@EmbeddedId
	private ChaveContratoClienteDepartamento chave;
	
	@Column(name = "nuContrato")
	private String numeroContrato;
	
	@Column(name = "dtInicioContrato")
	private Date dtInicioContrato;
	
	@Column(name = "dtFimContrato")
	private Date dtFinalContrato;
	
	@Column(name = "dtProrrogacaoContrato")
	private Date dtProrrogacaoContrato;
	
	@Column(name = "cdIndicadorSituacaoContrato")
	private String situacao;
	
	@Column(name = "dtAtivacaoContrato")
	private Date dtAtivaContrato;
	
	@Column(name = "dtInativacaoContrato")
	private Date dtInativaContrato;
	
	public Contrato(){
		super();
	}

	public Contrato(ChaveContratoClienteDepartamento chave, Contrato contrato) {
		super();
		this.chave = chave;
		this.numeroContrato = contrato.getNumeroContrato();
		this.dtInicioContrato = contrato.getDtInicioContrato();
		this.dtFinalContrato = contrato.getDtFinalContrato();
		this.dtProrrogacaoContrato = contrato.getDtProrrogacaoContrato();
		this.situacao = contrato.getSituacao();
		this.dtAtivaContrato = contrato.getDtAtivaContrato();
		this.dtInativaContrato = contrato.getDtInativaContrato();
	}

	public ChaveContratoClienteDepartamento getChave() {
		return chave;
	}

	public void setChave(ChaveContratoClienteDepartamento chave) {
		this.chave = chave;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Date getDtInicioContrato() {
		return dtInicioContrato;
	}

	public void setDtInicioContrato(Date dtInicioContrato) {
		this.dtInicioContrato = dtInicioContrato;
	}

	public Date getDtFinalContrato() {
		return dtFinalContrato;
	}

	public void setDtFinalContrato(Date dtFinalContrato) {
		this.dtFinalContrato = dtFinalContrato;
	}

	public Date getDtProrrogacaoContrato() {
		return dtProrrogacaoContrato;
	}

	public void setDtProrrogacaoContrato(Date dtProrrogacaoContrato) {
		this.dtProrrogacaoContrato = dtProrrogacaoContrato;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDtAtivaContrato() {
		return dtAtivaContrato;
	}

	public void setDtAtivaContrato(Date dtAtivaContrato) {
		this.dtAtivaContrato = dtAtivaContrato;
	}

	public Date getDtInativaContrato() {
		return dtInativaContrato;
	}

	public void setDtInativaContrato(Date dtInativaContrato) {
		this.dtInativaContrato = dtInativaContrato;
	}
	
}
