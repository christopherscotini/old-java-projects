package br.com.chris.sccgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="Produto.findByProdutoPorSolicitacao", 
		 	query="SELECT s.produtos FROM Solicitacao s"  )	
@Entity
public class Produto {
	
//	A aplicação deve manter um cadastro de produtos contendo
//	nome, descrição, medida de venda do produto (peso, volume ou comprimento). 
//	Para cada solicitação de compra registram-se os itens dessa solicitação,
//	a obra e o responsável (mestre-de-obras) pelo pedido. 
//	Cada item refere-se a um produto e a sua respectiva quantidade.
	
	@Id @GeneratedValue
	@Column(name="prod_id")
	private Long id;
	
	@Column(name="nome_prod", unique=true)
	private String nome;
	
	@Column(name="desc_prod")
	private String descricao;
	
	@Column(name="escala_prod")
	private String medidaDeVenda;//(peso, volume ou comprimento). 
	
	@Column(name="quantidade_prod")
	private Integer quantidadeProduto;//(peso, volume ou comprimento). 

	private boolean comprado;//true = comprado | false = não comprado
	
	private Double valorUnitario;//(peso, volume ou comprimento). 

	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMedidaDeVenda() {
		return medidaDeVenda;
	}

	public void setMedidaDeVenda(String medidaDeVenda) {
		this.medidaDeVenda = medidaDeVenda;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public String getSoma() {
		double res = valorUnitario*quantidadeProduto;
		res = Math.ceil(res);
		return res+"";
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
