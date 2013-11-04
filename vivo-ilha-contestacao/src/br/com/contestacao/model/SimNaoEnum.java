package br.com.contestacao.model;

public enum SimNaoEnum {
	S("Sim"),
	N("Não");

	private String descricao = null;

	private SimNaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean booleanValue() {
		return S.name().equals(name());
	}

	public static SimNaoEnum valueOf(Boolean booleanValue) {
		if (booleanValue != null && booleanValue.booleanValue()) {
			return SimNaoEnum.S;
		}
		return SimNaoEnum.N;
	}

}
