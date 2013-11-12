package br.com.portal.business;

import java.util.List;

import br.com.portal.model.PerfilEntity;


public interface PerfilBO extends ServiceModel<PerfilEntity>{

	public List<PerfilEntity> listarTodosExcetoAdmin();

}
