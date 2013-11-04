package br.com.todo.gpes.service.exception;

import br.com.todo.gpes.exception.BusinessException;

public class RegistroJaCadastradoException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public RegistroJaCadastradoException(String registro) {
		super(registro + " já está cadastrado.");
	}
}
