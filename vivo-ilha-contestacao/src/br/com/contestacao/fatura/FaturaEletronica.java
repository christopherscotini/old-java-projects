package br.com.contestacao.fatura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaturaEletronica {

	private List<DadosFatura> listaServicosCelular = null;

	private List<DadosFatura> listaDemonsFatura = null;

	public FaturaEletronica() {
		super();
		this.listaServicosCelular = new ArrayList<DadosFatura>();
		this.listaDemonsFatura = new ArrayList<DadosFatura>();
	}

	public void addServicosCelular(DadosFatura servicosCelular) {
		listaServicosCelular.add(servicosCelular);
	}

	public void addDemonsFatura(DadosFatura demonsFatura) {
		listaDemonsFatura.add(demonsFatura);
	}

	public Iterator<DadosFatura> iteratorDadosFatura() {
		List<DadosFatura> total = new ArrayList<DadosFatura>(listaServicosCelular);
		total.addAll(listaDemonsFatura);
		return total.iterator();
	}
}
