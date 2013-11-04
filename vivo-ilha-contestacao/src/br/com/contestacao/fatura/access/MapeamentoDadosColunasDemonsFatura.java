package br.com.contestacao.fatura.access;

import br.com.contestacao.fatura.DadosFaturaEnum;


public class MapeamentoDadosColunasDemonsFatura extends MapeamentoDadosColunas {

	@Override
	protected void inicializar() {
		mapeamento.put(DadosFaturaEnum.CONTA, "CL_NR_CONTA");
		mapeamento.put(DadosFaturaEnum.MES, "FT_MES_REF");
		mapeamento.put(DadosFaturaEnum.OP, "OP_CD_OPERADORA");
		mapeamento.put(DadosFaturaEnum.TERMINAL, "CF_CELULAR");
		mapeamento.put(DadosFaturaEnum.DESCRICAO, "DF_TP_CHAMADA");
		mapeamento.put(DadosFaturaEnum.TIPO, "DF_SECAO");
		mapeamento.put(DadosFaturaEnum.TIPO_CHAMADA, "DF_SUBSECAO");
		mapeamento.put(DadosFaturaEnum.DURACAO, "DF_DURACAO");
		mapeamento.put(DadosFaturaEnum.VALOR_FATURADO, "DF_VALOR");
		mapeamento.put(DadosFaturaEnum.UF, "OP_UF");
		mapeamento.put(DadosFaturaEnum.VALOR_TARIFA, "DF_TARIFA");
		mapeamento.put(DadosFaturaEnum.DATA_CHAMADA, "DF_DT_CHAMADA");
		mapeamento.put(DadosFaturaEnum.CIDADE_ORIGEM, "DF_CIDADE_ORI");
		mapeamento.put(DadosFaturaEnum.UF_ORIGEM, "DF_UF_ORI");
		mapeamento.put(DadosFaturaEnum.CIDADE_DESTINO, "DF_CIDADE_DEST");
		mapeamento.put(DadosFaturaEnum.UF_DESTINO, "DF_UF_DEST");
		mapeamento.put(DadosFaturaEnum.NUMERO_CHAMADOR, "DF_CHAMADOR");
		mapeamento.put(DadosFaturaEnum.NUMERO_CHAMADO, "DF_CHAMADO");
		mapeamento.put(DadosFaturaEnum.UNIDADE, "DF_UNIDADE");
		mapeamento.put(DadosFaturaEnum.CODIGO_CONTA_NOVA, "COD_CONTA_NOVA");
	}
	

}
