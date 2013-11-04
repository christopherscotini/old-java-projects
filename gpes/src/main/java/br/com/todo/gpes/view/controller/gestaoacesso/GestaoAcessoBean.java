package br.com.todo.gpes.view.controller.gestaoacesso;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

@ManagedBean(name="gestaoAcessoBean")
@SessionScoped
public class GestaoAcessoBean {
	
	private DualListModel<String> listaDePerfis;
	
	public GestaoAcessoBean(){
		
		//Perfis  
        List<String> listaEsquerdaPerfis = new ArrayList<String>();  
        List<String> listaDireitaPerfis = new ArrayList<String>(); 
        listaEsquerdaPerfis.add("Analista");  
        listaEsquerdaPerfis.add("Especialista");  
        listaEsquerdaPerfis.add("Estagiário");  
        listaEsquerdaPerfis.add("Gerente");  
        listaEsquerdaPerfis.add("Presidente");  
        listaEsquerdaPerfis.add("Programador");  
        listaEsquerdaPerfis.add("Trainee");
        listaDePerfis = new DualListModel<String>(listaEsquerdaPerfis, listaDireitaPerfis);
	}
	
	
	//Getter e Setters
	public DualListModel<String> getListaDePerfis() {
		return listaDePerfis;
	}
	public void setListaDePerfis(DualListModel<String> listaDePerfis) {
		this.listaDePerfis = listaDePerfis;
	}
	
}
