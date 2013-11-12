/**
 * 
 */
package br.com.portal.dao.jpa.cadastro;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.portal.dao.cadastro.ClienteDao;
import br.com.portal.dao.jpa.JpaGenericDao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.UserEntity;

/**
 * @author christopher.rozario
 *
 */

@Repository
public class ClienteDaoImpl extends JpaGenericDao<ClienteEntity, Long> implements ClienteDao{

	@Override
	public boolean existsCliente(ClienteEntity cliente) {
		StringBuilder query = new StringBuilder();
		query.append("FROM ClienteEntity c WHERE c.cpf <> "+cliente.getCpf());
		if(cliente.getId() != null){
			query.append("AND c.id <> "+cliente.getId());
		}
		
		try{
			getEntityManager().createQuery(query.toString()).getSingleResult();
			return true;
		}catch(NoResultException nre){
			return false;
		}
		
	}

	@Override
	public ClienteEntity findByUserId(UserEntity user) {
		return getEntityManager().createQuery("FROM ClienteEntity c WHERE c.usuario = "+user.getId(), ClienteEntity.class).getSingleResult();
	}

}
