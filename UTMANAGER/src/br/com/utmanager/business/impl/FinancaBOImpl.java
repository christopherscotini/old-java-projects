package br.com.utmanager.business.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.FinancaBO;

@Service
public class FinancaBOImpl extends GenericBO implements FinancaBO{

	@Override
	public BigDecimal getSaldoAtual() {

		return getFinancaDao().getSaldoAtual();
	}
}
