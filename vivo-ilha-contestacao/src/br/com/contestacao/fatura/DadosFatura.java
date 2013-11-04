package br.com.contestacao.fatura;

import java.util.HashMap;
import java.util.Map;

public class DadosFatura {

	private Map<DadosFaturaEnum, Object> dados = null;

	private TipoDadosFaturaEnum tipo = null;

	public DadosFatura(TipoDadosFaturaEnum tipo) {
		super();
		this.dados = new HashMap<DadosFaturaEnum, Object>();
		this.tipo = tipo;
	}

	public void setValorDado(DadosFaturaEnum chave, Object valor) {
		if (chave != null && valor != null) {
			dados.put(chave, valor);
		}
	}

	public Object getValorDado(DadosFaturaEnum chave) {
		if (chave != null) {
			return dados.get(chave);
		}
		return null;
	}

	public TipoDadosFaturaEnum getTipo() {
		return tipo;
	}
}
