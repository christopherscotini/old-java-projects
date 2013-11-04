package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Perfil;

public interface PerfilService extends Serializable {

	void salvar(Perfil perfil, List<Long> telasId);

	List<Perfil> listar();
}