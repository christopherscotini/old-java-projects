package br.com.contestacao.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.DualListModel;

import br.com.contestacao.controller.cadastros.model.ValueLabelListModel;
import br.com.contestacao.model.Perfil;
import br.com.contestacao.model.Tela;
import br.com.contestacao.service.PerfilService;
import br.com.contestacao.service.TelaService;
import br.com.contestacao.utils.FacesMessages;

@ViewScoped
@Named
public class PerfilBean implements Serializable {

	private static final long serialVersionUID = -4382358154542189015L;

	@Inject
	private TelaService telaService = null;

	@Inject
	private PerfilService perfilService = null;

	private DualListModel<ValueLabelListModel> perfis;

	private Perfil perfilCadastro = null;

	private List<Tela> telasAcoes = null; 

	public PerfilBean() {
		super();

		this.telasAcoes = new ArrayList<Tela>();
		resetCadastro();
	}

	private void resetCadastro() {
		this.perfilCadastro = new Perfil();

		this.perfis = criarDualListModelTelasAcoes();
	}

	@PostConstruct
	public void iniciar() {
		telasAcoes = telaService.listar();

		this.perfis = criarDualListModelTelasAcoes();
	}

	private DualListModel<ValueLabelListModel> criarDualListModelTelasAcoes() {
		List<ValueLabelListModel> listaTelasModel = new ArrayList<ValueLabelListModel>();
		for (Tela t : telasAcoes) {
			listaTelasModel.add(new ValueLabelListModel(t.getId(), t.getNome()));
		}
		return new DualListModel<ValueLabelListModel>(listaTelasModel, new ArrayList<ValueLabelListModel>());
	}

	public void confirmar() {
		List<Long> telasId = new ArrayList<Long>();

		for (ValueLabelListModel item : perfis.getTarget()) {
			telasId.add((Long) item.getValue());
		}

		perfilService.salvar(perfilCadastro, telasId);

		resetCadastro();

		FacesMessages.exibirMsgCadastroArmazenadoSucesso();
	}

	public DualListModel<ValueLabelListModel> getPerfis() {
		return perfis;
	}

	public void setPerfis(DualListModel<ValueLabelListModel> perfis) {
		this.perfis = perfis;
	}

	public Perfil getPerfilCadastro() {
		return perfilCadastro;
	}

	public void setPerfilCadastro(Perfil perfilCadastro) {
		this.perfilCadastro = perfilCadastro;
	}

}
