package br.com.utmanager.business.exceptions;

import br.com.utmanager.exceptions.BusinessException;


public class RegistroNaoEncontradoException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public RegistroNaoEncontradoException(String registro) {
		super(registro + " não encontrado.");		
	}
}
