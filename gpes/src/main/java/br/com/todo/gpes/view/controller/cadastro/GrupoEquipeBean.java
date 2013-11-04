package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.GrupoEquipe;

@ManagedBean(name="grupoEquipeBean")
@SessionScoped
public class GrupoEquipeBean {
	
	private Integer itemSelecionadoGrupoEquipe;
	private List<GrupoEquipe>listaGrupoEquipes;
	private List<SelectItem>listaSelectItemGrupoEquipe;
	
	private boolean cadastrar; // SE TRUE vai para tela de CADASTRO
	private final String TELA_CONSULTAR_GRUPOEQUIPE = "/content/cadastros/grupoEquipe/conGrupoEquipe";
	private final String TELA_INCLUIR_ALTERAR = "/content/cadastros/grupoEquipe/cadGrupoEquipe";
	private String tituloTelaIncluirAlterar;
	
	
	public String consultarGrupoEquipe(){
		carregarGrupoEquipe();
		return TELA_CONSULTAR_GRUPOEQUIPE;
	}
	
	public void carregarGrupoEquipe(){
		setListaGrupoEquipes(new ArrayList<GrupoEquipe>());
		GrupoEquipe obj = new GrupoEquipe();
		obj.setCodGrupoEquipe(1457800);
		obj.setDescGrupoEquipe("PGIT");
		obj.setDescSecao("Seção Teste");
		obj.setStatus("ativo");
		getListaGrupoEquipes().add(obj);
		
		obj = new GrupoEquipe();
		obj.setCodGrupoEquipe(4784254);
		obj.setDescGrupoEquipe("LEAS");
		obj.setDescSecao("Seção Teste");
		obj.setStatus("inativo");
		getListaGrupoEquipes().add(obj);
		
		setListaSelectItemGrupoEquipe(new ArrayList<SelectItem>());
		for(int i=0;i<getListaGrupoEquipes().size();i++){
			getListaSelectItemGrupoEquipe().add(new SelectItem(i,""));
		}
	}

	public String cadastrarGrupoEquipe(){
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inclusão de Grupo/Equipe");
		return TELA_INCLUIR_ALTERAR;
	}

	public String alterarGrupoEquipe(){
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alteração de Grupo/Equipe");
		return TELA_INCLUIR_ALTERAR;
	}
	
	public String salvarGrupoEquipe(){
		return TELA_CONSULTAR_GRUPOEQUIPE;
	}

	public String limparCadastro(){
		return TELA_INCLUIR_ALTERAR;
	}
	
	public String voltar() {
		return TELA_CONSULTAR_GRUPOEQUIPE;
	}
	

/************************
 * GETTERS AND SETTERS
 ************************/
	public Integer getItemSelecionadoGrupoEquipe() {
		return itemSelecionadoGrupoEquipe;
	}
	public void setItemSelecionadoGrupoEquipe(Integer itemSelecionadoGrupoEquipe) {
		this.itemSelecionadoGrupoEquipe = itemSelecionadoGrupoEquipe;
	}

	public List<GrupoEquipe> getListaGrupoEquipes() {
		return listaGrupoEquipes;
	}

	public void setListaGrupoEquipes(List<GrupoEquipe> listaGrupoEquipes) {
		this.listaGrupoEquipes = listaGrupoEquipes;
	}

	public List<SelectItem> getListaSelectItemGrupoEquipe() {
		return listaSelectItemGrupoEquipe;
	}

	public void setListaSelectItemGrupoEquipe(List<SelectItem> listaSelectItemGrupoEquipe) {
		this.listaSelectItemGrupoEquipe = listaSelectItemGrupoEquipe;
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
	
	
	
	
}
