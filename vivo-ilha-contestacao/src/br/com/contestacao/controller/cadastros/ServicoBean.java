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
import br.com.contestacao.service.ServicoService;
import br.com.contestacao.utils.FacesMessages;

@ViewScoped
@Named
public class ServicoBean implements Serializable {

	private static final long serialVersionUID = -3882476277241212375L;

	@Inject
	private ServicoService servicoService = null;

	private Servico entidadeCadastro = null;

	private Servico entidadePesquisa = null;

	private List<Servico> listaPesquisa = null;

	private Boolean flagAtivo = null;

	public ServicoBean() {
		super();

		resetCadastro();
		resetPesquisa();
	}

	private void resetCadastro() {
		this.entidadeCadastro = new Servico();
		this.flagAtivo = Boolean.TRUE;
	}

	private void resetPesquisa() {
		this.entidadePesquisa = new Servico();
		this.listaPesquisa = new ArrayList<Servico>();
	}
	
	@PostConstruct
	public void iniciar() {
		listaPesquisa = servicoService.listar(entidadePesquisa);
	}

	public void confirmar() {
		entidadeCadastro.setAtivo(SimNaoEnum.valueOf(flagAtivo));
		servicoService.salvar(entidadeCadastro);

		resetCadastro();

		listaPesquisa = servicoService.listar(entidadePesquisa);

		FacesMessages.exibirMsgCadastroArmazenadoSucesso();
	}

	public void pesquisar() {
		listaPesquisa = servicoService.listar(entidadePesquisa);

		if (listaPesquisa == null || listaPesquisa.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroEncontrado();
		}
	}

	public void editar(Integer indice) {
		if (indice == null) {
			FacesMessages.exibirMsgPesqNenhumRegistroSelecionado();
			return;
		}

		entidadeCadastro = new Servico(listaPesquisa.get(indice));
		flagAtivo = entidadeCadastro.getAtivo().booleanValue();
	}

	public Servico getEntidadeCadastro() {
		return entidadeCadastro;
	}

	public void setEntidadeCadastro(Servico entidadeCadastro) {
		this.entidadeCadastro = entidadeCadastro;
	}

	public Servico getEntidadePesquisa() {
		return entidadePesquisa;
	}

	public void setEntidadePesquisa(Servico entidadePesquisa) {
		this.entidadePesquisa = entidadePesquisa;
	}

	public List<Servico> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<Servico> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
}
