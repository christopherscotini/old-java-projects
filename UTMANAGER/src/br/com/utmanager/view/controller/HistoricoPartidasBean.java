package br.com.utmanager.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.utmanager.model.Partida;


@ManagedBean
@SessionScoped
public class HistoricoPartidasBean extends AbstractGenericBean{

	private final String TELA_HISTORICO_JOGOS = "/content/historicoPartidas.xhtml";
	private final String TELA_INCLUIR_JOGOS = "/content/formularioPartidas.xhtml";

	private List<Partida> filteredPartidas;
	private List<Partida> partidas;
	private Partida partidaCadastro;
	
	
	@Override
	public String iniciarTela() {
		filteredPartidas = null;
		partidas = getPartidasBO().listarTodos();
		
		return TELA_HISTORICO_JOGOS;
	}
	
	public String navegarIncluir(){
		partidaCadastro = new Partida();
		
		return TELA_INCLUIR_JOGOS;
	}
	
	public String executeSave(){
		
		getPartidasBO().inserir(partidaCadastro);
		
		return iniciarTela();
	}
	
	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Partida getPartidaCadastro() {
		return partidaCadastro;
	}

	public void setPartidaCadastro(Partida partidaCadastro) {
		this.partidaCadastro = partidaCadastro;
	}

	public List<Partida> getFilteredPartidas() {
		return filteredPartidas;
	}

	public void setFilteredPartidas(List<Partida> filteredPartidas) {
		this.filteredPartidas = filteredPartidas;
	}
	
	
}
