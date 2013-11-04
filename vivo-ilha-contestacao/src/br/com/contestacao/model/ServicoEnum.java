package br.com.contestacao.model;

public enum ServicoEnum {

	TELEFONIA(1L),
	SMS(2L),
	INTERNET_OUTROS_SERVICOS(3L);

	private Long codigo = null;

	private ServicoEnum(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}
}
