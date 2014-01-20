package br.com.utmanager.persistence.dao;

import java.math.BigDecimal;

import br.com.utmanager.model.Financa;
import br.com.utmanager.persistence.Dao;

public interface FinancaDAO extends Dao<Financa, Long>{

	BigDecimal getSaldoAtual();

}
