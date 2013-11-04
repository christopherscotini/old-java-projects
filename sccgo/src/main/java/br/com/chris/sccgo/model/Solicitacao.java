package br.com.chris.sccgo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({@NamedQuery(name="Solicitacao.findBySolicitacoesPendentes",
					query="SELECT s FROM Solicitacao s WHERE s.comprado = 0"), 
			   @NamedQuery(name="Solicitacao.findBySolicitacoesFinalizadas", 
			   		query="SELECT s FROM Solicitacao s WHERE s.comprado = 1")
			 })
@Entity
public class Solicitacao {
//	Para cada solicitação de compra registram-se os itens dessa solicitação,
//	a obra e o responsável (mestre-de-obras) pelo pedido. 
//	Cada item refere-se a um produto e a sua respectiva quantidade.

	@Id @GeneratedValue
	@Column(name="solic_id")
	private Long id;
	
	@Column(name="item_id")
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Produto>produtos = new ArrayList<Produto>();//itens
	
	@OneToOne
	private Obra obra;
	
	private boolean comprado;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	
	
}
