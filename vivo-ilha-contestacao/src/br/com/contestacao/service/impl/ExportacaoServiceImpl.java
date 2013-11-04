package br.com.contestacao.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.contestacao.fatura.FaturaEletronica;
import br.com.contestacao.fatura.LeitorFaturaEletronica;
import br.com.contestacao.fatura.calculo.CalculoRelatorioAnalise;
import br.com.contestacao.model.Tarifa;
import br.com.contestacao.relatorio.GeradorRelatorioAnalise;
import br.com.contestacao.utils.DateUtils;

import com.google.common.base.Throwables;
import com.google.common.hash.Hashing;


public class ExportacaoServiceImpl implements ExportacaoService {

	private static final long serialVersionUID = 6409155455194634991L;

	@Inject
	private LeitorFaturaEletronica leitorFaturaEletronica = null;

	@Inject
	private CalculoRelatorioAnalise calculoRelatorioAnalise = null;

	@Inject
	private GeradorRelatorioAnalise geradorRelatorioAnalise = null;

	@Override
	public byte[] exportar(byte[] arquivoFatura, List<Tarifa> tarifas) {
		String nomeGeracao = gerarNomeArquivo();

		try {
			nomeGeracao = criarArquivoFatura(nomeGeracao, arquivoFatura);

			FaturaEletronica faturaEletronica = leitorFaturaEletronica.obterFaturaEletronica(nomeGeracao);

			calculoRelatorioAnalise.calcular(faturaEletronica, tarifas);

			return geradorRelatorioAnalise.gerarRelatorioAnalise(faturaEletronica);
		} finally {
			apagarArquivoFatura(nomeGeracao);
		}
	}

	private String gerarNomeArquivo() {
		String nome = "FAT";
		String dataHoraMilli = DateUtils.formatar(new Date(), "yyyyMMddHHmmssSSS");
		String hash = Hashing.goodFastHash(5).hashInt((int) Math.random() * 7).toString();

		return String.format("%s_%s_%s.mdb", nome, dataHoraMilli, hash);
	}

	private String criarArquivoFatura(String nomeArquivo, byte[] arquivoFatura) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(nomeArquivo);
			fileOutputStream.write(arquivoFatura);
			fileOutputStream.flush();
			return nomeArquivo;
		} catch (FileNotFoundException e) {
			throw Throwables.propagate(e);
		} catch (IOException e) {
			throw Throwables.propagate(e);
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					throw Throwables.propagate(e);
				}
			}
		}
	}

	private void apagarArquivoFatura(String nomeArquivo) {
		if (nomeArquivo != null) {
			File arquivo = new File(nomeArquivo);
			arquivo.delete();
		}
	}
}
