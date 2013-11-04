package br.com.todo.gpes.service.basic;

import java.util.List;

import br.com.todo.gpes.model.basic.Estado;
import br.com.todo.gpes.model.basic.Municipio;

public interface BasicService {
	List<Estado> obterEstados();
	
	List<Municipio> obterMunicipios(Integer codigoEstado, Integer codigoPais);
}
