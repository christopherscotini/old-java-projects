package br.com.utmanager.model;


public enum TipoMovimentacaoEnum {

	COMPRA_JOGADOR(0, "Compra de jogador"),
	VENDA_JOGADOR(1, "Venda de jogador"),
	GANHO_PARTIDA(2, "Ganhos de partida"),
	GANHO_TORNEIO(3, "Ganhos em torneio"),
	COMPRA_OUTROS(4, "Compra de outros");

	private Integer codigo = null;

	private String descricao = null;

	private TipoMovimentacaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoMovimentacaoEnum getTipoFluxoByCodigo(Integer codigo) {
		for (TipoMovimentacaoEnum tipoFluxoEstoqueEnum : values()) {
			if (tipoFluxoEstoqueEnum.getCodigo() == codigo) {
				return tipoFluxoEstoqueEnum;
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
