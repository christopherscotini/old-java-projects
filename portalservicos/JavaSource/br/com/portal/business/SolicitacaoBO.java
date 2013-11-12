package br.com.portal.business;

import java.util.List;

import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.SolicitacaoEntity;


public interface SolicitacaoBO extends ServiceModel<SolicitacaoEntity>{

	public List<SolicitacaoEntity> listarSolicitacaoCliente(ClienteEntity cliente);
	public List<SolicitacaoEntity> listarSolicitacaoEmpresa(EmpresaEntity empresa);

}
