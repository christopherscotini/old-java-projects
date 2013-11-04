package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.cadastro.Contrato;

@ManagedBean(name="contratoBean")
@SessionScoped
public class ContratoBean {
	
	//CONSTANTES NAVEGACAO
	private final String CONSULTAR_CONTRATO = "/content/cadastros/contrato/conContrato";
	private final String INCLUIR_ALTERAR = "/content/cadastros/contrato/incAltContrato";
	
	//Variaveis de Controle
	private Contrato contrato = new Contrato();
	private boolean cadastrar;
	private List<Contrato> listaContrato;
	private List<SelectItem> listaSelectItemContrato;
	private Integer itemSelecionadoContrato;
	private String tituloTelaIncluirAlterar;
	
	//CRUD
	public String salvarContrato() {
		if(isCadastrar()){
			getListaContrato().add(getContrato());
		}else{
			getListaContrato().set(getItemSelecionadoContrato(), getContrato());
		}
		carregaListaRadios();
		setItemSelecionadoContrato(null);
		contrato = new Contrato();
		return CONSULTAR_CONTRATO;
	}
	
	//Controle
	public String consultarContrato() {
		carregarContratos();
		return CONSULTAR_CONTRATO;
	}
	public void carregarContratos() {
		setListaContrato(new ArrayList<Contrato>());
		Contrato obj = new Contrato();
//		obj.setNomeDpto("dpto 1");
//		obj.setCodigoContrato(1);
//		obj.setCliente("cliente 1");
//		obj.setStatus(true);
		getListaContrato().add(obj);
		
		obj = new Contrato();
//		obj.setNomeDpto("dpto 2");
//		obj.setCodigoContrato(2);
//		obj.setCliente("cliente 2");
//		obj.setStatus(false);
		getListaContrato().add(obj);
		carregaListaRadios();
	}
	public void carregaListaRadios(){
		setListaSelectItemContrato(new ArrayList<SelectItem>());
		for (int i = 0; i < getListaContrato().size(); i++) {
			getListaSelectItemContrato().add(new SelectItem(i,""));
		}
	}
	
	
	//Navegação
	public String voltar() {
		return CONSULTAR_CONTRATO;
	}
	public String limpar(){
		contrato = new Contrato();
		return INCLUIR_ALTERAR;
	}
	public String cadastrarContrato() {
		contrato = new Contrato();
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inclusão de Contratos");
		return INCLUIR_ALTERAR;
	}
	public String alterarContrato() {
		try{
			setCadastrar(false);
			setTituloTelaIncluirAlterar("Alteração de Contratos");
			//contrato = new Contrato(listaContrato.get(itemSelecionadoContrato));
			return INCLUIR_ALTERAR;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	
	//Getter e setetrs
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public boolean isCadastrar() {
		return cadastrar;
	}
	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}
	public List<Contrato> getListaContrato() {
		return listaContrato;
	}
	public void setListaContrato(List<Contrato> listaContrato) {
		this.listaContrato = listaContrato;
	}
	public Integer getItemSelecionadoContrato() {
		return itemSelecionadoContrato;
	}
	public void setItemSelecionadoContrato(Integer itemSelecionadoContrato) {
		this.itemSelecionadoContrato = itemSelecionadoContrato;
	}
	public List<SelectItem> getListaSelectItemContrato() {
		return listaSelectItemContrato;
	}
	public void setListaSelectItemContrato(List<SelectItem> listaSelectItemContrato) {
		this.listaSelectItemContrato = listaSelectItemContrato;
	}
	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}
	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}
	
	//Combos
	public List<SelectItem> getListaSelectItemComboDepartamento(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i=0;i<3;i++){
			lista.add(new SelectItem("dpto "+i, "dpto "+i));
		}
		return lista;
	}
	public List<SelectItem> getListaSelectItemComboCliente(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for(int i=0;i<3;i++){
			lista.add(new SelectItem("cliente "+i, "cliente "+i));
		}
		return lista;
	}
}
