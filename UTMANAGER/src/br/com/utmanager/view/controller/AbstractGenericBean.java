package br.com.utmanager.view.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import br.com.utmanager.business.bo.CategoriaJogadorBO;
import br.com.utmanager.business.bo.ClubeJogadorBO;
import br.com.utmanager.business.bo.DashboardTradingBO;
import br.com.utmanager.business.bo.FinancaBO;
import br.com.utmanager.business.bo.JogadorBO;
import br.com.utmanager.business.bo.LigaJogadorBO;
import br.com.utmanager.business.bo.NacionalidadeJogadorBO;
import br.com.utmanager.business.bo.PartidasBO;
import br.com.utmanager.business.bo.PosicaoJogadorBO;
import br.com.utmanager.business.bo.StatusJogadorBO;
import br.com.utmanager.model.CategoriaJogador;
import br.com.utmanager.model.ClubeJogador;
import br.com.utmanager.model.LigaJogador;
import br.com.utmanager.model.NacionalidadeJogador;
import br.com.utmanager.model.PosicaoJogador;
import br.com.utmanager.model.StatusJogador;

public abstract class AbstractGenericBean {
	
	@ManagedProperty(value = "#{jogadorBOImpl}")
	private JogadorBO jogadorBO = null;

	@ManagedProperty(value = "#{posicaoJogadorBOImpl}")
	private PosicaoJogadorBO posicaoJogadorBO = null;

	@ManagedProperty(value = "#{categoriaJogadorBOImpl}")
	private CategoriaJogadorBO categoriaJogadorBO = null;
	
	@ManagedProperty(value = "#{nacionalidadeJogadorBOImpl}")
	private NacionalidadeJogadorBO nacionalidadeJogadorBO = null;
	
	@ManagedProperty(value = "#{clubeJogadorBOImpl}")
	private ClubeJogadorBO clubeJogadorBO = null;
	
	@ManagedProperty(value = "#{ligaJogadorBOImpl}")
	private LigaJogadorBO ligaJogadorBO = null;
	
	@ManagedProperty(value = "#{statusJogadorBOImpl}")
	private StatusJogadorBO statusJogadorBO = null;
	
	@ManagedProperty(value = "#{partidasBOImpl}")
	private PartidasBO partidasBO = null;

	@ManagedProperty(value = "#{financaBOImpl}")
	private FinancaBO financaBO = null;

	@ManagedProperty(value = "#{dashboardTradingBOImpl}")
	private DashboardTradingBO dashboardTradingBO = null;

	public abstract String iniciarTela();
	
	
	public List<PosicaoJogador>getListaPosicaoJogador(){
		return getPosicaoJogadorBO().listarTodos();
	}

	public List<CategoriaJogador>getListaCategoriaJogador(){
		return getCategoriaJogadorBO().listarTodos();
	}
	
	public List<NacionalidadeJogador>getListaNacionalidadeJogador(){
		return getNacionalidadeJogadorBO().listarTodos();
	}
	
	public List<ClubeJogador>getListaClubeJogador(){
		return getClubeJogadorBO().listarTodos();
	}
	
	public List<LigaJogador>getListaLigaJogador(){
		return getLigaJogadorBO().listarTodos();
	}
	
	public List<StatusJogador>getListaStatusJogador(){
		return getStatusJogadorBO().listarTodos();
	}
	
	public JogadorBO getJogadorBO() {
		return jogadorBO;
	}

	public void setJogadorBO(JogadorBO jogadorBO) {
		this.jogadorBO = jogadorBO;
	}

	public PosicaoJogadorBO getPosicaoJogadorBO() {
		return posicaoJogadorBO;
	}

	public void setPosicaoJogadorBO(PosicaoJogadorBO posicaoJogadorBO) {
		this.posicaoJogadorBO = posicaoJogadorBO;
	}

	public CategoriaJogadorBO getCategoriaJogadorBO() {
		return categoriaJogadorBO;
	}

	public void setCategoriaJogadorBO(CategoriaJogadorBO categoriaJogadorBO) {
		this.categoriaJogadorBO = categoriaJogadorBO;
	}

	public NacionalidadeJogadorBO getNacionalidadeJogadorBO() {
		return nacionalidadeJogadorBO;
	}

	public void setNacionalidadeJogadorBO(
			NacionalidadeJogadorBO nacionalidadeJogadorBO) {
		this.nacionalidadeJogadorBO = nacionalidadeJogadorBO;
	}

	public ClubeJogadorBO getClubeJogadorBO() {
		return clubeJogadorBO;
	}

	public void setClubeJogadorBO(ClubeJogadorBO clubeJogadorBO) {
		this.clubeJogadorBO = clubeJogadorBO;
	}

	public LigaJogadorBO getLigaJogadorBO() {
		return ligaJogadorBO;
	}

	public void setLigaJogadorBO(LigaJogadorBO ligaJogadorBO) {
		this.ligaJogadorBO = ligaJogadorBO;
	}

	public StatusJogadorBO getStatusJogadorBO() {
		return statusJogadorBO;
	}

	public void setStatusJogadorBO(StatusJogadorBO statusJogadorBO) {
		this.statusJogadorBO = statusJogadorBO;
	}


	public PartidasBO getPartidasBO() {
		return partidasBO;
	}


	public void setPartidasBO(PartidasBO partidasBO) {
		this.partidasBO = partidasBO;
	}


	public FinancaBO getFinancaBO() {
		return financaBO;
	}


	public void setFinancaBO(FinancaBO financaBO) {
		this.financaBO = financaBO;
	}


	public DashboardTradingBO getDashboardTradingBO() {
		return dashboardTradingBO;
	}


	public void setDashboardTradingBO(DashboardTradingBO dashboardTradingBO) {
		this.dashboardTradingBO = dashboardTradingBO;
	}
	
}
