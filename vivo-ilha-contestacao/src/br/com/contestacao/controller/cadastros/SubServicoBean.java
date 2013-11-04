package br.com.contestacao.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.contestacao.model.Servico;
import br.com.contestacao.model.SimNaoEnum;
import br.com.contestacao.model.SubServico;
import br.com.contestacao.service.ServicoService;
import br.com.contestacao.service.SubServicoService;
import br.com.contestacao.utils.FacesMessages;

@ViewScoped
@Named
public class SubServicoBean implements Serializable {

	private static final long serialVersionUID = 7975470911964147541L;

	@Inject
	private ServicoService servicoService = null;

	@Inject
	private SubServicoService subServicoService = null;

	private List<Servico> listaServicosAtivos = null;

	private List<SubServico> listaPesquisa = null;

	private SubServico entidadeCadastro = null;

	private SubServico entidadePesquisa = null;

	private Boolean flagAtivo = null;

	public SubServicoBean() {
		super();

		resetCadastro();
		resetPesquisa();
	}

	private void resetCadastro() {
		this.entidadeCadastro = new SubServico();
		this.flagAtivo = Boolean.TRUE;
	}

	private void resetPesquisa() {
		this.entidadePesquisa = new SubServico();
		this.listaServicosAtivos = new ArrayList<Servico>();
	}

	@PostConstruct
	public void iniciar() {
		listaServicosAtivos = servicoService.listarAtivos();
		listaPesquisa = subServicoService.listar(entidadePesquisa);
	}

	public void confirmar() {
		entidadeCadastro.setAtivo(SimNaoEnum.valueOf(flagAtivo));
		subServicoService.salvar(entidadeCadastro);

		resetCadastro();

		listaPesquisa = subServicoService.listar(entidadePesquisa);

		FacesMessages.exibirMsgCadastroArmazenadoSucesso();
	}

	public void pesquisar() {
		listaPesquisa = subServicoService.listar(entidadePesquisa);

		if (listaPesquisa == null || listaPesquisa.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroEncontrado();
		}
	}

	public void editar(Integer indice) {
		if (indice == null) {
			FacesMessages.exibirMsgPesqNenhumRegistroSelecionado();
			return;
		}

		entidadeCadastro = new SubServico(listaPesquisa.get(indice));
		flagAtivo = entidadeCadastro.getAtivo().booleanValue();
	}

	public List<Servico> getListaServicosAtivos() {
		return listaServicosAtivos;
	}

	public void setListaServicosAtivos(List<Servico> listaServicosAtivos) {
		this.listaServicosAtivos = listaServicosAtivos;
	}

	public List<SubServico> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<SubServico> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public SubServico getEntidadeCadastro() {
		return entidadeCadastro;
	}

	public void setEntidadeCadastro(SubServico entidadeCadastro) {
		this.entidadeCadastro = entidadeCadastro;
	}

	public SubServico getEntidadePesquisa() {
		return entidadePesquisa;
	}

	public void setEntidadePesquisa(SubServico entidadePesquisa) {
		this.entidadePesquisa = entidadePesquisa;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
}
