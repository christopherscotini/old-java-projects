package br.com.contestacao.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.contestacao.model.Perfil;
import br.com.contestacao.model.Usuario;
import br.com.contestacao.service.PerfilService;
import br.com.contestacao.service.UsuarioService;
import br.com.contestacao.service.exception.ValidacaoException;
import br.com.contestacao.utils.FacesMessages;

@ViewScoped
@Named
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 8817911232036419145L;

	@Inject
	private PerfilService perfilService = null;

	@Inject
	private UsuarioService usuarioService = null;

	private List<Perfil> listaPerfis = null;

	private List<Usuario> listaPesquisa = null;

	private Long idPerfilCadastro = null;

	private Usuario usuarioCadastro = null;

	private Usuario usuarioPesquisa = null;

	public UsuarioBean() {
		super();

		this.usuarioCadastro = new Usuario();
		this.usuarioPesquisa = new Usuario();
	}

	@PostConstruct
	public void iniciar() {
		listaPerfis = perfilService.listar();
		listaPesquisa = usuarioService.listar(usuarioPesquisa);
	}

	public void resetCadastro() {
		usuarioCadastro = new Usuario();
		idPerfilCadastro = null;
	}

	public void confirmar() {
		try {
			usuarioService.salvar(usuarioCadastro, idPerfilCadastro);
		} catch (ValidacaoException e) {
			Messages.addError(null, e.getMessage());
			return;
		}

		resetCadastro();

		listaPesquisa = usuarioService.listar(usuarioPesquisa);

		FacesMessages.exibirMsgCadastroArmazenadoSucesso();
	}

	public void pesquisar() {
		listaPesquisa = usuarioService.listar(usuarioPesquisa);

		if (listaPesquisa == null || listaPesquisa.isEmpty()) {
			FacesMessages.exibirMsgPesqNenhumRegistroEncontrado();
		}
	}

	public void editar(Integer indice) {
		if (indice == null) {
			FacesMessages.exibirMsgPesqNenhumRegistroSelecionado();
			return;
		}

		usuarioCadastro = new Usuario(listaPesquisa.get(indice));
		idPerfilCadastro = usuarioCadastro.getPerfil().getId();
	}

	public List<Perfil> getListaPerfis() {
		return listaPerfis;
	}

	public void setListaPerfis(List<Perfil> listaPerfis) {
		this.listaPerfis = listaPerfis;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Usuario getUsuarioPesquisa() {
		return usuarioPesquisa;
	}

	public void setUsuarioPesquisa(Usuario usuarioPesquisa) {
		this.usuarioPesquisa = usuarioPesquisa;
	}

	public Long getIdPerfilCadastro() {
		return idPerfilCadastro;
	}

	public void setIdPerfilCadastro(Long idPerfilCadastro) {
		this.idPerfilCadastro = idPerfilCadastro;
	}

	public List<Usuario> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<Usuario> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}
}
