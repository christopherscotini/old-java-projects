package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.PermissaoPerfil;
import br.com.contestacao.model.Tela;
import br.com.contestacao.model.Usuario;
import br.com.contestacao.model.UsuarioPerfil;
import br.com.contestacao.persistence.Dao;

public class TelaDao implements Serializable {

	private static final long serialVersionUID = 2868866198844607530L;

	@Inject
	private Dao genericDao = null;

	public List<Tela> findAll() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Tela> criteriaQuery = criteriaBuilder.createQuery(Tela.class);

		Root<Tela> root = criteriaQuery.from(Tela.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

		return genericDao.findAll(criteriaQuery);
	}

	public Set<String> findByUsuarioLogin(String login) {
		if (login == null) {
			return null;
		}

		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		root.join("usuarioPerfil").join("perfil").join("permissoesPerfil").join("permissao").join("tela");

		criteriaQuery.where(criteriaBuilder.equal(root.get("login"), login));

		Usuario usuario = genericDao.find(criteriaQuery);

		Set<String> telas = new HashSet<String>();
		if (usuario != null) {
			for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfil()) {
				for (PermissaoPerfil permissaoPerfil : usuarioPerfil.getPerfil().getPermissoesPerfil()) {
					Tela tela = permissaoPerfil.getPermissao().getTela();
					if (tela != null) {
						telas.add(tela.getNome());
					}
				}
			}
		}

		return telas;
	}
}
