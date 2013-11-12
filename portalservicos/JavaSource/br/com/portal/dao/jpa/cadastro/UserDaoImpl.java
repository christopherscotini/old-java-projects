/**
 * 
 */
package br.com.portal.dao.jpa.cadastro;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.dao.cadastro.UserDao;
import br.com.portal.dao.jpa.JpaGenericDao;
import br.com.portal.model.UserEntity;

/**
 * @author christopher.rozario
 *
 */

@Repository
public class UserDaoImpl extends JpaGenericDao<UserEntity, Long> implements UserDao{

	@Override
	@Transactional
	public UserEntity findUserByLogin(String login, String password) {
		try {
			return getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.username = '"+login+"' AND u.password = '"+password+"'" , UserEntity.class).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean existsUser(UserEntity usuario) {
		try{
			StringBuilder query = new StringBuilder();
			query.append("FROM UserEntity u WHERE u.username = '"+usuario.getUsername()+"'");
			if(usuario.getId() != null){
				query.append(" AND u.id <> "+usuario.getId());
			}
			
			getEntityManager().createQuery(query.toString()).getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserEntity> findUserbyFilter(String username) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT u FROM UserEntity u");
		query.append(_ESPACE);
		query.append("WHERE u.username LIKE '"+username+"%'");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}

}
