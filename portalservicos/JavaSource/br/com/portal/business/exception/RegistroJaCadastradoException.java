package br.com.portal.business.exception;

import br.com.portal.exceptions.BusinessException;


public class RegistroJaCadastradoException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public RegistroJaCadastradoException(String registro) {
		super(registro + " j� est� cadastrado.");
	}
}
