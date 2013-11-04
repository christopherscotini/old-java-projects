package br.com.todo.gpes.model.cadastro;

public enum AtivoInativoEnum {

	ATIVO("A", "Ativo"),
	INATIVO("I", "Inativo");

	private String codigo = null;

	private String descricao = null;

	private AtivoInativoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static AtivoInativoEnum getAtivoInativoByCodigo(String codigo) {
		for (AtivoInativoEnum ativoInativoEnum : values()) {
			if (ativoInativoEnum.getCodigo().equals(codigo)) {
				return ativoInativoEnum;
			}
		}

		return null;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
