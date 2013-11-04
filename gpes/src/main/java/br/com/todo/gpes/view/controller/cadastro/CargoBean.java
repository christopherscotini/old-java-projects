package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.exception.BusinessException;
import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.Cargo;
import br.com.todo.gpes.service.cadastro.CargoService;
import br.com.todo.gpes.view.constants.MessagesConstants;
import br.com.todo.gpes.view.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class CargoBean {

	private String filtroDescricao;

	private Cargo cargo;

	private List<Cargo> listaCargos = new ArrayList<Cargo>();

	private List<SelectItem> listaRadiosCargos;

	private Integer posicaoLista;

	private boolean alteracao = false;

	private String tituloCadastro = null;

	@ManagedProperty(value = "#{cargoServiceImpl}")
	private CargoService cargoService = null;

	private static final String TELA_CONSULTA = "/content/cadastros/cargos/conCargos";

	private static final String TELA_CADASTRO = "/content/cadastros/cargos/cadCargos";

	public String inicial() {
		filtroDescricao = null;
		cargo = null;
		listaCargos = new ArrayList<Cargo>();
		listaRadiosCargos = new ArrayList<SelectItem>();
		posicaoLista = null;
		alteracao = false;
		tituloCadastro = null;

		return TELA_CONSULTA;
	}

	public String pesquisar() {
		listaCargos = cargoService.obterCargos(filtroDescricao);
		carregaRadiosCargo();
		setPosicaoLista(null);

		return TELA_CONSULTA;
	}

	public String navegarNovo() {
		cargo = new Cargo();
		return navegarCadastro("Inclusão de Cargos e Salários", false);
	}

	public String navegarAlteracao() {
		if (posicaoLista == null) {
			FacesUtils.addInfoMessage(MessagesConstants.REGISTRO_NAO_SELECIONADO);
			return null;
		}

		cargo = new Cargo(listaCargos.get(posicaoLista));

		return navegarCadastro("Alteração de Cargos e Salários", true);
	}

	private String navegarCadastro(String titulo, boolean flagAlteracao) {
		tituloCadastro = titulo;
		alteracao = flagAlteracao;

		return TELA_CADASTRO;
	}

	private void carregaRadiosCargo(){
		listaRadiosCargos = new ArrayList<SelectItem>();
		for(int i=0;i<listaCargos.size();i++){
			listaRadiosCargos.add(new SelectItem(i,""));
		}
	}

	public String salvar() {
		try {
			if (alteracao) {
				cargoService.alterarCargo(cargo);
				FacesUtils.addMessageAlteracaoSucesso();
			} else {
				cargoService.incluirCargo(cargo);
				FacesUtils.addMessageInclusaoSucesso();
			}	
		} catch (BusinessException e) {
			FacesUtils.addErrorMessage(e.getMessage());
			return null;
		}

		return pesquisar();
	}

	public String limparCadastro() {
		if (alteracao) {
			cargo.setDescCargo(null);
			cargo.setSalario(null);
			cargo.setSituacao(null);
		} else {
			cargo = new Cargo();
		}

		return TELA_CADASTRO;
	}

	public String voltar() {
		return TELA_CONSULTA;
	}

	public List<AtivoInativoEnum> getSituacoes() {
		return Arrays.asList(AtivoInativoEnum.values());
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public Integer getPosicaoLista() {
		return posicaoLista;
	}

	public void setPosicaoLista(Integer posicaoLista) {
		this.posicaoLista = posicaoLista;
	}

	public List<SelectItem> getListaRadiosCargos() {
		return listaRadiosCargos;
	}

	public void setListaRadiosCargos(List<SelectItem> listaRadiosCargos) {
		this.listaRadiosCargos = listaRadiosCargos;
	}

	public boolean isAlteracao() {
		return alteracao;
	}

	public void setAlteracao(boolean alteracao) {
		this.alteracao = alteracao;
	}

	public String getTituloCadastro() {
		return tituloCadastro;
	}

	public void setTituloCadastro(String tituloCadastro) {
		this.tituloCadastro = tituloCadastro;
	}

	public String getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(String filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
}
