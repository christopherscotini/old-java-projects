package br.com.portal.business.exception;

import br.com.portal.exceptions.BusinessException;


public class NoDataFoundException extends BusinessException {

	private static final long serialVersionUID = 5077420954080626074L;

	public NoDataFoundException(String registro) {
		super("N�o foram encontrados "+registro );		
	}
}
