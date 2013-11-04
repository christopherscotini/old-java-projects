package br.com.contestacao.controller.exportacao;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import br.com.contestacao.controller.exportacao.model.PesquisaExportacao;
import br.com.contestacao.model.Cliente;
import br.com.contestacao.model.Contrato;
import br.com.contestacao.model.Tarifa;
import br.com.contestacao.model.Uf;
import br.com.contestacao.service.ClienteService;
import br.com.contestacao.service.ContratoService;
import br.com.contestacao.service.TarifaService;
import br.com.contestacao.service.UfService;
import br.com.contestacao.service.impl.ExportacaoService;
import br.com.contestacao.utils.FacesMessages;
import br.com.contestacao.utils.MessagesConstants;

import com.google.common.base.Throwables;

@SessionScoped
@Named
public class ExportacaoBean implements Serializable {

	private static final long serialVersionUID = -6198542998636528885L;

	private final String EXTENSAO_MDB = ".mdb";
	
	@Inject
	private UfService ufService = null;

	@Inject
	private ContratoService contratoService = null;

	@Inject
	private ClienteService clienteService = null;

	@Inject
	private ExportacaoService exportacaoService = null;

	@Inject
	private TarifaService tarifaService = null;

	private UploadedFile arquivo = null;

	private List<Uf> listaUfs = null;

	private List<Contrato> listaContratos = null;

	private List<Cliente> listaClientes = null;

	private List<Tarifa> listaTarifas = null;

	private Map<Long, Boolean> tarifasSelecionadas = null;

	private PesquisaExportacao pesquisaExportacao = null;

	private boolean exibeListaTarifa;

	public ExportacaoBean() {
		super();

		this.listaUfs = new ArrayList<Uf>();
		this.listaContratos = new ArrayList<Contrato>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaTarifas = new ArrayList<Tarifa>();
		this.pesquisaExportacao = new PesquisaExportacao();
		this.exibeListaTarifa = false;
	}

	public String iniciar() {
		listaUfs = ufService.listar();
		listaContratos = contratoService.listar();
		listaClientes = clienteService.listar();
		tarifasSelecionadas = new HashMap<Long, Boolean>();
		pesquisaExportacao = new PesquisaExportacao();
		exibeListaTarifa = false;

		return "/content/exportar/exportarArquivos";
	}

	public String consultarTarifa() {
		listaTarifas = tarifaService.listarPorClienteUfContrato(pesquisaExportacao.getIdCliente(),
				pesquisaExportacao.getIdUf(), pesquisaExportacao.getIdContrato());

		if (listaTarifas == null || listaTarifas.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroEncontrado();
			return "exportarArquivos";
		}

		return "consultaTarifas";
	}

	public String confirmar() {
		tarifasSelecionadas = new HashMap<Long, Boolean>();
		exibeListaTarifa = true;

		return "exportarArquivos";
	}

	public void exportarPlanilha() {
		if (arquivo == null) {
			Messages.addError(null, MessagesConstants.ARQUIVO_NAO_SELECIONADO);
			return;
		}
		
		if (arquivo.getFileName().lastIndexOf(EXTENSAO_MDB) == -1) {
			Messages.addError(null, MessagesConstants.ARQUIVO_NAO_SUPORTADO);
			return;
		}

		List<Tarifa> tarifasParaCalculo = new ArrayList<Tarifa>();
		
		for (Tarifa t : listaTarifas) {
			Boolean flagSelecao = tarifasSelecionadas.get(t.getId());
			if (flagSelecao != null && flagSelecao) {
				tarifasParaCalculo.add(t);
			}
		}

		if (tarifasParaCalculo.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroSelecionado();
			return;
		}

		byte[] bytesPlanilha = exportacaoService.exportar(arquivo.getContents(), tarifasParaCalculo);

		try {
			Faces.sendFile(bytesPlanilha, "Planilha_Vivo.xls", true);
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

	public List<Uf> getListaUfs() {
		return listaUfs;
	}

	public void setListaUfs(List<Uf> listaUfs) {
		this.listaUfs = listaUfs;
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public boolean isExibeListaTarifa() {
		return exibeListaTarifa;
	}

	public void setExibeListaTarifa(boolean exibeListaTarifa) {
		this.exibeListaTarifa = exibeListaTarifa;
	}

	public List<Tarifa> getListaTarifas() {
		return listaTarifas;
	}

	public void setListaTarifas(List<Tarifa> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}

	public Map<Long, Boolean> getTarifasSelecionadas() {
		return tarifasSelecionadas;
	}

	public void setTarifasSelecionadas(Map<Long, Boolean> tarifasSelecionadas) {
		this.tarifasSelecionadas = tarifasSelecionadas;
	}

	public PesquisaExportacao getPesquisaExportacao() {
		return pesquisaExportacao;
	}

	public void setPesquisaExportacao(PesquisaExportacao pesquisaExportacao) {
		this.pesquisaExportacao = pesquisaExportacao;
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

}
