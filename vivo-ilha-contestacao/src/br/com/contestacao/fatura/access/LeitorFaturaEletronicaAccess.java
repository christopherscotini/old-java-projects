package br.com.contestacao.fatura.access;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import br.com.contestacao.fatura.DadosFatura;
import br.com.contestacao.fatura.DadosFaturaEnum;
import br.com.contestacao.fatura.FaturaEletronica;
import br.com.contestacao.fatura.LeitorFaturaEletronica;
import br.com.contestacao.fatura.TipoDadosFaturaEnum;

import com.google.common.base.Throwables;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class LeitorFaturaEletronicaAccess implements LeitorFaturaEletronica {

	@Override
	public FaturaEletronica obterFaturaEletronica(String arquivoFatura) {
		FaturaEletronica faturaEletronica = new FaturaEletronica();

		Database db = null;
		try {
			db = DatabaseBuilder.open(new File(arquivoFatura));

			Table tbServicosCelular = db.getTable("TB_SERVICOS_CELULAR");
			MapeamentoDadosColunasServicosCelular mapServicosCelular = new MapeamentoDadosColunasServicosCelular();
			popularFatura(faturaEletronica, tbServicosCelular, mapServicosCelular, TipoDadosFaturaEnum.SERVICOS);

			Table tbDemonsfatura = db.getTable("TB_DEMONSFATURA");
			MapeamentoDadosColunasDemonsFatura mapDemonsFatura = new MapeamentoDadosColunasDemonsFatura();
			popularFatura(faturaEletronica, tbDemonsfatura, mapDemonsFatura, TipoDadosFaturaEnum.CHAMADAS);
		} catch (IOException e) {
			throw Throwables.propagate(e);
		} finally {
			if (db != null) {
				try {
					db.close();
				} catch (IOException e) {
					throw Throwables.propagate(e);
				}
			}
		}

		return faturaEletronica;
	}

	private void popularFatura(FaturaEletronica faturaEletronica, Table table, MapeamentoDadosColunas mapColunas, TipoDadosFaturaEnum tipo) {
		for (Row row : table) {
			DadosFatura dadosFatura = new DadosFatura(tipo);

			for (DadosFaturaEnum dado : mapColunas.getDados()) {
				String coluna = mapColunas.getColuna(dado);
				Object valorConvertido = converterTipoValor(dado, row.get(coluna));
				dadosFatura.setValorDado(dado, valorConvertido);
			}

			if (TipoDadosFaturaEnum.SERVICOS.equals(tipo)) {
				faturaEletronica.addServicosCelular(dadosFatura);
			} else {
				faturaEletronica.addDemonsFatura(dadosFatura);
			}
		}
	}

	private Object converterTipoValor(DadosFaturaEnum dado, Object valor) {
		if (valor == null) {
			return null;
		}

		if (DadosFaturaEnum.DURACAO.equals(dado)) {
			return new BigDecimal(((Float) valor).toString());
		}

		if (valor instanceof Date) {
			return new Date(((Date) valor).getTime());
		} else if (valor instanceof BigDecimal)  {
			return valor;
		}

		return valor.toString();
	}
}
