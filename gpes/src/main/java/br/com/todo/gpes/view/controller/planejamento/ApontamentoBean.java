package br.com.todo.gpes.view.controller.planejamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.todo.gpes.model.planejamento.Apontamento;

@ManagedBean(name="apontamentoBean")
@SessionScoped
public class ApontamentoBean {
	
	// ********** ATRIBUTOS PRIVADOS ********** //
	
	private Apontamento apontamento = new Apontamento();
	private Apontamento obj = new Apontamento();
	private List<Apontamento> apontamentos = new ArrayList<Apontamento>();
	private List<Apontamento> apontamentosAdm = new ArrayList<Apontamento>();
	private Date dataInicial;
	private Date dataFinal;
	private Date data;
	private Date horarioInicial;
	private Date horarioFinal;

	// ********** MÉTODOS DE INTERAÇÃO COM AS PÁGINAS ********** //
	
	public ApontamentoBean(){
		super();
	}
	
	public String carregarIncApontamento(){
		
		this.apontamento = new Apontamento();

		return ("/content/planejamento/apontamentos/incApontamento");
	}
	
	public String carregarConApontamento(){

		limparCampos();
		
		return ("/content/planejamento/apontamentos/conApontamento");
	}
	
	public String voltarIndex(){
		
		return ("/faces/index");
	}
	
	public void limparCampos(){
		this.apontamento.setElemento("SELECIONE");
		this.apontamento.setData(null);
		this.apontamento.setHorarioInicial(null);
		this.apontamento.setHorarioFinal(null);
		this.apontamento.setAtividade("");
		this.setHorarioFinal(null);
		this.setHorarioInicial(null);
		this.setData(null);
	}

	// ********** MÉTODOS DE CRUD ********** //
	
	public void incluirApontamento() {
		
		if (validarCampos()) {
			if (validarHorario(this.horarioInicial, this.horarioFinal)) {
				
				String dataF = formataData(data);
				String[] horarios = formataHorarios(this.horarioInicial, this.horarioFinal);
				
				this.obj = new Apontamento(this.apontamento.getNome(), 
						this.apontamento.getElemento(), 
						dataF, horarios[0], horarios[1], 
						this.apontamento.getAtividade());
				
				this.apontamentos.add(this.obj);
				this.limparCampos();
			}
		}
	}
	
	public void excluirApontamento(){
		this.apontamentos.remove(this.obj);
		this.limparCampos();
	}
	
	public void buscarApontamento(){}
	
	// ********** MÉTODOS DE FORMATAÇÃO ********** //
	
	public String formataData(Date arg1){
		
		SimpleDateFormat dataFormt = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
		
		if (arg1 == null) {
			return null;
		}
		
		return dataFormt.format(arg1);
	}
	
	public String[] formataHorarios(Date arg1, Date arg2)  {
		
		String[] horarios = new String[2]; 
		SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm", new Locale("pt","BR"));
		
		if(arg1 == null || arg2 == null){
			return null;
		}
		
		horarios[0] = formatHora.format(arg1);
		horarios[1] = formatHora.format(arg2);
		
		return horarios;
	}
	
	// ********** MÉTODOS DE VALIDAÇÃO ********** //
	
	public boolean validarCampos(){
		FacesContext contexto = FacesContext.getCurrentInstance(); 	
		
		if (this.apontamento.getElemento().equals("SELECIONE") || this.apontamento.getElemento() == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Selecione um elemento!"));
			return false;
		}else if(this.data == null){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Selecione uma data!"));
			return false;
		}else if(this.horarioInicial == null){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Selecione um horario inicial!"));
			return false;
		}else if(this.horarioFinal == null){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Selecione um horario final!"));
			return false;
		}else if(this.apontamento.getAtividade() == null || this.apontamento.getAtividade().equals("")){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Descreva uma atividade!"));
			return false;
		}else{
			return true;
		}
	}
	
	public boolean validarHorario(Date hr1, Date hr2){
		FacesContext contexto = FacesContext.getCurrentInstance(); 	
		String[] horarios = formataHorarios(hr1, hr2);
		
		int horaInicial = Integer.parseInt(horarios[0].split(":")[0]);
		int horaFinal = Integer.parseInt(horarios[1].split(":")[0]);
		
		if (horaInicial >= horaFinal) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O horario inicial deve ser menor que o final!"));
			return false;
		}else {
			return true;
		}
	}
	
	// ********** MÉTODOS GETTERS E SETTERS ********** //

	public Apontamento getApontamento() {
		return apontamento;
	}
	
	public void setApontamento(Apontamento apontamento) {
		this.apontamento = apontamento;
	}

	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}

	public List<Apontamento> getApontamentosAdm() {
		return apontamentosAdm;
	}

	public void setApontamentosAdm(List<Apontamento> apontamentosAdm) {
		this.apontamentosAdm = apontamentosAdm;
	}

	public Apontamento getObj() {
		return obj;
	}

	public void setObj(Apontamento obj) {
		this.obj = obj;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public Date getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(Date horarioInicial) {
		this.horarioInicial = horarioInicial;
	}
	
}
