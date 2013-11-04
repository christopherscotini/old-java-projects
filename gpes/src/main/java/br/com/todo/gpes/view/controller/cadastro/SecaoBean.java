package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.Secao;

@ManagedBean(name="secaoBean")
@SessionScoped
public class SecaoBean {
	private List<Secao> listaSecao;
	private boolean cadastrar; 
	private String tituloTelaIncluirAlterar;
	private List<SelectItem> listaSelectItemSecao;
	private Secao secao = new Secao();
	
	private String comboDepartamento;
	private String comboLocal;
	
	private Integer itemSelecionadoSecao;
	private final String CONSULTAR_SECAO = "/content/cadastros/secao/conSecao";
	private final String INCLUIR_ALTERAR = "/content/cadastros/secao/incAltSecao";

	public String consultarSecao() {
		carregarSecao();
		return CONSULTAR_SECAO;
	}

	public void carregarSecao() {
		setListaSecao(new ArrayList<Secao>());
		Secao obj = new Secao();
		obj.setDepartamento("fabrica");
		obj.setSecao("secao1");
		obj.setStatus(true);
		getListaSecao().add(obj);
		
		obj = new Secao();
		obj.setDepartamento("administracao");
		obj.setSecao("secao2");
		obj.setStatus(true);
		getListaSecao().add(obj);
		carregaListaRadios();
	}
	
	public void carregaListaRadios(){
		setListaSelectItemSecao(new ArrayList<SelectItem>());
		for (int i = 0; i < getListaSecao().size(); i++) {
			getListaSelectItemSecao().add(new SelectItem(i,""));
		}
	}
	
	public String cadastrarSecao() {
		secao = new Secao();
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inclusão de Seções");
		return INCLUIR_ALTERAR;
	}

	public String alterarSecao() {
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alteração de Seções");
		secao = new Secao(listaSecao.get(itemSelecionadoSecao));
		return INCLUIR_ALTERAR;
	}

	public String salvarSecao() {
		if(isCadastrar()){
			getListaSecao().add(getSecao());
		}else{
			getListaSecao().set(getItemSelecionadoSecao(), getSecao());
		}
		carregaListaRadios();
		setItemSelecionadoSecao(null);
		secao = new Secao();
		return CONSULTAR_SECAO;
	}
	
	public String voltar() {
		return CONSULTAR_SECAO;
	}
	
	public String limpar(){
		secao = new Secao();
		return INCLUIR_ALTERAR;
	}
	
	
	/*********************
	 * Getters e Setters *
	 * ********************/
	public List<Secao> getListaSecao() {
		return listaSecao;
	}

	public void setListaSecao(List<Secao> listaSecao) {
		this.listaSecao = listaSecao;
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

	public List<SelectItem> getListaSelectItemSecao() {
		return listaSelectItemSecao;
	}

	public void setListaSelectItemSecao(List<SelectItem> listaSelectItemSecao) {
		this.listaSelectItemSecao = listaSelectItemSecao;
	}

	public String getComboDepartamento() {
		return comboDepartamento;
	}

	public void setComboDepartamento(String comboDepartamento) {
		this.comboDepartamento = comboDepartamento;
	}

	public String getComboLocal() {
		return comboLocal;
	}

	public void setComboLocal(String comboLocal) {
		this.comboLocal = comboLocal;
	}

	public Integer getItemSelecionadoSecao() {
		return itemSelecionadoSecao;
	}

	public void setItemSelecionadoSecao(Integer itemSelecionadoSecao) {
		this.itemSelecionadoSecao = itemSelecionadoSecao;
	}
	
	public List<SelectItem> getListaSelectItemComboDepartamento(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i=0;i<=3;i++){
			lista.add(new SelectItem("departamento "+i,"departamento "+i));
		}
		return lista;
	}
	
	public List<SelectItem> getListaSelectItemComboLocal(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i=0;i<=3;i++){
			lista.add(new SelectItem("local "+i,"local "+i));
		}
		return lista;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}
