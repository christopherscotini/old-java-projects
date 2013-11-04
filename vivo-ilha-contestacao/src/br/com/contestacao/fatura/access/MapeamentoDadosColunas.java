package br.com.contestacao.fatura.access;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.contestacao.fatura.DadosFaturaEnum;

public abstract class MapeamentoDadosColunas {

	protected Map<DadosFaturaEnum, String> mapeamento = null;

	public MapeamentoDadosColunas() {
		super();
		this.mapeamento = new HashMap<DadosFaturaEnum, String>();

		inicializar();
	}

	protected abstract void inicializar();

	public String getColuna(DadosFaturaEnum dado) {
		if (dado != null) {
			return mapeamento.get(dado);
		}
		return null;
	}

	public Set<DadosFaturaEnum> getDados() {
		return mapeamento.keySet();
	}
}