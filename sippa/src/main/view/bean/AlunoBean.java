package view.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import service.cadastro.aluno.AlunoService;
import view.utils.FacesUtils;


@ManagedBean(name="alunoBean")
public class AlunoBean {

	@ManagedProperty(value="#{alunoServiceImpl}")
	private AlunoService alunoService;
	
	public String salvarAluno(){
	
		alunoService.adicionaAluno(null);
		return null;
	}
	
}
