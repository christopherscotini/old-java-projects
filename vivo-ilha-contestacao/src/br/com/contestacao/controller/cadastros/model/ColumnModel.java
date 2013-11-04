package br.com.contestacao.controller.cadastros.model;

import java.io.Serializable;

public class ColumnModel implements Serializable {

	private static final long serialVersionUID = -4826548860724859605L;

	private String header = null;

	private String property = null;

	private String width = null;

	public ColumnModel(String header, String property, String width) {
		super();
		this.header = header;
		this.property = property;
		this.width = width;
	}

	public String getHeader() {
		return header;
	}

	public String getProperty() {
		return property;
	}

	public String getWidth() {
		return width;
	}
}
