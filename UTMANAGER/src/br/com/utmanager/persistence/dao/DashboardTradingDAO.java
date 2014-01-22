package br.com.utmanager.persistence.dao;

import java.util.Date;
import java.util.List;

import br.com.utmanager.business.dto.BalancoCompraVendaSemanal;
import br.com.utmanager.persistence.Dao;

public interface DashboardTradingDAO<T> extends Dao<T, Long>{

	List<BalancoCompraVendaSemanal> balancoCompraVendaSemanal(
			Date now,
			Date last7Days);


}
