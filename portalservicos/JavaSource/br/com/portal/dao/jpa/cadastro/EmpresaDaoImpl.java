/**
 * 
 */
package br.com.portal.dao.jpa.cadastro;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.portal.dao.cadastro.EmpresaDao;
import br.com.portal.dao.jpa.JpaGenericDao;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.UserEntity;

/**
 * @author christopher.rozario
 *
 */

@Repository
public class EmpresaDaoImpl extends JpaGenericDao<EmpresaEntity, Long> implements EmpresaDao{

	@Override
	public boolean existsEmpresa(EmpresaEntity empresa) {
		
		StringBuilder query = new StringBuilder();
		query.append("FROM EmpresaEntity e WHERE e.cnpj <> "+empresa.getCnpj());
		if(empresa.getId() != null){
			query.append("AND e.id <> "+empresa.getId());
		}
		
		try{
			getEntityManager().createQuery(query.toString()).getSingleResult();
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}
	
	@Override
	public EmpresaEntity findByUserId(UserEntity user) {
		return getEntityManager().createQuery("FROM EmpresaEntity e WHERE e.usuario = "+user.getId(), EmpresaEntity.class).getSingleResult();
	}


}
