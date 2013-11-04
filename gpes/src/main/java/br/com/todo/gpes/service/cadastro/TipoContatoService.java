package br.com.todo.gpes.service.cadastro;

import java.util.List;

import br.com.todo.gpes.model.cadastro.TipoContato;

public interface TipoContatoService {

	//List<Cargo> obterCargos();

	List<TipoContato> obterTipoContato(String descricao, String situacao);

	void incluirTipoContato(TipoContato tipoContato);

	void alterarTipoContato(TipoContato tipoContato);
}
