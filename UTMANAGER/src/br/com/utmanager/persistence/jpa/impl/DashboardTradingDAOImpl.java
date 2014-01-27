package br.com.utmanager.persistence.jpa.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.utmanager.business.dto.BalancoCompraVendaSemanal;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.persistence.dao.DashboardTradingDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;
import br.com.utmanager.view.utils.DataUtils;

@Repository
public class DashboardTradingDAOImpl<T> extends JpaGenericDao<T, Long> implements DashboardTradingDAO<T>{

	@Override
	public List<BalancoCompraVendaSemanal> balancoCompraVendaSemanal(
			Date now,
			Date last7Days) {
		
		List<BalancoCompraVendaSemanal> returnzz = new ArrayList<BalancoCompraVendaSemanal>();
		
		StringBuilder query = new StringBuilder();
		querybalancoCompraVendaSemanal(query, now, last7Days);
		convertResultSet(getEntityManager().createNativeQuery(query.toString()).getResultList(), returnzz);
		
		return returnzz;
	}

	private List<BalancoCompraVendaSemanal> convertResultSet(List<Object[]> resultList, List<BalancoCompraVendaSemanal> returnzz) {
		
		for (int i = 0; i < resultList.size(); i++) {
			BalancoCompraVendaSemanal obj = new BalancoCompraVendaSemanal();
			
			if(resultList.get(i)[2].toString().equals(TipoMovimentacaoEnum.VENDA_JOGADOR.name())){
				obj.setQuantidadeVendas(Integer.parseInt(resultList.get(i)[0].toString()));
				obj.setValorVendas(new BigDecimal(resultList.get(i)[3].toString()));
				obj.setTipoMov(TipoMovimentacaoEnum.VENDA_JOGADOR);
				obj.setDia((Date)resultList.get(i)[1]);
			}else{
				if(resultList.get(i)[2].toString().equals(TipoMovimentacaoEnum.COMPRA_JOGADOR.name())){
					obj.setValorCompras(new BigDecimal(resultList.get(i)[3].toString()));
					obj.setQuantidadeCompras(Integer.parseInt(resultList.get(i)[0].toString()));
					obj.setTipoMov(TipoMovimentacaoEnum.COMPRA_JOGADOR);
					obj.setDia((Date)resultList.get(i)[1]);
				}
			}
			returnzz.add(obj);
		}
		
		
		return returnzz;
	}

	private void querybalancoCompraVendaSemanal(StringBuilder query, Date now, Date last7Days) {
		
//		SELECT count(*) AS QTDE, CAST(f.DT_MOVIMENTACAO AS DATE) , f.TP_MOVIMENTACAO
//			FROM tb_financa AS f 
//		WHERE f.DT_MOVIMENTACAO BETWEEN '15/01/2014 00:00:00' AND '2014-01-23 23:59:59' 
//			AND f.TP_MOVIMENTACAO = 'COMPRA_JOGADOR' OR f.TP_MOVIMENTACAO = 'VENDA_JOGADOR' 
//		GROUP BY CAST(f.DT_MOVIMENTACAO AS DATE), f.TP_MOVIMENTACAO
		
		query.append(" SELECT count(*) AS QTDE, CAST(f.DT_MOVIMENTACAO AS DATE), f.TP_MOVIMENTACAO, f.VL_MOVIMENTADO FROM tb_financa AS f");
		query.append(" WHERE f.DT_MOVIMENTACAO BETWEEN '"
				+ DataUtils.parseString(last7Days, "dd/MM/yyyy")
				+ " 00:00:00' AND '"
				+ DataUtils.parseString(now, "yyyy-MM-dd")
				+ " 23:59:59'");
		query.append(" AND f.TP_MOVIMENTACAO = 'COMPRA_JOGADOR' OR f.TP_MOVIMENTACAO = 'VENDA_JOGADOR' ");
		query.append(" GROUP BY CAST(f.DT_MOVIMENTACAO AS DATE), f.TP_MOVIMENTACAO");
		query.append(" ORDER BY CAST(f.DT_MOVIMENTACAO AS DATE) ");
		
	}

	
}
