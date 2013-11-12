/**
 * 
 */
package br.com.portal.dao.jpa.cadastro;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.portal.dao.cadastro.PerfilDao;
import br.com.portal.dao.jpa.JpaGenericDao;
import br.com.portal.model.PerfilEntity;

/**
 * @author christopher.rozario
 *
 */

@Repository
public class PerfilDaoImpl extends JpaGenericDao<PerfilEntity, Long> implements PerfilDao{

	@Override
	public List<PerfilEntity> findAllExcludeAdmin() {

		return getEntityManager().createQuery("FROM PerfilEntity p WHERE p.descPerfil <> 'ADMINISTRADOR'").getResultList();
	}


}
