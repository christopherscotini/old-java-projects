package br.com.contestacao.model;

public enum TipoTarifaEnum {

	VC1(1L),
	VC2(2L),
	VC3(3L),
	NACIONAL(4L),
	INTERNACIONAL(5L),
	VALOR(6L);

	private Long codigo = null;

	private TipoTarifaEnum(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}
}
