package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.exception.BusinessException;
import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.TipoContato;
import br.com.todo.gpes.service.cadastro.TipoContatoService;
import br.com.todo.gpes.view.constants.MessagesConstants;
import br.com.todo.gpes.view.utils.FacesUtils;

@ManagedBean(name="tipoContatoBean")
@SessionScoped
public class TipoContatoBean {
	
	private boolean cadastrar;
	
	private String tituloTelaIncluirAlterar;
	
	private final String CONSULTAR_TIPO_CONTATO = "/content/cadastros/tipoContato/conTipoContato";
	
	private final String INCLUIR_ALTERAR = "/content/cadastros/tipoContato/incAltTipoContato";
	
	private TipoContato tipoContato;
	
	private Integer posicaoLista;
	
	private List<SelectItem> listaRadios;
	
	private List<TipoContato> listaTipoContato = new ArrayList<TipoContato>();
	
	private String filtroSituacao;
	
	private String filtroDescTipoContato;
	
	@ManagedProperty(value = "#{tipoContatoServiceImpl}")
	private TipoContatoService tipoContatoService = null;

	public String consultarTipoContato() {
		return CONSULTAR_TIPO_CONTATO;
	}
	
	public String cadastrarTipoContato() {
		setCadastrar(true);
		tipoContato = new TipoContato();
		setTituloTelaIncluirAlterar("Inclusão Tipo Contato");
		
		return INCLUIR_ALTERAR;
	}
	
	public String alterarTipoContato() {
		if (posicaoLista == null) {
			FacesUtils.addInfoMessage(MessagesConstants.REGISTRO_NAO_SELECIONADO);
			return null;
		}

		tipoContato = new TipoContato(listaTipoContato.get(posicaoLista));

		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alteração Tipo Contato");
		
		return INCLUIR_ALTERAR;
	}
	
	public String pesquisar() {
		listaTipoContato = tipoContatoService.obterTipoContato(filtroDescTipoContato, filtroSituacao);
		carregaRadios();
		setPosicaoLista(null);
		
		return CONSULTAR_TIPO_CONTATO;
	}
	
	private void carregaRadios(){
		listaRadios = new ArrayList<SelectItem>();
		for(int i=0;i<listaTipoContato.size();i++){
			listaRadios.add(new SelectItem(i,""));
		}
	}
	
	public String limpar(){
		if(cadastrar){
			tipoContato = new TipoContato();
		}else{
			tipoContato.setDescTipoContato(null);
			tipoContato.setSituacao(null);
		}
		
		return INCLUIR_ALTERAR;
	}
	
	public String salvar() {
		try {
			if (!cadastrar) {
				
				if(tipoContato.getSituacao().equals("A")){
					tipoContato.setDtAtivo(new Date());
					tipoContato.setDtInativo(null);
				}else{
					tipoContato.setDtInativo(new Date());
				}
				tipoContatoService.alterarTipoContato(tipoContato);
				FacesUtils.addMessageAlteracaoSucesso();
			} else {
				tipoContato.setDtAtivo(new Date());
				tipoContatoService.incluirTipoContato(tipoContato);
				FacesUtils.addMessageInclusaoSucesso();
			}	
		} catch (BusinessException e) {
			FacesUtils.addErrorMessage(e.getMessage());
			return null;
		}

		return pesquisar();
	}
	
	public String voltarConsultaTipoContato() {
		return CONSULTAR_TIPO_CONTATO;
	}

	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}

	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}

	public boolean isCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}
	
	public List<AtivoInativoEnum> getSituacoes() {
		return Arrays.asList(AtivoInativoEnum.values());
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public TipoContatoService getTipoContatoService() {
		return tipoContatoService;
	}

	public void setTipoContatoService(TipoContatoService tipoContatoService) {
		this.tipoContatoService = tipoContatoService;
	}

	public String getFiltroSituacao() {
		return filtroSituacao;
	}

	public void setFiltroSituacao(String filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

	public String getFiltroDescTipoContato() {
		return filtroDescTipoContato;
	}

	public void setFiltroDescTipoContato(String filtroDescTipoContato) {
		this.filtroDescTipoContato = filtroDescTipoContato;
	}

	public List<TipoContato> getListaTipoContato() {
		return listaTipoContato;
	}

	public void setListaTipoContato(List<TipoContato> listaTipoContato) {
		this.listaTipoContato = listaTipoContato;
	}

	public Integer getPosicaoLista() {
		return posicaoLista;
	}

	public void setPosicaoLista(Integer posicaoLista) {
		this.posicaoLista = posicaoLista;
	}

	public List<SelectItem> getListaRadios() {
		return listaRadios;
	}

	public void setListaRadios(List<SelectItem> listaRadios) {
		this.listaRadios = listaRadios;
	}
	
}
