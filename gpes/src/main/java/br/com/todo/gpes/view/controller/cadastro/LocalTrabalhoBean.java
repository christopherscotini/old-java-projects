package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.Cliente;
import br.com.todo.gpes.model.cadastro.LocalTrabalho;

@ManagedBean(name="localTrabalhoBean")
@SessionScoped
public class LocalTrabalhoBean {
	private List<LocalTrabalho> listaLocalTrabalho;
	private boolean cadastrar; // SE TRUE vai para tela de CADASTRO
	private String tituloTelaIncluirAlterar;
	private List<SelectItem> listaSelectItemLocalTrabalho;
	private LocalTrabalho localTrabalho;
	
	private String comboCliente;
	private String comboLocal;
	
	
	private Integer itemSelecionadoLocalTrabalho;
	private final String CONSULTAR_LOCAL_TRABALHO = "/content/cadastros/localTrabalho/conLocalTrabalho";
	private final String INCLUIR_ALTERAR = "/content/cadastros/localTrabalho/incAltLocalTrabalho";

	public String consultarLocalTrabalho() {
		carregarLocalTrabalho();
		return CONSULTAR_LOCAL_TRABALHO;
	}

	public void carregarLocalTrabalho() {
		setListaLocalTrabalho(new ArrayList<LocalTrabalho>());
		LocalTrabalho obj = new LocalTrabalho();
		obj.setDescricao("descricao");
		obj.setCliente("Banco Bradesco");
		obj.setStatus(true);
		getListaLocalTrabalho().add(obj);
		
		obj = new LocalTrabalho();
		obj.setDescricao("descricao");
		obj.setCliente("Banco Bradesco");
		obj.setStatus(true);
		getListaLocalTrabalho().add(obj);
		carregaListaRadios();
	}
	
	public void carregaListaRadios(){
		setListaSelectItemLocalTrabalho(new ArrayList<SelectItem>());
		for (int i = 0; i < getListaLocalTrabalho().size(); i++) {
			getListaSelectItemLocalTrabalho().add(new SelectItem(i,""));
		}
	}
	
	public String cadastrarLocalTrabalho() {
		setCadastrar(true);
		localTrabalho = new LocalTrabalho();
		setTituloTelaIncluirAlterar("Inclusão de Locais de Trabalho");
		return INCLUIR_ALTERAR;
	}

	public String alterarLocalTrabalho() {
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alteração de Locais de Trabalho");
		localTrabalho = new LocalTrabalho(listaLocalTrabalho.get(itemSelecionadoLocalTrabalho));
		return INCLUIR_ALTERAR;
	}

	public String salvarLocalTrabalho() {
		if(isCadastrar()){
			getListaLocalTrabalho().add(getLocalTrabalho());
		}else{
			getListaLocalTrabalho().set(getItemSelecionadoLocalTrabalho(), getLocalTrabalho());
		}
		carregaListaRadios();
		setItemSelecionadoLocalTrabalho(null);
		localTrabalho = new LocalTrabalho();
		return CONSULTAR_LOCAL_TRABALHO;
	}
	
	public String limpar(){
		localTrabalho = new LocalTrabalho();
		return INCLUIR_ALTERAR;
	}
	
	public String voltar() {
		return CONSULTAR_LOCAL_TRABALHO;
	}

	/************************
	 * GETTERS AND SETTERS
	 ************************/

	public List<LocalTrabalho> getListaLocalTrabalho() {
		return listaLocalTrabalho;
	}

	public void setListaLocalTrabalho(List<LocalTrabalho> listaLocalTrabalho) {
		this.listaLocalTrabalho = listaLocalTrabalho;
	}

	public boolean isCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}

	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}

	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}

	public List<SelectItem> getListaSelectItemLocalTrabalho() {
		return listaSelectItemLocalTrabalho;
	}

	public void setListaSelectItemLocalTrabalho(List<SelectItem> listaSelectItemLocalTrabalho) {
		this.listaSelectItemLocalTrabalho = listaSelectItemLocalTrabalho;
	}

	public Integer getItemSelecionadoLocalTrabalho() {
		return itemSelecionadoLocalTrabalho;
	}

	public void setItemSelecionadoLocalTrabalho(Integer itemSelecionadoLocalTrabalho) {
		this.itemSelecionadoLocalTrabalho = itemSelecionadoLocalTrabalho;
	}

	public List<SelectItem> getListaSelectItemComboCliente() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i = 1 ; i< 3; i++){
			lista.add(new SelectItem("Cliente "+i,"Cliente"+i));
		}
		return lista;
	}

	public List<SelectItem> getListaSelectItemComboLocal() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i = 1; i< 3; i++){
			lista.add(new SelectItem("Local "+i,"Local "+i));
		}
		return lista;
	}

	public String getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(String comboCliente) {
		this.comboCliente = comboCliente;
	}

	public String getComboLocal() {
		return comboLocal;
	}

	public void setComboLocal(String comboLocal) {
		this.comboLocal = comboLocal;
	}

	public LocalTrabalho getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(LocalTrabalho localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

}
