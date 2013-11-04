package br.com.chris.sccgo.persistence.dao.cadastro;

import java.util.List;

import br.com.chris.sccgo.model.Solicitacao;
import br.com.chris.sccgo.persistence.dao.Dao;


public interface ISolicitacaoDao extends Dao<Solicitacao, Long>{
	
	public List<Solicitacao>findBySolicitacoesPendentes();
	public List<Solicitacao>findBySolicitacoesFinalizadas();
}
