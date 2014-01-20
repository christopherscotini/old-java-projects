package br.com.utmanager.business.exceptions;

import br.com.utmanager.exceptions.BusinessException;


public class NoDataFoundException extends BusinessException {

	private static final long serialVersionUID = 5077420954080626074L;

	public NoDataFoundException(String registro) {
		super("Não foram encontrados "+registro );		
	}
}
