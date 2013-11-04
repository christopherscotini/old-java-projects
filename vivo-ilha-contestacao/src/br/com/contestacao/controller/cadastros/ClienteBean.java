package br.com.contestacao.controller.cadastros;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.omnifaces.util.Messages;

import br.com.contestacao.controller.cadastros.model.CadastroCliente;
import br.com.contestacao.controller.cadastros.model.ColumnModel;
import br.com.contestacao.model.Servico;
import br.com.contestacao.model.SubServico;
import br.com.contestacao.model.Uf;
import br.com.contestacao.service.ClienteService;
import br.com.contestacao.service.ServicoService;
import br.com.contestacao.service.SubServicoService;
import br.com.contestacao.service.UfService;
import br.com.contestacao.utils.FacesMessages;
import br.com.contestacao.utils.MessagesConstants;

@SessionScoped
@ManagedBean
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 8652231572902223027L;

	@Inject
	private ClienteService clienteService = null;

	@Inject
	private ServicoService servicoService = null;

	@Inject
	private SubServicoService subServicoService = null;

	@Inject
	private UfService ufService = null;

	private CadastroCliente clienteCadastro = null;

	private CadastroCliente clientePesquisa = null;

	private List<Servico> listaServicosAtivos = null;

	private List<SubServico> listaSubServicosAtivos = null;

	private List<SubServico> listaSubServicosAtivosPesquisa = null;

	private List<Uf> listaUf = null;

	private List<CadastroCliente> listaPesquisa = null;

	private List<ColumnModel> colunasDinamicas = null;

	public String iniciar() {
		resetCadastro();

		return "/content/cadastros/clientes/cadastroCliente";
	}

	private void resetCadastro() {
		clienteCadastro = new CadastroCliente();
	}

	private void resetPesquisa() {
		clientePesquisa = new CadastroCliente();
		colunasDinamicas = new ArrayList<ColumnModel>();
	}

	private void carregarCombos() {
		listaServicosAtivos = servicoService.listarAtivos();
		listaUf = ufService.listar();
	}

	public void carregarComboSubServico(Long idSubServico) {
		listaSubServicosAtivos = subServicoService.listarAtivos(idSubServico);
	}

	public void carregarComboSubServicoPesquisa(Long idServico) {
		listaSubServicosAtivosPesquisa = subServicoService.listarAtivos(idServico);
	}

	public String salvar() {
		carregarCombos();
		resetPesquisa();
		listaPesquisa = new ArrayList<CadastroCliente>();
		listaSubServicosAtivos = new ArrayList<SubServico>();

		return "consultaListagemCliente";
	}

	public void confirmar() {
		if(verificarTarifasNaoPreenchidas(clienteCadastro)) {
			Messages.addError(null, MessagesConstants.PREENCHA_AO_MENOS_UM_CAMPO);
			return;
		}

		clienteService.salvar(clienteCadastro);

		resetCadastro();

		FacesMessages.exibirMsgCadastroArmazenadoSucesso();
	}

	private boolean verificarTarifasNaoPreenchidas(CadastroCliente cliente) {
		if (cliente.isServicoTelefonia()) {
			return isValorNullOrZero(cliente.getVc1()) && isValorNullOrZero(cliente.getVc2()) && isValorNullOrZero(cliente.getVc3());
		} else if (cliente.isServicoSms()) {
			return isValorNullOrZero(cliente.getNacional()) && isValorNullOrZero(cliente.getInternacional());
		}

		return false;
	}

	private boolean isValorNullOrZero(BigDecimal valor) {
		return valor == null || BigDecimal.ZERO.compareTo(valor) == 0;
	}

	public String pesquisar() {
		listaPesquisa = clienteService.listar(clientePesquisa);

		if (listaPesquisa == null || listaPesquisa.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroEncontrado();
		} else {
			montarColunasDinamicas();
		}

		return "consultaListagemCliente";
	}

	private void montarColunasDinamicas() {
		colunasDinamicas = new ArrayList<ColumnModel>();
		
		if (clientePesquisa.isServicoTelefonia()) {
			colunasDinamicas.add(new ColumnModel("VC1", "vc1", "10%"));
			colunasDinamicas.add(new ColumnModel("VC2", "vc2", "10%"));
			colunasDinamicas.add(new ColumnModel("VC3", "vc3", "10%"));
		} else if (clientePesquisa.isServicoSms()) {
			colunasDinamicas.add(new ColumnModel("Nacional", "nacional", "14%"));
			colunasDinamicas.add(new ColumnModel("Internacional", "internacional", "18%"));
		} else {
			colunasDinamicas.add(new ColumnModel("Valor", "valor", "14%"));
		}
	}

	public void editar(Integer indice) {
		if (indice == null) {
			FacesMessages.exibirMsgPesqNenhumRegistroSelecionado();
			return;
		}

		clienteCadastro = new CadastroCliente(listaPesquisa.get(indice));
		carregarComboSubServico(clienteCadastro.getServico());
	}

	public CadastroCliente getClienteCadastro() {
		return clienteCadastro;
	}

	public void setClienteCadastro(CadastroCliente clienteCadastro) {
		this.clienteCadastro = clienteCadastro;
	}

	public CadastroCliente getClientePesquisa() {
		return clientePesquisa;
	}

	public void setClientePesquisa(CadastroCliente clientePesquisa) {
		this.clientePesquisa = clientePesquisa;
	}

	public List<Servico> getListaServicosAtivos() {
		return listaServicosAtivos;
	}

	public void setListaServicosAtivos(List<Servico> listaServicosAtivos) {
		this.listaServicosAtivos = listaServicosAtivos;
	}

	public List<SubServico> getListaSubServicosAtivos() {
		return listaSubServicosAtivos;
	}

	public void setListaSubServicosAtivos(List<SubServico> listaSubServicosAtivos) {
		this.listaSubServicosAtivos = listaSubServicosAtivos;
	}

	public List<SubServico> getListaSubServicosAtivosPesquisa() {
		return listaSubServicosAtivosPesquisa;
	}

	public void setListaSubServicosAtivosPesquisa(List<SubServico> listaSubServicosAtivosPesquisa) {
		this.listaSubServicosAtivosPesquisa = listaSubServicosAtivosPesquisa;
	}

	public List<Uf> getListaUf() {
		return listaUf;
	}

	public void setListaUf(List<Uf> listaUf) {
		this.listaUf = listaUf;
	}

	public List<CadastroCliente> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<CadastroCliente> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public List<ColumnModel> getColunasDinamicas() {
		return colunasDinamicas;
	}

	public void setColunasDinamicas(List<ColumnModel> colunasDinamicas) {
		this.colunasDinamicas = colunasDinamicas;
	}
}
