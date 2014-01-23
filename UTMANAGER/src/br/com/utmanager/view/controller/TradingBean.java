package br.com.utmanager.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.utmanager.business.dto.BalancoCompraVendaSemanal;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.view.utils.DataUtils;
import br.com.utmanager.view.utils.GlobalUtils;

@ManagedBean
@SessionScoped
public class TradingBean extends AbstractGenericBean{

	private final String TELA_DASHBOARD_TRADING = "/content/dashboard-trading/dashboardTrading.xhtml";
	
	
	private CartesianChartModel linearGraphBalancoCompraVendaDiario; 
	
	@Override
	public String iniciarTela() {
		
		createLinearGraphBalancoCompraVendaDiario();
		
		return TELA_DASHBOARD_TRADING;
	}
	
	private void createLinearGraphBalancoCompraVendaDiario() {
		setLinearGraphBalancoCompraVendaDiario(new CartesianChartModel()); 

		List<BalancoCompraVendaSemanal> listaGraph = getDashboardTradingBO().balancoCompraVendaSemanal();
		
		LineChartSeries series1 = new LineChartSeries();  
		LineChartSeries series2 = new LineChartSeries();  
        series1.setLabel("Venda");
        series2.setLabel("Compra"); 

        for (int i = 0; i < listaGraph.size(); i++) {
    		if(listaGraph.get(i).getTipoMov().equals(TipoMovimentacaoEnum.VENDA_JOGADOR)){
    			series1.set(DataUtils.parseString(listaGraph.get(i).getDia(), "dd/MM"), GlobalUtils.verificaIntegerNulo(listaGraph.get(i).getQuantidadeVendas()));
    		}else{
    			if(listaGraph.get(i).getTipoMov().equals(TipoMovimentacaoEnum.COMPRA_JOGADOR)){
    				series2.set(DataUtils.parseString(listaGraph.get(i).getDia(), "dd/MM"), GlobalUtils.verificaIntegerNulo(listaGraph.get(i).getQuantidadeCompras()));
    			}    			
    		}
	    		
		}

        linearGraphBalancoCompraVendaDiario.addSeries(series1);
        linearGraphBalancoCompraVendaDiario.addSeries(series2);
		
	}
	
	

	public CartesianChartModel getLinearGraphBalancoCompraVendaDiario() {
		return linearGraphBalancoCompraVendaDiario;
	}

	public void setLinearGraphBalancoCompraVendaDiario(
			CartesianChartModel linearGraphBalancoCompraVendaDiario) {
		this.linearGraphBalancoCompraVendaDiario = linearGraphBalancoCompraVendaDiario;
	}

	
}
