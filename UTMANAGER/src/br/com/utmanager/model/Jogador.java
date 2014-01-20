package br.com.utmanager.model;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_JOGADORES_PLANTEL")
public class Jogador implements Serializable{
	
	private static final long serialVersionUID = 5639808484822665104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "DS_POSICAO")
	private PosicaoJogador posicao; 

	@Column(name = "DS_NOME")
	private String nomeJogador; 
	
	@ManyToOne
	@JoinColumn(name = "STATUS_FK")
	private StatusJogador status;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_FK")
	private CategoriaJogador categoria;
	
	@Column(name = "NU_RATING")
	private Integer rating; 
	
	@ManyToOne
	@JoinColumn(name = "NACIONALIDADE_FK")
	private NacionalidadeJogador nacionalidade;
	
	@ManyToOne
	@JoinColumn(name = "LIGA_FK")
	private LigaJogador liga;
	
	@ManyToOne
	@JoinColumn(name = "CLUBE_FK")
	private ClubeJogador clube;
	
	@Column(name = "VLR_PAGO")
	private BigDecimal valorPago;
	
	@Column(name = "VLR_SUG_VENDA")
	private BigDecimal valorMinSugeridoVenda;
	
	@Column(name = "VLR_VENDA")
	private BigDecimal valorVenda;
	
	@Column(name = "VLR_LUCRO")
	private BigDecimal lucro;
	
	@Column(name = "DT_ENTRADA")
	private Date dataEntrada;

	@Column(name = "DT_ALTERACAO")
	private Date dataAlteracao;

	@Column(name = "DT_SAIDA")
	private Date dataSaida;

	@Transient
	private boolean leilao;
	
	public Jogador() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PosicaoJogador getPosicao() {
		return posicao;
	}


	public void setPosicao(PosicaoJogador posicao) {
		this.posicao = posicao;
	}


	public String getNomeJogador() {
		return nomeJogador;
	}


	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}


	public StatusJogador getStatus() {
		return status;
	}


	public void setStatus(StatusJogador status) {
		this.status = status;
	}


	public CategoriaJogador getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaJogador categoria) {
		this.categoria = categoria;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public NacionalidadeJogador getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(NacionalidadeJogador nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public LigaJogador getLiga() {
		return liga;
	}


	public void setLiga(LigaJogador liga) {
		this.liga = liga;
	}


	public ClubeJogador getClube() {
		return clube;
	}


	public void setClube(ClubeJogador clube) {
		this.clube = clube;
	}


	public BigDecimal getValorPago() {
		return valorPago;
	}


	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}


	public BigDecimal getValorMinSugeridoVenda() {
		return valorMinSugeridoVenda;
	}


	public void setValorMinSugeridoVenda(BigDecimal valorMinSugeridoVenda) {
		this.valorMinSugeridoVenda = valorMinSugeridoVenda;
	}


	public BigDecimal getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}


	public BigDecimal getLucro() {
		return lucro;
	}


	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public Date getDataAlteracao() {
		return dataAlteracao;
	}


	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public Date getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Transient
	public boolean isVendido(){
		return getDataSaida()==null?false:true;
	}


	public boolean isLeilao() {
		return leilao;
	}


	public void setLeilao(boolean leilao) {
		this.leilao = leilao;
	}
	
}
