package br.com.utmanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FINANCA")
public class Financa implements Serializable{

	private static final long serialVersionUID = -9060022568667921599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "VL_MOVIMENTADO")
	private BigDecimal valorMovimentado;
	
	@Column(name = "VL_SALDO")
	private BigDecimal valorAtual;

	@Column(name = "DT_MOVIMENTACAO")
	private Date dataMovimentacao;
	
	@Column(name = "TP_MOVIMENTACAO")
	@Enumerated(EnumType.STRING)
	private TipoMovimentacaoEnum tipoMovimentacao;
	
	public Financa() {

	}
	
	public Financa(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorMovimentado() {
		return valorMovimentado;
	}

	public void setValorMovimentado(BigDecimal valorMovimentado) {
		this.valorMovimentado = valorMovimentado;
	}

	public BigDecimal getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(BigDecimal valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMovimentacaoEnum getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEnum tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}
