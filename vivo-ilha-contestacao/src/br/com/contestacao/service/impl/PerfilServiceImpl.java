package br.com.contestacao.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Perfil;
import br.com.contestacao.model.Permissao;
import br.com.contestacao.model.PermissaoPerfil;
import br.com.contestacao.persistence.dao.PerfilDao;
import br.com.contestacao.persistence.dao.PermissaoDao;
import br.com.contestacao.service.PerfilService;

@Stateless
public class PerfilServiceImpl implements PerfilService {

	private static final long serialVersionUID = 4097561162579113535L;

	@Inject
	private PermissaoDao permissaoDao = null;

	@Inject
	private PerfilDao perfilDao = null;

	@Override
	public void salvar(Perfil perfil, List<Long> telasId) {
		List<Permissao> permissoes = permissaoDao.findByTela(telasId);

		Date auditData = new Date();
		for (Permissao p : permissoes) {
			PermissaoPerfil permissaoPerfil = new PermissaoPerfil();
			permissaoPerfil.setPermissao(p);
			permissaoPerfil.setPerfil(perfil);
			permissaoPerfil.setDataCriacao(auditData);
			permissaoPerfil.setDataAlteracao(auditData);

			perfil.addPermissaoPerfil(permissaoPerfil);
		}

		perfilDao.save(perfil);
	}

	@Override
	public List<Perfil> listar() {
		return perfilDao.findAll();
	}
}
