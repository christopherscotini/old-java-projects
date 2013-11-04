package br.com.contestacao.fatura.calculo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.contestacao.fatura.DadosFatura;
import br.com.contestacao.fatura.DadosFaturaEnum;
import br.com.contestacao.fatura.FaturaEletronica;
import br.com.contestacao.fatura.TipoDadosFaturaEnum;
import br.com.contestacao.model.Tarifa;
import br.com.contestacao.model.TipoTarifaEnum;

public class CalculoRelatorioAnalise {

	public void calcular(FaturaEletronica faturaEletronica, List<Tarifa> tarifas) {
		Map<TipoTarifaEnum, Tarifa> mapTipoTarifasChamadas = obterMapTipoTarifasChamadas(tarifas);

		Iterator<DadosFatura> itDadosFatura = faturaEletronica.iteratorDadosFatura();
		while (itDadosFatura.hasNext()) {
			DadosFatura dadosFatura = itDadosFatura.next();

			if (TipoDadosFaturaEnum.CHAMADAS.equals(dadosFatura.getTipo())) {
				calcularValorMinutoChamada(mapTipoTarifasChamadas, dadosFatura);
			} else {
				dadosFatura.setValorDado(DadosFaturaEnum.VALOR_MINUTO, BigDecimal.ZERO);
			}
		}
	}

	private void calcularValorMinutoChamada(Map<TipoTarifaEnum, Tarifa> mapTipoTarifasChamadas, DadosFatura dado) {
		BigDecimal valorMinuto = BigDecimal.ZERO; 

		TipoTarifaEnum tipoTarifa = null;
		if ("15".equals(dado.getValorDado(DadosFaturaEnum.OP))) {
			tipoTarifa = TipoTarifaEnum.VC1;
		} else if ("31".equals(dado.getValorDado(DadosFaturaEnum.OP))) {
			if ("INTERESTADUAL".equals(dado.getValorDado(DadosFaturaEnum.DESCRICAO))) {
				tipoTarifa = TipoTarifaEnum.VC2;
			} else {
				tipoTarifa = TipoTarifaEnum.VC3;
			}
		}

		if (tipoTarifa != null && mapTipoTarifasChamadas.containsKey(tipoTarifa)) {
			Tarifa tarifa = mapTipoTarifasChamadas.get(tipoTarifa);

			if (tarifa.getValor() != null) {
				valorMinuto = tarifa.getValor();
			}
		}

		dado.setValorDado(DadosFaturaEnum.VALOR_MINUTO, valorMinuto);
	}

	private Map<TipoTarifaEnum, Tarifa> obterMapTipoTarifasChamadas(List<Tarifa> tarifas) {
		Map<TipoTarifaEnum, Tarifa> mapTipoTarifasChamadas = new HashMap<TipoTarifaEnum, Tarifa>();
		
		for (Tarifa t : tarifas) {
			Long idTipoTarifa = t.getTipoTarifa().getId();
			if (TipoTarifaEnum.VC1.getCodigo().equals(idTipoTarifa)) {
				mapTipoTarifasChamadas.put(TipoTarifaEnum.VC1, t);
			} else if(TipoTarifaEnum.VC2.getCodigo().equals(idTipoTarifa)) {
				mapTipoTarifasChamadas.put(TipoTarifaEnum.VC2, t);
			} else if(TipoTarifaEnum.VC3.getCodigo().equals(idTipoTarifa)) {
				mapTipoTarifasChamadas.put(TipoTarifaEnum.VC3, t);
			}
		}
		
		return mapTipoTarifasChamadas;
	}
}
