package br.com.utmanager.business.exceptions;

import br.com.utmanager.exceptions.BusinessException;


public class RegistroJaCadastradoException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public RegistroJaCadastradoException(String registro) {
		super(registro + " já está cadastrado(a).");
	}
}
