package br.com.todo.gpes.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.gpes.model.basic.Estado;
import br.com.todo.gpes.model.basic.Municipio;
import br.com.todo.gpes.persistence.dao.basic.EstadoDao;
import br.com.todo.gpes.persistence.dao.basic.MunicipioDao;
import br.com.todo.gpes.service.basic.BasicService;

@Service
public class BasicServiceImpl implements BasicService{
	
	@Autowired
	private EstadoDao estadoDao = null;
	@Autowired
	private MunicipioDao municipioDao = null;
	
	public List<Estado> obterEstados() {
		return estadoDao.findAll();
	}
	
	public List<Municipio> obterMunicipios(Integer codigoEstado, Integer codigoPais) {
		return municipioDao.findByCodigoEstado(codigoEstado, codigoPais);
	}

	public EstadoDao getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}

	public MunicipioDao getMunicipioDao() {
		return municipioDao;
	}

	public void setMunicipioDao(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}
	
	
}
