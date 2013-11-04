package br.com.todo.gpes.model.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoContato")
public class TipoContato {
	
	@Id
	@Column(name = "cdTipoContato")
	private Integer codigoTipoContato;
	
	@Column(name = "dsTipoContato")
	private String descTipoContato;
	
	@Column(name = "dtAtivacaoTipoContato")
	private Date dtAtivo;
	
	@Column(name = "dtInativacaoTipoContato")
	private Date dtInativo;
	
	@Column(name = "cdIndicadorSituacaoTipoContato")
	private String situacao;

	public TipoContato() {
		super();
	}

	public TipoContato(TipoContato tipoContato) {
		super();
		this.codigoTipoContato = tipoContato.getCodigoTipoContato();
		this.descTipoContato = tipoContato.getDescTipoContato();
		this.dtAtivo = tipoContato.getDtAtivo();
		this.dtInativo = tipoContato.getDtInativo();
		this.situacao = tipoContato.getSituacao();
	}

	public Integer getCodigoTipoContato() {
		return codigoTipoContato;
	}

	public void setCodigoTipoContato(Integer codigoTipoContato) {
		this.codigoTipoContato = codigoTipoContato;
	}

	public String getDescTipoContato() {
		return descTipoContato;
	}

	public void setDescTipoContato(String descTipoContato) {
		this.descTipoContato = descTipoContato;
	}

	public Date getDtAtivo() {
		return dtAtivo;
	}

	public void setDtAtivo(Date dtAtivo) {
		this.dtAtivo = dtAtivo;
	}

	public Date getDtInativo() {
		return dtInativo;
	}

	public void setDtInativo(Date dtInativo) {
		this.dtInativo = dtInativo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getDescSituacao() {
		AtivoInativoEnum ativoInativoEnum = AtivoInativoEnum.getAtivoInativoByCodigo(situacao);
		if (ativoInativoEnum != null) {
			return ativoInativoEnum.toString();
		}
		return "";
	}
	
}
