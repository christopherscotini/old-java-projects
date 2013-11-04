package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Usuario;

public interface UsuarioService extends Serializable {

	void salvar(Usuario usuario, Long idPerfil);

	List<Usuario> listar(Usuario usuario);

	Usuario buscarPorLogin(String login);
}