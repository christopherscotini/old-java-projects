package br.com.contestacao.service.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = -3592145775341485210L;

	public ValidacaoException(String message) {
		super(message);
	}

}
