package br.com.contestacao.relatorio.poi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import br.com.contestacao.fatura.DadosFatura;
import br.com.contestacao.fatura.DadosFaturaEnum;
import br.com.contestacao.fatura.FaturaEletronica;
import br.com.contestacao.fatura.TipoDadosFaturaEnum;
import br.com.contestacao.relatorio.GeradorRelatorioAnalise;

import com.google.common.base.Throwables;

public class GeradorRelatorioAnaliseExcelPoi implements GeradorRelatorioAnalise {

	private static final short STYLE_VALOR = 69;

	private static final short STYLE_DATA = 71;

	@Override
	public byte[] gerarRelatorioAnalise(FaturaEletronica faturaEletronica) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		InputStream inputStream = null;

		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("Planilha_Analise.xls");

			HSSFWorkbook wb = new HSSFWorkbook(inputStream);
			
			Map<DadosFaturaEnum, HSSFCellStyle> mapCellStyle = obterMapCellStyles(wb);

			HSSFSheet sheet = wb.getSheet("PLANILHA ANÁLISE");

			int row = 1;
			Iterator<DadosFatura> itDadosFatura = faturaEletronica.iteratorDadosFatura();
			while (itDadosFatura.hasNext()) {
				DadosFatura dadosFatura = itDadosFatura.next();

				HSSFRow xssfRow = sheet.getRow(row);

				if (xssfRow == null) {
					xssfRow = sheet.createRow(row);
				}

				for (DadosFaturaEnum dado : DadosFaturaEnum.values()) {
					preencherCell(xssfRow, dadosFatura, dado, mapCellStyle);
				}

				row++;
			}

			preencherCellTotais(sheet, row);

			byteArrayOutputStream = new ByteArrayOutputStream();
			
			wb.write(byteArrayOutputStream);

			byteArrayOutputStream.flush();

			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw Throwables.propagate(e);
		} finally {
			fecharStream(byteArrayOutputStream, inputStream);
		}
	}

	private Map<DadosFaturaEnum, HSSFCellStyle> obterMapCellStyles(HSSFWorkbook wb) {
		Map<DadosFaturaEnum, HSSFCellStyle> mapCellStyle = new HashMap<DadosFaturaEnum, HSSFCellStyle>();

		HSSFCellStyle cellStyleValor = wb.getCellStyleAt(STYLE_VALOR);
		DadosFaturaEnum[] dadosComStylesValor = new DadosFaturaEnum[] {
				DadosFaturaEnum.VALOR_FATURADO, DadosFaturaEnum.VALOR_MINUTO, DadosFaturaEnum.VALOR_DEVIDO,
				DadosFaturaEnum.VALOR_AJUSTE, DadosFaturaEnum.VALOR_TARIFA
		};
		preencherMapCellStyles(mapCellStyle, dadosComStylesValor, cellStyleValor);

		HSSFCellStyle cellStyleData = wb.getCellStyleAt(STYLE_DATA);
		DadosFaturaEnum[] dadosComStylesData = new DadosFaturaEnum[] {
				DadosFaturaEnum.DATA_INICIAL, DadosFaturaEnum.DATA_FINAL, DadosFaturaEnum.DATA_CHAMADA
		};
		preencherMapCellStyles(mapCellStyle, dadosComStylesData, cellStyleData);

		return mapCellStyle;
	}

	private void preencherMapCellStyles(Map<DadosFaturaEnum, HSSFCellStyle> mapCellStyle,
			DadosFaturaEnum[] dadosComStyles, HSSFCellStyle cellStyle) {
		for (DadosFaturaEnum dStyle : dadosComStyles) {
			mapCellStyle.put(dStyle, cellStyle);
		}
	}

	private void preencherCell(HSSFRow xssfRow, DadosFatura dadosFatura, DadosFaturaEnum dado, Map<DadosFaturaEnum, HSSFCellStyle> mapCellStyle) {
		int cell = dado.ordinal();

		HSSFCell xssfCell = xssfRow.getCell(cell); 
		if (xssfCell == null) {
			xssfCell = xssfRow.createCell(cell);
		}

		Object valor = dadosFatura.getValorDado(dado); 
		if (valor != null) {
			if (valor instanceof String) {
				xssfCell.setCellValue((String) valor);
			} else if (valor instanceof BigDecimal) {
				xssfCell.setCellValue(((BigDecimal) valor).doubleValue());
			} else if (valor instanceof Date) {
				xssfCell.setCellValue((Date) valor);
			}
		} else {
			int linha = xssfRow.getRowNum() + 1;
			if (DadosFaturaEnum.DIAS.equals(dado)) {
				xssfCell.setCellFormula(String.format("DAYS360(M%d,N%d) + 1", linha, linha));
			} else if (DadosFaturaEnum.VALOR_AJUSTE.equals(dado)) {
				xssfCell.setCellFormula(String.format("I%d-K%d", linha, linha));
			} else if (DadosFaturaEnum.VALOR_DEVIDO.equals(dado) && TipoDadosFaturaEnum.CHAMADAS.equals(dadosFatura.getTipo())) {
				xssfCell.setCellFormula(String.format("H%d*J%d", linha, linha));
			}
		}

		if (mapCellStyle.containsKey(dado)) {
			xssfCell.setCellStyle(mapCellStyle.get(dado));
		}
	}

	private void preencherCellTotais(HSSFSheet sheet, int row) {
		HSSFRow xssfRow = sheet.getRow(row);

		if (xssfRow == null) {
			xssfRow = sheet.createRow(row);
		}

		preencherFormulaTotal(xssfRow, row, DadosFaturaEnum.VALOR_FATURADO, "I");
		preencherFormulaTotal(xssfRow, row, DadosFaturaEnum.VALOR_DEVIDO, "K");
		preencherFormulaTotal(xssfRow, row, DadosFaturaEnum.VALOR_AJUSTE, "L");
	}

	private void preencherFormulaTotal(HSSFRow xssfRow, int row, DadosFaturaEnum dado, String colunaPlanilha) {
		int cell = dado.ordinal();

		HSSFCell xssfCell = xssfRow.getCell(cell); 
		if (xssfCell == null) {
			xssfCell = xssfRow.createCell(cell);
		}

		int linhaInicio = 2;
		xssfCell.setCellFormula(String.format("SUM(%s%d:%s%d)", colunaPlanilha, linhaInicio, colunaPlanilha, row));
	}

	private void fecharStream(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
		if (byteArrayOutputStream != null) {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				throw Throwables.propagate(e);
			} finally {
				fecharStreamPlanilha(inputStream);
			}
			return;
		}
		fecharStreamPlanilha(inputStream);
	}

	private void fecharStreamPlanilha(InputStream inputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw Throwables.propagate(e);
			}
		}
	}

}
