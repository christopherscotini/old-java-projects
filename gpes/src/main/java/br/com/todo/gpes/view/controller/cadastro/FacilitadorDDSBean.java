package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.FacilitadorDDS;

@ManagedBean(name="facilitadorDDSBean")
@SessionScoped
public class FacilitadorDDSBean {
	
	//VARIAVEIS
	private FacilitadorDDS facilitador;
	private List<FacilitadorDDS> listaCadFacilitador = new ArrayList<FacilitadorDDS>();
	private List<SelectItem> comboNome;
	private List<SelectItem> comboGrupoDDS;
	
	//MÉTODOS DE CRUD
	public String incluir(){
		if(validarCampos()){
			FacilitadorDDS obj = new FacilitadorDDS(facilitador.getNome(),facilitador.getGrupoDDS());
			listaCadFacilitador.add(obj);
			limparCampos();
			return irConsultar();
		}
		return null;
	}
	
	//MÉTODOS DE CONTROLE
	public void limparCampos(){
		facilitador.setNome(null);
		facilitador.setGrupoDDS(null);
	}
	public boolean validarCampos(){
		if(facilitador.getNome().equals("")){ 
			FacesContext.getCurrentInstance().addMessage("consultarFacilitadorDDS", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione um valor no campo nome!", ""));
			return false;
		}else if(facilitador.getGrupoDDS().equals("")){
			FacesContext.getCurrentInstance().addMessage("consultarFacilitadorDDS", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione um valor no campo GrupoDDS!!", ""));
			return false;
		}
		return true;
	}
	public void carregaComboNome(){
		comboNome = new ArrayList<SelectItem>();
		comboNome.add(new SelectItem("","SELECIONE"));
		comboNome.add(new SelectItem("nome1","nome1"));
		comboNome.add(new SelectItem("nome2","nome2"));
		comboNome.add(new SelectItem("nome3","nome3"));
		comboNome.add(new SelectItem("nome4","nome4"));
		comboNome.add(new SelectItem("nome5","nome5"));
	}
	public void carregaComboGrupoDDS(){
		comboGrupoDDS = new ArrayList<SelectItem>();
		comboGrupoDDS.add(new SelectItem("","SELECIONE"));
		comboGrupoDDS.add(new SelectItem("grupo1","grupo1"));
		comboGrupoDDS.add(new SelectItem("grupo2","grupo2"));
		comboGrupoDDS.add(new SelectItem("grupo3","grupo3"));
		comboGrupoDDS.add(new SelectItem("grupo4","grupo4"));
		comboGrupoDDS.add(new SelectItem("grupo5","grupo5"));
	}
	
	
	//MÉTODOS DE NAEGAÇÃO
	public String irCadastrar(){
		facilitador = new FacilitadorDDS();
		carregaComboNome();
		carregaComboGrupoDDS();
		return "/content/cadastros/facilitadorDDS/cadFacilitadorDDS";
	}
	public String irConsultar(){
		return "/content/cadastros/facilitadorDDS/conFacilitadorDDS";
	}
	
	//GETTERS E SETTERS
	public FacilitadorDDS getFacilitador() {
		return facilitador;
	}
	public void setFacilitador(FacilitadorDDS facilitador) {
		this.facilitador = facilitador;
	}
	public List<FacilitadorDDS> getListaCadFacilitador() {
		return listaCadFacilitador;
	}
	public void setListaCadFacilitador(List<FacilitadorDDS> listaCadFacilitador) {
		this.listaCadFacilitador = listaCadFacilitador;
	}
	public List<SelectItem> getComboNome() {
		return comboNome;
	}
	public void setComboNome(List<SelectItem> comboNome) {
		this.comboNome = comboNome;
	}
	public List<SelectItem> getComboGrupoDDS() {
		return comboGrupoDDS;
	}
	public void setComboGrupoDDS(List<SelectItem> comboGrupoDDS) {
		this.comboGrupoDDS = comboGrupoDDS;
	}

	
}
