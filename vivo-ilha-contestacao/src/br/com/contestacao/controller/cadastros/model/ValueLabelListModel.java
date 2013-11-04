package br.com.contestacao.controller.cadastros.model;

import java.io.Serializable;

public class ValueLabelListModel implements Serializable {

	private static final long serialVersionUID = -6711534164955005992L;

	private Long value;

	private String label;

	public ValueLabelListModel(Long value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	public Long getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return String.format("%s;%s", getValue(), getLabel());
	}

	public static ValueLabelListModel parseString(String str) {
		if (str == null || str.trim().isEmpty()) {
			throw new IllegalArgumentException("Parâmetro não informado: " + str);
		}

		String[] arr = str.split(";");
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Parâmetro fora do padrão: " + str);
		}

		return new ValueLabelListModel(Long.parseLong(arr[0]), arr[1]);
	}
}
