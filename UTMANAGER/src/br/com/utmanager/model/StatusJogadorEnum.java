package br.com.utmanager.model;


public enum StatusJogadorEnum {

	NO_CLUBE(1L, "No Clube"),
	A_VENDA(2L, "A Venda"),
	VENDIDO(3L, "Vendido"),
	NA_MIRA(4L, "Na Mira");

	private Long codigo = null;

	private String descricao = null;

	private StatusJogadorEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static StatusJogadorEnum getTipoFluxoByCodigo(Integer codigo) {
		for (StatusJogadorEnum tipoFluxoEstoqueEnum : values()) {
			if (tipoFluxoEstoqueEnum.getCodigo().equals(codigo)) {
				return tipoFluxoEstoqueEnum;
			}
		}

		return null;
	}

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
