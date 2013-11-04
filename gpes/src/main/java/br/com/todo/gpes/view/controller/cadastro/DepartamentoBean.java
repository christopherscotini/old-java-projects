package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.Departamento;

@ManagedBean(name="departamentoBean")
@SessionScoped
public class DepartamentoBean {
	
	
	//navegacao
	private static final String TELA_CONSULTA = "/content/cadastros/departamentos/conDepartamentos";
	private static final String TELA_CADASTRO = "/content/cadastros/departamentos/altCadDepartamentos";
	
	//variaveis inputs e combos
	private Departamento departamento = new Departamento();
	
	//variaveis tabela
	private List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	private Integer posicaoLista;
	
	//variaveis de controle
	String tituloDepartamento;
	boolean alteracao;
	
	
	/* ###  Bloco Pesquisar ### */
	public void pesquisar(){
		listaDepartamentos = new ArrayList<Departamento>();
		preencher();
		listaDepartamentos.add(departamento);
		listaDepartamentos.add(departamento);
		listaDepartamentos.add(departamento);
		listaDepartamentos.add(departamento);
		listaDepartamentos.add(departamento);
		departamento = new Departamento();
		getListaRadios();
		setPosicaoLista(null);
	}
	public void preencher(){
		departamento = new Departamento();
		departamento.setCodigoJuncao(1);
		departamento.setComplemento("complemento teste");
		departamento.setDepartamento("departamento teste");
		departamento.setLocal("Local 1");
		departamento.setNomeCliente("Cliente 1");
		departamento.setStatus(AtivoInativoEnum.ATIVO.getCodigo());
		listaDepartamentos.add(departamento);
	}
	/* ### Fim Bloco Pesquisar ### */
	
	/*Bloco salvar */
	public String salvar(){
		if (alteracao) {
			listaDepartamentos.set(posicaoLista, departamento);	
		} else {
			listaDepartamentos.add(departamento);
		}
		getListaRadios();
		setPosicaoLista(null);
		departamento = new Departamento();
		return TELA_CONSULTA;
		
	}
	/* Fim Bloco salvar */
	
	//metodos navegacao de paginas
	public String navegarNovo(){
		departamento = new Departamento();
		return navegarCadastro("Inclusão Departamento", false);
	}
	public String navegarAlteracao(){
		if (posicaoLista == null) {
			return null;
		}
		departamento = new Departamento(listaDepartamentos.get(posicaoLista));
		return navegarCadastro("Alterar Departamento", true);
	}
	private String navegarCadastro(String titulo, boolean flagAlteracao) {
		tituloDepartamento = titulo;
		alteracao = flagAlteracao;
		return TELA_CADASTRO;
	}
	public String voltar() {
		return TELA_CONSULTA;
	}
	
	
	
	/*
	 * preenchendo lista de radios com opcao ativo e inativo- tela alterar/incluir
	 * preenche lista do combo Cliente
	 * preenche lista do combo Local
	 * */
	public List<SelectItem> getSelectItemsStatus() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens .add(new SelectItem(AtivoInativoEnum.ATIVO.getCodigo(), AtivoInativoEnum.ATIVO.toString()));
		itens .add(new SelectItem(AtivoInativoEnum.INATIVO.getCodigo(), AtivoInativoEnum.INATIVO.toString()));
		return itens;
	}
	public List<SelectItem> getComboCliente() {
		List<SelectItem> itens  = new ArrayList<SelectItem>();
		for(int i=0;i<5;i++){
			itens.add(new SelectItem("Cliente "+i,"Cliente "+i));
		}
		return itens;
	}
	public List<SelectItem> getComboLocal(){
		List<SelectItem> comboLocal = new ArrayList<SelectItem>();
		for(int i=0;i<5;i++){
			comboLocal.add(new SelectItem("Local "+i,"Local "+i));
		}
		return comboLocal;
	}
	public List<SelectItem> getListaRadios() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for(int i=0;i<listaDepartamentos.size();i++){
			itens.add(new SelectItem(i,""));
		}
		return itens;
	}
	
	
	
	
	
	/*
	 * Getters e Setters
	 * */
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}
	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	public Integer getPosicaoLista() {
		return posicaoLista;
	}
	public String getTituloDepartamento() {
		return tituloDepartamento;
	}
	public void setTituloDepartamento(String tituloDepartamento) {
		this.tituloDepartamento = tituloDepartamento;
	}
	public boolean isAlteracao() {
		return alteracao;
	}
	public void setAlteracao(boolean alteracao) {
		this.alteracao = alteracao;
	}
	public void setPosicaoLista(Integer posicaoLista) {
		this.posicaoLista = posicaoLista;
	}
	
}
