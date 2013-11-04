package br.com.todo.gpes.service.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.Cargo;
import br.com.todo.gpes.persistence.dao.cadastro.CargoDao;
import br.com.todo.gpes.service.cadastro.CargoService;
import br.com.todo.gpes.service.exception.RegistroJaCadastradoException;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao cargoDao = null;

	public List<Cargo> obterCargos() {
		return cargoDao.findAll();
	}

	public List<Cargo> obterCargos(String descricao) {
		return cargoDao.findByDescricao(descricao);
	}

	public void incluirCargo(Cargo cargo) {
		if (cargoDao.findById(cargo.getCodigo()) != null) {
			throw new RegistroJaCadastradoException("Cargo");
		}

		cargo.setSituacao(AtivoInativoEnum.ATIVO.getCodigo());
		cargoDao.insert(cargo);
	}

	public void alterarCargo(Cargo cargo) {
		cargoDao.update(cargo);
	}

	public CargoDao getCargoDao() {
		return cargoDao;
	}

	public void setCargoDao(CargoDao cargoDao) {
		this.cargoDao = cargoDao;
	}

}
