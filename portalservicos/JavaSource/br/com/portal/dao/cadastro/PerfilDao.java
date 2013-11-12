package br.com.portal.dao.cadastro;

import java.util.List;

import br.com.portal.dao.Dao;
import br.com.portal.model.PerfilEntity;

public interface PerfilDao extends Dao<PerfilEntity, Long> {

	List<PerfilEntity>findAllExcludeAdmin();
	
}
