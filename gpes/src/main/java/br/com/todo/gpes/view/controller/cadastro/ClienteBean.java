package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.todo.gpes.model.basic.ChaveEstado;
import br.com.todo.gpes.model.basic.ChaveMunicipio;
import br.com.todo.gpes.model.basic.Estado;
import br.com.todo.gpes.model.basic.Municipio;
import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.ChaveEnderecoCliente;
import br.com.todo.gpes.model.cadastro.Cliente;
import br.com.todo.gpes.model.cadastro.EnderecoCliente;
import br.com.todo.gpes.service.basic.BasicService;
import br.com.todo.gpes.service.cadastro.ClienteService;

@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	private String filtroNomeCliente;
	private Long filtroNumeroCnpj;
	private Integer filtroFilialCnpj;
	private Integer filtroControleCnpj;
	private String filtroSituacao;
	private List<Cliente> listaClientes;
	private boolean cadastrar; // SE TRUE vai para tela de CADASTRO
	private Cliente cliente;
	private ChaveEstado estadoSelecionado;
	private ChaveMunicipio municipioSelecionado;
	private Municipio municipio;
	private String tituloTelaIncluirAlterar;
	private List<SelectItem>listaSelectItemCliente;
	private Integer itemSelecionadoCliente;
	private final String CONSULTAR_CLIENTE = "/content/cadastros/clientes/conClientes";
	private final String INCLUIR_ALTERAR = "/content/cadastros/clientes/incAltClientes";
	private List<Estado> listaEstados = new ArrayList<Estado>();
	private List<Municipio> listaMunicipio = new ArrayList<Municipio>();
	private EnderecoCliente endereco;
	
	@ManagedProperty(value = "#{basicServiceImpl}")
	private BasicService basicService = null;

	@ManagedProperty(value = "#{clienteServiceImpl}")
	private ClienteService clienteService = null;
	
	public String consultarCliente() {
		listaEstados = new ArrayList<Estado>();
		listaEstados = basicService.obterEstados();
		cliente = new Cliente();
		
		return CONSULTAR_CLIENTE;
	}
	
	public String voltar() {
		
		return CONSULTAR_CLIENTE;
	}
	
	public void carregarClientes(){
		setListaClientes(new ArrayList<Cliente>());
		Cliente obj = new Cliente();
		
		getListaClientes().add(obj);
		
		obj = new Cliente();
	
		getListaClientes().add(obj);
		
		setListaSelectItemCliente(new ArrayList<SelectItem>());
		for(int i=0;i<getListaClientes().size();i++){
			getListaSelectItemCliente().add(new SelectItem(i,""));
		}
	}
	
	public void carregaMunicipio(){
		listaMunicipio = new ArrayList<Municipio>();
		listaMunicipio = basicService.obterMunicipios(estadoSelecionado.getCodigoEstado(), estadoSelecionado.getCodigoPais());
	}

	public String cadastrarCliente(){
		cliente = new Cliente();
		endereco = new EnderecoCliente();
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inclusão de Clientes");
		
		return INCLUIR_ALTERAR;
	}
	
	public String limparCadastro(){
		cliente = new Cliente();
		endereco = new EnderecoCliente();
		setEstadoSelecionado(null);
		setMunicipioSelecionado(null);
		setCadastrar(true);
		setTituloTelaIncluirAlterar("Inclusão de Clientes");
		
		return INCLUIR_ALTERAR;
	}
	
	public String limparFiltro(){
		setFiltroNomeCliente(null);
		setFiltroNumeroCnpj(null);
		setFiltroFilialCnpj(null);
		setFiltroControleCnpj(null);
		setFiltroSituacao(null);
		
		return CONSULTAR_CLIENTE;
	}
	public String alterarCliente(){
		setCadastrar(false);
		setTituloTelaIncluirAlterar("Alteração de Clientes");
		return INCLUIR_ALTERAR;
	}
	
	public String salvarCliente() {
		endereco.setNumEndereco(1);
		cliente.setDtAtivacao(new Date());
		cliente.setSituacao(AtivoInativoEnum.ATIVO.getCodigo());
		ChaveEnderecoCliente chaveEnderecoCliente = new ChaveEnderecoCliente();
		chaveEnderecoCliente.setNumSequencial(1);
		endereco.setChaveEnderecoCliente(chaveEnderecoCliente);
		endereco.setCodigoPais(1);
		endereco.setCodigoEstado(1);
		endereco.setCodigoMunicipio(1);
		List<EnderecoCliente> listaEnderecos = new ArrayList<EnderecoCliente>();
		listaEnderecos.add(endereco);
		cliente.setEnderecos(listaEnderecos);
		clienteService.incluirCliente(cliente);
		return CONSULTAR_CLIENTE;
	}

	/************************
	 * GETTERS AND SETTERS
	 ************************/
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public boolean isCadastrar() {
		return cadastrar;
	}
	
	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}
	
	public String getTituloTelaIncluirAlterar() {
		return tituloTelaIncluirAlterar;
	}
	
	public void setTituloTelaIncluirAlterar(String tituloTelaIncluirAlterar) {
		this.tituloTelaIncluirAlterar = tituloTelaIncluirAlterar;
	}
	
	public List<SelectItem> getListaSelectItemCliente() {
		return listaSelectItemCliente;
	}
	
	public void setListaSelectItemCliente(List<SelectItem> listaSelectItemCliente) {
		this.listaSelectItemCliente = listaSelectItemCliente;
	}
	
	public Integer getItemSelecionadoCliente() {
		return itemSelecionadoCliente;
	}
	
	public void setItemSelecionadoCliente(Integer itemSelecionadoCliente) {
		this.itemSelecionadoCliente = itemSelecionadoCliente;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public BasicService getBasicService() {
		return basicService;
	}

	public void setBasicService(BasicService basicService) {
		this.basicService = basicService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getListaMunicipio() {
		return listaMunicipio;
	}

	public void setListaMunicipio(List<Municipio> listaMunicipio) {
		this.listaMunicipio = listaMunicipio;
	}
	
	public List<AtivoInativoEnum> getSituacoes() {
		return Arrays.asList(AtivoInativoEnum.values());
	}

	public String getFiltroNomeCliente() {
		return filtroNomeCliente;
	}

	public void setFiltroNomeCliente(String filtroNomeCliente) {
		this.filtroNomeCliente = filtroNomeCliente;
	}

	public Long getFiltroNumeroCnpj() {
		return filtroNumeroCnpj;
	}

	public void setFiltroNumeroCnpj(Long filtroNumeroCnpj) {
		this.filtroNumeroCnpj = filtroNumeroCnpj;
	}

	public Integer getFiltroFilialCnpj() {
		return filtroFilialCnpj;
	}

	public void setFiltroFilialCnpj(Integer filtroFilialCnpj) {
		this.filtroFilialCnpj = filtroFilialCnpj;
	}

	public Integer getFiltroControleCnpj() {
		return filtroControleCnpj;
	}

	public void setFiltroControleCnpj(Integer filtroControleCnpj) {
		this.filtroControleCnpj = filtroControleCnpj;
	}

	public String getFiltroSituacao() {
		return filtroSituacao;
	}

	public void setFiltroSituacao(String filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

	public ChaveEstado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(ChaveEstado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public ChaveMunicipio getMunicipioSelecionado() {
		return municipioSelecionado;
	}

	public void setMunicipioSelecionado(ChaveMunicipio municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public EnderecoCliente getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

}
