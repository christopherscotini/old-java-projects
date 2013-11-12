package br.com.portal.model;


public enum StatusSolicitacao {

	PENDENTE(0, "Aguardando aprova��o"),
	CONFIRMADO(1, "Solicita��o aprovada"),
	RECUSADO(2, "Solicita��o recusada");

	private Integer codigo = null;

	private String descricao = null;

	private StatusSolicitacao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static StatusSolicitacao getStatusSolicitacaoByCodigo(Integer codigo) {
		for (StatusSolicitacao statusSolicitacao : values()) {
			if (statusSolicitacao.getCodigo() == codigo) {
				return statusSolicitacao;
			}
		}

		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return descricao;
	}
	
}
