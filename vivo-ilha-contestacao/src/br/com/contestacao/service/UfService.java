package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Uf;

public interface UfService extends Serializable {

	List<Uf> listar();

}
