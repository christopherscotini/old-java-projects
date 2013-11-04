package br.com.contestacao.utils;

import org.omnifaces.util.Messages;

public final class FacesMessages {

	private FacesMessages() {
		super();
	}

	public static void exibirMsgCadastroArmazenadoSucesso() {
		Messages.addInfo(null, MessagesConstants.REGISTRO_ARMAZENADO_SUCESSO);
	}

	public static void exibirMsgPesqNenhumRegistroEncontrado() {
		Messages.addWarn(null, MessagesConstants.NENHUM_REGISTRO_ENCONTRADO);
	}

	public static void exibirMsgPesqNenhumRegistroSelecionado() {
		Messages.addError(null, MessagesConstants.NENHUM_REGISTRO_SELECIONADO);
	}
}
