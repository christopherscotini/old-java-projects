package br.com.portal.dao.cadastro;

import br.com.portal.dao.Dao;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.UserEntity;

public interface EmpresaDao extends Dao<EmpresaEntity, Long> {

	public boolean existsEmpresa(EmpresaEntity empresa);
	
	public EmpresaEntity findByUserId(UserEntity user);
}
