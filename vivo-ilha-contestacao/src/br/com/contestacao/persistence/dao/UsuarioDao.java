package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Usuario;
import br.com.contestacao.persistence.Dao;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = -2642697631750388720L;

	@Inject
	private Dao genericDao = null;

	public void save(Usuario usuario) {
		genericDao.save(usuario);
	}

	public List<Usuario> findByNome(Usuario usuario) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		Expression<String> expressionNome = root.get("nome");

		root.fetch("usuarioPerfil");

		if (usuario.getNome() != null) {
			String nome = String.format("%%%s%%", usuario.getNome());
			criteriaQuery.where(criteriaBuilder.like(expressionNome, nome));
		}

		criteriaQuery.orderBy(criteriaBuilder.asc(expressionNome));

		return genericDao.findAll(criteriaQuery);
	}

	public Usuario findByLogin(String login) {
		if (login == null) {
			return null;
		}	

		return findBydLoginId(login, null);
	}

	public Usuario findBydLoginId(String login, Long id) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		
		Predicate predicate = null;
		if (id != null) {
			predicate = criteriaBuilder.and(criteriaBuilder.notEqual(root.get("id"), id),
					criteriaBuilder.equal(root.get("login"), login));
		} else {
			predicate = criteriaBuilder.equal(root.get("login"), login);
		}

		criteriaQuery.where(predicate);

		try {
			return genericDao.find(criteriaQuery);
		} catch (NoResultException e) {
			return null;
		}
	}
}
