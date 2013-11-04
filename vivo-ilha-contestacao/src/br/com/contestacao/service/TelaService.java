package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.com.contestacao.model.Tela;

public interface TelaService extends Serializable {

	List<Tela> listar();

	Set<String> buscarPorUsuarioLogin(String login);
}