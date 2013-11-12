/**
 * 
 */
package br.com.portal.dao.jpa.cadastro;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.portal.dao.cadastro.SolicitacaoDao;
import br.com.portal.dao.jpa.JpaGenericDao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;

/**
 * @author christopher.rozario
 *
 */

@Repository
public class SolicitacaoDaoImpl extends JpaGenericDao<SolicitacaoEntity, Long> implements SolicitacaoDao{


	@Override
	public List<SolicitacaoEntity> findByClientId(ClienteEntity cliente) {
		return getEntityManager().createQuery("FROM SolicitacaoEntity s WHERE s.clienteSolicitante = "+cliente.getId()).getResultList();
	}

	@Override
	public List<SolicitacaoEntity> findByEmpresaId(EmpresaEntity empresa) {
		return getEntityManager().createQuery("FROM SolicitacaoEntity s WHERE s.empresaPrestadoraServico = "+empresa.getId()).getResultList();
	}

}
