package br.com.utmanager.business;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.utmanager.persistence.dao.CategoriaJogadorDAO;
import br.com.utmanager.persistence.dao.ClubeJogadorDAO;
import br.com.utmanager.persistence.dao.FinancaDAO;
import br.com.utmanager.persistence.dao.JogadorDAO;
import br.com.utmanager.persistence.dao.LigaJogadorDAO;
import br.com.utmanager.persistence.dao.NacionalidadeJogadorDAO;
import br.com.utmanager.persistence.dao.PartidaDAO;
import br.com.utmanager.persistence.dao.PosicaoJogadorDAO;
import br.com.utmanager.persistence.dao.StatusJogadorDAO;

public abstract class GenericBO {
	
	@Autowired
	private CategoriaJogadorDAO categoriaJogadorDao = null;

	@Autowired
	private ClubeJogadorDAO clubeJogadorDao = null;
	
	@Autowired
	private JogadorDAO JogadorDao = null;
	
	@Autowired
	private NacionalidadeJogadorDAO nacionalidadeJogadorDao = null;
	
	@Autowired
	private PosicaoJogadorDAO posicaoJogadorDao = null;

	@Autowired
	private LigaJogadorDAO ligaJogadorDao = null;

	@Autowired
	private StatusJogadorDAO statusJogadorDao = null;
	
	@Autowired
	private PartidaDAO partidaDao = null;

	@Autowired
	private FinancaDAO financaDao = null;
	

	public JogadorDAO getJogadorDao() {
		return JogadorDao;
	}

	public void setJogadorDao(JogadorDAO jogadorDao) {
		JogadorDao = jogadorDao;
	}

	public CategoriaJogadorDAO getCategoriaJogadorDao() {
		return categoriaJogadorDao;
	}

	public void setCategoriaJogadorDao(CategoriaJogadorDAO categoriaJogadorDao) {
		this.categoriaJogadorDao = categoriaJogadorDao;
	}

	public ClubeJogadorDAO getClubeJogadorDao() {
		return clubeJogadorDao;
	}

	public void setClubeJogadorDao(ClubeJogadorDAO clubeJogadorDao) {
		this.clubeJogadorDao = clubeJogadorDao;
	}

	public NacionalidadeJogadorDAO getNacionalidadeJogadorDao() {
		return nacionalidadeJogadorDao;
	}

	public void setNacionalidadeJogadorDao(
			NacionalidadeJogadorDAO nacionalidadeJogadorDao) {
		this.nacionalidadeJogadorDao = nacionalidadeJogadorDao;
	}

	public PosicaoJogadorDAO getPosicaoJogadorDao() {
		return posicaoJogadorDao;
	}

	public void setPosicaoJogadorDao(PosicaoJogadorDAO posicaoJogadorDao) {
		this.posicaoJogadorDao = posicaoJogadorDao;
	}

	public LigaJogadorDAO getLigaJogadorDao() {
		return ligaJogadorDao;
	}

	public void setLigaJogadorDao(LigaJogadorDAO ligaJogadorDao) {
		this.ligaJogadorDao = ligaJogadorDao;
	}

	public StatusJogadorDAO getStatusJogadorDao() {
		return statusJogadorDao;
	}

	public void setStatusJogadorDao(StatusJogadorDAO statusJogadorDao) {
		this.statusJogadorDao = statusJogadorDao;
	}

	public PartidaDAO getPartidaDao() {
		return partidaDao;
	}

	public void setPartidaDao(PartidaDAO partidaDao) {
		this.partidaDao = partidaDao;
	}

	public FinancaDAO getFinancaDao() {
		return financaDao;
	}

	public void setFinancaDao(FinancaDAO financaDao) {
		this.financaDao = financaDao;
	}
	
}
