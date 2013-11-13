package br.com.portal.business;

import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.UserEntity;


public interface EmpresaBO extends ServiceModel<EmpresaEntity>{

	public EmpresaEntity buscarEmpresaPorUserID(UserEntity user);
	
}
