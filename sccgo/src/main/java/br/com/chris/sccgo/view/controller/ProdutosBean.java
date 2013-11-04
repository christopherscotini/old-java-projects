package br.com.chris.sccgo.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.chris.sccgo.model.Obra;
import br.com.chris.sccgo.model.Produto;
import br.com.chris.sccgo.model.Solicitacao;
import br.com.chris.sccgo.persistence.dao.cadastro.IObraDao;
import br.com.chris.sccgo.persistence.dao.cadastro.IProdutoDao;
import br.com.chris.sccgo.persistence.dao.cadastro.ISolicitacaoDao;
import br.com.chris.sccgo.persistence.dao.jpa.cadastro.ObraDaoImpl;
import br.com.chris.sccgo.persistence.dao.jpa.cadastro.ProdutoDaoImpl;
import br.com.chris.sccgo.persistence.dao.jpa.cadastro.SolicitacaoDaoImpl;



@ManagedBean(name="produtoBean")
@SessionScoped
public class ProdutosBean {
	private final String CONSULTAR_PRODUTOS = "/content/produto/conProdutos";
	
	private final String CONSULTAR_SOLICITACOES = "/content/solicitacao/conSolicitacoes";
	private final String DET_SOLICITACAO= "/content/solicitacao/detSolicitacao";
	private final String NOVA_SOLICITACAO= "/content/solicitacao/incAltSolicitacao";
	private final String ADD_PRODUTO_SOLICITACAO= "/content/solicitacao/cadProdutoSolicitacao";

	private final String ADD_OBRA = "/content/obra/incAltObra";
	
	
	private IProdutoDao daoProduto;
	private ISolicitacaoDao daoSolicitacao;
	private IObraDao daoObra;
	
	private Produto produto;
	private List<Produto>listaDeProdutos;
	private List<SelectItem>listaRadioProdutos;
	private Integer produtoRadioSelecionado;

	private Solicitacao solicitacao;
	private List<Solicitacao>listaDeSolicitacoes;
	private List<SelectItem>listaRadioSolicitacoes;
	private Integer solicitacaoRadioSelecionada;
	private List<Produto>listaDeProdutosDaSolicitacao;
	private boolean statusSolicitacao; 

	private Obra obra;
	private List<Obra> listaDeObra;
	private List<SelectItem>obraSelectItem;
	private Integer obraComboSelecionada;
	
	private boolean flagCadastrar; 
	private boolean pendentesFinalizadas; //SE FALSE=pendente SE TRUE=finalizada


	private String tituloTelaIncAltSolicitacao;
	
	
	public ProdutosBean() {
		carregarListaObras();
		solicitacaoRadioSelecionada = null;
	}
	
/*
 * METODOS PARA TRATAMNTO DA VERTENTE PRODUTO 
 */
	
	public String consultadeProdutos(){
		daoProduto = new ProdutoDaoImpl();
		listaDeProdutos = daoProduto.findAll();
		gerarRadioProdutos();
		return CONSULTAR_PRODUTOS;
	}
	
	public void trocarStatusProduto() {
		if(listaDeProdutos.get(produtoRadioSelecionado).isComprado())
			listaDeProdutos.get(produtoRadioSelecionado).setComprado(false);
		else 
			listaDeProdutos.get(produtoRadioSelecionado).setComprado(true);
		atualizaStatusProduto();
	}
	
	public void atualizaStatusProduto() {
		daoSolicitacao = new SolicitacaoDaoImpl();
		listaDeSolicitacoes.get(solicitacaoRadioSelecionada).setProdutos(listaDeProdutos);
		daoSolicitacao.update(listaDeSolicitacoes.get(solicitacaoRadioSelecionada));
	}
	
	public void gerarRadioProdutos(){
		listaRadioProdutos = new ArrayList<SelectItem>();
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			listaRadioProdutos.add(new SelectItem(i,""));
		}
	}
/*
 * METODOS PARA TRATAMNTO DA VERTENTE SOLICITAÇÃO
 */

	public String consultaSolicitacoes(){
		daoSolicitacao = new SolicitacaoDaoImpl();
		listaDeSolicitacoes = new ArrayList<Solicitacao>();
		listaDeSolicitacoes = daoSolicitacao.findAll();
		gerarRadioSolicitacoes();
		
		return CONSULTAR_SOLICITACOES;
	}
	
	public String novaSolicitacaoDeCompra(){
		solicitacao = new Solicitacao();
		flagCadastrar = true;
		tituloTelaIncAltSolicitacao = "Nova Solicitação";
		return NOVA_SOLICITACAO;
	}
	
	public String telaAddProdutoNaSolicitacaoDeCompra(){
		produto = new Produto();
		return ADD_PRODUTO_SOLICITACAO;
	}
	
	public String adicionarProdutoNaSolicitacaoDeCompra(){
		solicitacao.getProdutos().add(produto);
		return NOVA_SOLICITACAO;
	}
	
	public String salvarSolicitacaoDeCompra(){
		daoSolicitacao = new SolicitacaoDaoImpl();
		solicitacao.setObra(listaDeObra.get(obraComboSelecionada));
		daoSolicitacao.insert(solicitacao);
		return consultaSolicitacoes();
	}

	public String detalharSolcitacao(){
		listaDeProdutos = new ArrayList<Produto>();
		listaDeProdutos = listaDeSolicitacoes.get(solicitacaoRadioSelecionada).getProdutos();
		gerarRadioProdutos();
		return DET_SOLICITACAO;
	}
	
	public void trocarStatusSolicitacao() {
		if(listaDeSolicitacoes.get(solicitacaoRadioSelecionada).isComprado())
			listaDeSolicitacoes.get(solicitacaoRadioSelecionada).setComprado(false);
		else 
			listaDeSolicitacoes.get(solicitacaoRadioSelecionada).setComprado(true);
		atualizaStatusSolicitacao();
	}
	
	public void atualizaStatusSolicitacao() {
		daoSolicitacao = new SolicitacaoDaoImpl();
		daoSolicitacao.update(listaDeSolicitacoes.get(solicitacaoRadioSelecionada));
	}
	
	public String voltar_detSolicitacao(){
		return CONSULTAR_SOLICITACOES;
	}
	
	public String consultarSolicitacoesStatus() {
		daoSolicitacao = new SolicitacaoDaoImpl();
		listaDeSolicitacoes = new ArrayList<Solicitacao>();
		if(pendentesFinalizadas)
			listaDeSolicitacoes = daoSolicitacao.findBySolicitacoesFinalizadas();
		else
			listaDeSolicitacoes = daoSolicitacao.findBySolicitacoesPendentes();
		
		gerarRadioSolicitacoes();
		return CONSULTAR_SOLICITACOES;
	}

	public void gerarRadioSolicitacoes(){
		listaRadioSolicitacoes = new ArrayList<SelectItem>();
		for (int i = 0; i < listaDeSolicitacoes.size(); i++) {
			listaRadioSolicitacoes.add(new SelectItem(i,""));
		}
		System.out.println("listaDeSolicitacoes: "+listaDeSolicitacoes.size());
	}
	
/*
 * METODOS PARA TRATAMNTO DA VERTENTE OBRA
 */
	public String maisObra(){
		obra = new Obra();
		return ADD_OBRA;
	}
	
	public String salvarObra(){
		daoObra = new ObraDaoImpl();
		daoObra.insert(obra);
		carregarListaObras();
		return CONSULTAR_SOLICITACOES;
	}
	
	public void carregarListaObras(){
		daoObra = new ObraDaoImpl();
		listaDeObra = new ArrayList<Obra>();
		obraSelectItem = new ArrayList<SelectItem>();
		
		listaDeObra = daoObra.findAll();
		for (int i = 0; i < listaDeObra.size(); i++) {
			obraSelectItem.add(new SelectItem(i, listaDeObra.get(i).getNome()));
		}
	}
	
	
/**********************************************************************************************************
*							GETTERS AND SETTERS
**********************************************************************************************************/
	public IProdutoDao getDaoProduto() {
		return daoProduto;
	}
	public void setDaoProduto(IProdutoDao daoProduto) {
		this.daoProduto = daoProduto;
	}
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
	public List<SelectItem> getListaRadioProdutos() {
		return listaRadioProdutos;
	}
	public void setListaRadioProdutos(List<SelectItem> listaRadioProdutos) {
		this.listaRadioProdutos = listaRadioProdutos;
	}


	public ISolicitacaoDao getDaoSolicitacao() {
		return daoSolicitacao;
	}


	public void setDaoSolicitacao(ISolicitacaoDao daoSolicitacao) {
		this.daoSolicitacao = daoSolicitacao;
	}


	public List<Solicitacao> getListaDeSolicitacoes() {
		return listaDeSolicitacoes;
	}


	public void setListaDeSolicitacoes(List<Solicitacao> listaDeSolicitacoes) {
		this.listaDeSolicitacoes = listaDeSolicitacoes;
	}


	public List<SelectItem> getListaRadioSolicitacoes() {
		return listaRadioSolicitacoes;
	}


	public void setListaRadioSolicitacoes(List<SelectItem> listaRadioSolicitacoes) {
		this.listaRadioSolicitacoes = listaRadioSolicitacoes;
	}

	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public boolean isFlagCadastrar() {
		return flagCadastrar;
	}

	public void setFlagCadastrar(boolean flagCadastrar) {
		this.flagCadastrar = flagCadastrar;
	}

	public String getTituloTelaIncAltSolicitacao() {
		return tituloTelaIncAltSolicitacao;
	}

	public void setTituloTelaIncAltSolicitacao(String tituloTelaIncAltSolicitacao) {
		this.tituloTelaIncAltSolicitacao = tituloTelaIncAltSolicitacao;
	}

	public IObraDao getDaoObra() {
		return daoObra;
	}

	public void setDaoObra(IObraDao daoObra) {
		this.daoObra = daoObra;
	}

	public List<Obra> getListaDeObra() {
		return listaDeObra;
	}

	public void setListaDeObra(List<Obra> listaDeObra) {
		this.listaDeObra = listaDeObra;
	}

	public List<SelectItem> getObraSelectItem() {
		return obraSelectItem;
	}

	public void setObraSelectItem(List<SelectItem> obraSelectItem) {
		this.obraSelectItem = obraSelectItem;
	}

	
	public Integer getObraComboSelecionada() {
		return obraComboSelecionada;
	}

	public void setObraComboSelecionada(Integer obraComboSelecionada) {
		this.obraComboSelecionada = obraComboSelecionada;
	}

	public Integer getSolicitacaoRadioSelecionada() {
		return solicitacaoRadioSelecionada;
	}

	public void setSolicitacaoRadioSelecionada(Integer solicitacaoRadioSelecionada) {
		this.solicitacaoRadioSelecionada = solicitacaoRadioSelecionada;
	}

	public List<Produto> getListaDeProdutosDaSolicitacao() {
		return listaDeProdutosDaSolicitacao;
	}

	public void setListaDeProdutosDaSolicitacao(
			List<Produto> listaDeProdutosDaSolicitacao) {
		this.listaDeProdutosDaSolicitacao = listaDeProdutosDaSolicitacao;
	}

	public boolean isStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(boolean statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public boolean isPendentesFinalizadas() {
		return pendentesFinalizadas;
	}

	public void setPendentesFinalizadas(boolean pendentesFinalizadas) {
		this.pendentesFinalizadas = pendentesFinalizadas;
	}

	public Integer getProdutoRadioSelecionado() {
		return produtoRadioSelecionado;
	}

	public void setProdutoRadioSelecionado(Integer produtoRadioSelecionado) {
		this.produtoRadioSelecionado = produtoRadioSelecionado;
	}
	
	
	
	
}
