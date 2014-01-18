package br.com.utmanager.view.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.utmanager.model.CategoriaJogador;
import br.com.utmanager.model.ClubeJogador;
import br.com.utmanager.model.Jogador;
import br.com.utmanager.model.LigaJogador;
import br.com.utmanager.model.NacionalidadeJogador;
import br.com.utmanager.model.PosicaoJogador;
import br.com.utmanager.model.StatusJogador;


@ManagedBean
@SessionScoped
public class HistoricoPlatelBean extends AbstractGenericBean{
	
	private final String INCLUIR_JOGADOR = "/content/formularioJogador.xhtml";
	
	private List<Jogador> filteredPlayers = null;
	private List<Jogador> jogadores = null;
	private Jogador jogadorCadastro = null;
	private boolean cadastrar;
	
	private Long categoriaSelecionada;
	private Long clubeSelecionada;
	private Long ligaSelecionada;
	private Long nacionalidadeSelecionada;
	private Long posicaoSelecionada;
	private Long statusSelecionada;
	
	@PostConstruct
	public void init(){
		jogadores = getJogadorBO().listarTodos();
	}

	
	
	public String navegarIncluir(){
		jogadorCadastro = new Jogador();
		cadastrar = true;
		prepararCombosFormulario();
		
		return INCLUIR_JOGADOR;
	}

	public String executeSave(){
		if(cadastrar){
			jogadorCadastro.setCategoria(new CategoriaJogador(categoriaSelecionada));
			jogadorCadastro.setClube(new ClubeJogador(clubeSelecionada));
			jogadorCadastro.setLiga(new LigaJogador(ligaSelecionada));
			jogadorCadastro.setNacionalidade(new NacionalidadeJogador(nacionalidadeSelecionada));
			jogadorCadastro.setPosicao(new PosicaoJogador(posicaoSelecionada));
			jogadorCadastro.setStatus(new StatusJogador(statusSelecionada));
			getJogadorBO().inserir(jogadorCadastro);
		}
		
		return "/index";
	}
	
	private void prepararCombosFormulario(){
		if(cadastrar){
			categoriaSelecionada = null;
			ligaSelecionada = 1L;
			clubeSelecionada = null;
			nacionalidadeSelecionada = null;
			posicaoSelecionada = null;
			statusSelecionada = null;
		}
	}
	
	public List<ClubeJogador> getComboTime() {
		
		return getClubeJogadorBO().filtrarPorLiga(ligaSelecionada);
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}


	public Jogador getJogadorCadastro() {
		return jogadorCadastro;
	}


	public void setJogadorCadastro(Jogador jogadorCadastro) {
		this.jogadorCadastro = jogadorCadastro;
	}

	public Long getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Long categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public Long getClubeSelecionada() {
		return clubeSelecionada;
	}

	public void setClubeSelecionada(Long clubeSelecionada) {
		this.clubeSelecionada = clubeSelecionada;
	}

	public Long getLigaSelecionada() {
		return ligaSelecionada;
	}

	public void setLigaSelecionada(Long ligaSelecionada) {
		this.ligaSelecionada = ligaSelecionada;
	}

	public Long getNacionalidadeSelecionada() {
		return nacionalidadeSelecionada;
	}

	public void setNacionalidadeSelecionada(Long nacionalidadeSelecionada) {
		this.nacionalidadeSelecionada = nacionalidadeSelecionada;
	}

	public Long getPosicaoSelecionada() {
		return posicaoSelecionada;
	}

	public void setPosicaoSelecionada(Long posicaoSelecionada) {
		this.posicaoSelecionada = posicaoSelecionada;
	}

	public Long getStatusSelecionada() {
		return statusSelecionada;
	}

	public void setStatusSelecionada(Long statusSelecionada) {
		this.statusSelecionada = statusSelecionada;
	}



	public List<Jogador> getFilteredPlayers() {
		return filteredPlayers;
	}



	public void setFilteredPlayers(List<Jogador> filteredPlayers) {
		this.filteredPlayers = filteredPlayers;
	}
	
}
