package br.com.todo.gpes.service.cadastro;

import java.util.List;

import br.com.todo.gpes.model.cadastro.Cargo;

public interface CargoService {

	List<Cargo> obterCargos();

	List<Cargo> obterCargos(String descricao);

	void incluirCargo(Cargo cargo);

	void alterarCargo(Cargo cargo);
}
