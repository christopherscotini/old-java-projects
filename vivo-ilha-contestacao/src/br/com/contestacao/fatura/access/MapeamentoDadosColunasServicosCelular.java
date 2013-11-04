package br.com.contestacao.fatura.access;

import br.com.contestacao.fatura.DadosFaturaEnum;

public class MapeamentoDadosColunasServicosCelular extends MapeamentoDadosColunas {

	@Override
	protected void inicializar() {
		mapeamento.put(DadosFaturaEnum.CONTA, "CL_NR_CONTA");
		mapeamento.put(DadosFaturaEnum.MES, "FT_MES_REF");
		mapeamento.put(DadosFaturaEnum.OP, "OP_CD_OPERADORA");
		mapeamento.put(DadosFaturaEnum.TERMINAL, "CF_CELULAR");
		mapeamento.put(DadosFaturaEnum.DESCRICAO, "SC_NM_SERVICO");
		mapeamento.put(DadosFaturaEnum.TIPO, "SC_DS_SERVICO");
		mapeamento.put(DadosFaturaEnum.VALOR_FATURADO, "SC_VALOR");
		mapeamento.put(DadosFaturaEnum.DATA_INICIAL, "SC_DT_INICIO");
		mapeamento.put(DadosFaturaEnum.DATA_FINAL, "SC_DT_FINAL");
		mapeamento.put(DadosFaturaEnum.SEQUENCIA, "SC_SEQ");
		mapeamento.put(DadosFaturaEnum.QUANTIDADE, "SC_QTDE");
		mapeamento.put(DadosFaturaEnum.IMPOSTO, "SC_SG_IMPOSTO");
		mapeamento.put(DadosFaturaEnum.PORCENTAGEM_IMPOSTO, "SC_PCT_IMPOSTO");
		mapeamento.put(DadosFaturaEnum.PPU, "PPU");
	}

}
