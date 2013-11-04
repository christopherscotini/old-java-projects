package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import br.com.todo.gpes.model.cadastro.Programa;

@ManagedBean(name="programaBean")
@SessionScoped
public class ProgramaBean {
	
	//Variaveis
	private DualListModel<String> listaDeProjetos;	
	private Programa programa;
	private List<Programa> listaCadPrograma;
	
	
	//Contrutor Vazio
	public ProgramaBean(){
		
        //Projetos
        List<String> listaEsquerdaProjetos = new ArrayList<String>();  
        List<String> listaDireitaProjetos = new ArrayList<String>();
        listaEsquerdaProjetos.add("LEAS");
        listaEsquerdaProjetos.add("CBPC");
        listaEsquerdaProjetos.add("PGIT");
        listaEsquerdaProjetos.add("GPES");
        listaEsquerdaProjetos.add("BDCO");
        listaEsquerdaProjetos.add("FIRP");
        listaEsquerdaProjetos.add("INTERNO");
        listaDeProjetos = new DualListModel<String>(listaEsquerdaProjetos, listaDireitaProjetos); 
        
        listaCadPrograma = new ArrayList<Programa>();
        programa = new Programa();
	}
	
	
	//Métodos de CRUD
	public String incluir(){
		if(validarCampos()){
			Programa obj = new Programa(programa.getPrograma(),programa.getDescricao());
			listaCadPrograma.add(obj);
			limparCampos();
			return "/content/cadastros/programas/conProgramas";
		}
		return null;
	}
	public void excluir(){
        listaCadPrograma.remove(this.programa);
        limparCampos();
	}
	
	
	//Métodos de Controle
	public void limparCampos(){
		programa.setPrograma(null);
		programa.setDescricao(null);
	}
	public boolean validarCampos(){
		if(programa.getPrograma().equals("")){ 
			FacesContext.getCurrentInstance().addMessage("consultarPrograma", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Programa Vazio!", ""));
			return false;
		}else if(programa.getDescricao().equals("")){
			FacesContext.getCurrentInstance().addMessage("consultarPrograma", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Descricao Vazio!", ""));
			return false;
		}
		return true;
	}
	
	
	//Getter e Setters
	public DualListModel<String> getListaDeProjetos() {
		return listaDeProjetos;
	}
	public void setListaDeProjetos(DualListModel<String> listaDeProjetos) {
		this.listaDeProjetos = listaDeProjetos;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public List<Programa> getListaCadPrograma() {
		return listaCadPrograma;
	}
	public void setListaCadPrograma(List<Programa> listaCadPrograma) {
		this.listaCadPrograma = listaCadPrograma;
	}
	
}
