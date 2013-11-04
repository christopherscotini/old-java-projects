package br.com.todo.gpes.view.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.todo.gpes.view.constants.MessagesConstants;

public final class FacesUtils {

	private FacesUtils() {
		super();
	}

	public static void addMessageInclusaoSucesso() {
		addInfoMessage(MessagesConstants.INCLUSAO_SUCESSO);
	}

	public static void addMessageAlteracaoSucesso() {
		addInfoMessage(MessagesConstants.ALTERACAO_SUCESSO);
	}

	public static void addErrorMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, msg);
	}

	public static void addInfoMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, msg);
	}

	private static void addMessage(FacesMessage.Severity severity, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, msg));
	}
}
