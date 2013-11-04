package br.com.contestacao.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Perfil;
import br.com.contestacao.model.SimNaoEnum;
import br.com.contestacao.model.Usuario;
import br.com.contestacao.model.UsuarioPerfil;
import br.com.contestacao.persistence.dao.UsuarioDao;
import br.com.contestacao.service.UsuarioService;
import br.com.contestacao.service.exception.ValidacaoException;
import br.com.contestacao.utils.HashUtils;
import br.com.contestacao.utils.MessagesConstants;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	private static final long serialVersionUID = 764804931891146161L;

	@Inject
	private UsuarioDao usuarioDao = null;

	@Override
	public void salvar(Usuario usuario, Long idPerfil) {
		if (!isLoginValido(usuario)) {
			throw new ValidacaoException(MessagesConstants.LOGIN_EXISTENTE);
		}

		if (usuario.getId() == null) {
			popularUsuarioInclusao(usuario, idPerfil);
		} else {
			popularUsuarioAlteracao(usuario, idPerfil);
		}

		usuario.setSenha(HashUtils.md5(usuario.getSenha()));

		usuarioDao.save(usuario);
	}

	private void popularUsuarioInclusao(Usuario usuario, Long idPerfil) {
		Date dataAuditoria = new Date();

		Perfil perfil = new Perfil();
		perfil.setId(idPerfil);

		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setPerfil(perfil);
		usuarioPerfil.setUsuario(usuario);
		usuarioPerfil.setDataCriacao(dataAuditoria);
		usuarioPerfil.setDataAlteracao(dataAuditoria);

		usuario.addUsuarioPerfil(usuarioPerfil);

		usuario.setTentativaLog(0l);
		usuario.setAdmin(SimNaoEnum.N);
	}

	private void popularUsuarioAlteracao(Usuario usuario, Long idPerfil) {
		Date dataAuditoria = new Date();

		Perfil perfil = usuario.getPerfil();
		if (!idPerfil.equals(perfil.getId())) {
			perfil = new Perfil();
			perfil.setId(idPerfil);

			UsuarioPerfil usuarioPerfil = usuario.getUsuarioPerfil().iterator().next();
			usuarioPerfil.setPerfil(perfil);
			usuarioPerfil.setDataAlteracao(dataAuditoria);
		}
	}

	private boolean isLoginValido(Usuario usuario) {
		return usuarioDao.findBydLoginId(usuario.getLogin(), usuario.getId()) == null;
	}

	@Override
	public List<Usuario> listar(Usuario usuario) {
		return usuarioDao.findByNome(usuario);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		return usuarioDao.findByLogin(login);
	}
}
