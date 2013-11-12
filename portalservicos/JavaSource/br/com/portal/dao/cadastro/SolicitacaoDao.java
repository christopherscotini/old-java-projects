package br.com.portal.dao.cadastro;

import java.util.List;

import br.com.portal.dao.Dao;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;

public interface SolicitacaoDao extends Dao<SolicitacaoEntity, Long> {

	List<SolicitacaoEntity>findByClientId(ClienteEntity cliente);
	List<SolicitacaoEntity>findByEmpresaId(EmpresaEntity empresa);
	
}
