package br.com.todo.gpes.view.controller.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.todo.gpes.model.cadastro.CentroCusto;

@ManagedBean(name="centroCustoBean")
@SessionScoped
public class CentroCustoBean {
	//ESBOÇO
	private CentroCusto centroCusto;
	private List<CentroCusto> listaCentroCusto;
	
	public CentroCustoBean() {
		popularDataTableCentroCusto();
	}
	
	public void popularDataTableCentroCusto(){
		listaCentroCusto = new ArrayList<CentroCusto>();
		
		for (int i = 0; i < 10; i++) {
			centroCusto = new CentroCusto();
			centroCusto.setCentroCusto("Centro de Custo N°: "+i);
			centroCusto.setDescricao("Descrição N°: "+i);
			centroCusto.setTorreDeNegocio(1);
			centroCusto.setDiretoria(1);
			
			listaCentroCusto.add(centroCusto);
		}
		
	}

	
	
	
	
/**********************************************************
 ***				GETTERS AND SETTERS					***
 **********************************************************/
	
	public CentroCusto getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
	public List<CentroCusto> getListaCentroCusto() {
		return listaCentroCusto;
	}
	public void setListaCentroCusto(List<CentroCusto> listaCentroCusto) {
		this.listaCentroCusto = listaCentroCusto;
	}

	
	
}
