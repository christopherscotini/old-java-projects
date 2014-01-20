package br.com.utmanager.business.exceptions;

import br.com.utmanager.exceptions.BusinessException;


public class FormInconsistenteException extends BusinessException {

	private static final long serialVersionUID = 5077420954080626074L;

	public FormInconsistenteException(String registro) {
		super(registro );		
	}
}
