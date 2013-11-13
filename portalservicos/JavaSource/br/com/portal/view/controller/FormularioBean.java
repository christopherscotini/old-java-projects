package br.com.portal.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.portal.exceptions.BusinessException;
import br.com.portal.model.ClienteEntity;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.PerfilEntity;
import br.com.portal.model.UserEntity;
import br.com.portal.model.embeddable.Endereco;


@ManagedBean
@SessionScoped
public class FormularioBean extends AbstractModelBean {

	private final String TELA_FORMULARIO_CADASTRO = "/formularioCadastroInicial.xhtml";
	private final String TELA_LOGIN = "/login.xhtml";
	
	private Integer tipoFormulario;
	
	private List<PerfilEntity>comboPerfilUsuario;
	private UserEntity usuarioCadastro = null;
	private ClienteEntity clienteCadastro = null;
	private EmpresaEntity empresaCadastro = null;
	private Endereco enderecoCadastro = null;
	
	
	@Override
	public String iniciarTela() {return null;}

	@Override
	public void limparCamposFiltro() {}

	@Override
	public String pesquisarFiltro() {return null;}
	
	
	public String navegarIncluir(){
		resetarFormulario();
		
		return TELA_FORMULARIO_CADASTRO;
	}
	
	public String executeSave(){
		comboPerfilUsuario = getPerfilBO().listarTodosExcetoAdmin();
		try{
			if(tipoFormulario == 1){
				for (int i = 0; i < comboPerfilUsuario.size(); i++) {
					if (comboPerfilUsuario.get(i).getDescPerfil().equals("EMPRESA")) {
						usuarioCadastro.setPerfil(comboPerfilUsuario.get(i));
						break;
					}
				}
				empresaCadastro.setEndereco(enderecoCadastro);
				empresaCadastro.setUsuario(usuarioCadastro);
				getEmpresaBO().adicionarEntidade(empresaCadastro);
			}else{
				if(tipoFormulario == 2){
					for (int i = 0; i < comboPerfilUsuario.size(); i++) {
						if (comboPerfilUsuario.get(i).getDescPerfil().equals("CLIENTE")) {
							usuarioCadastro.setPerfil(comboPerfilUsuario.get(i));
							break;
						}
					}
					
					clienteCadastro.setEndereco(enderecoCadastro);
					clienteCadastro.setUsuario(usuarioCadastro);
					getClienteBO().adicionarEntidade(clienteCadastro);
				}
			}
		}catch(BusinessException b){
			Messages.addError(null, b.getMessage());
		}
		
		
		return TELA_LOGIN;
	}
	
	public void resetarFormulario(){
		tipoFormulario = 0;
		usuarioCadastro = new UserEntity();
		clienteCadastro = new ClienteEntity();
		empresaCadastro = new EmpresaEntity();
		enderecoCadastro = new Endereco();
	}
	
	public void limparFormulario(){
		clienteCadastro = new ClienteEntity();
		clienteCadastro.setEndereco(new Endereco());
		usuarioCadastro = new UserEntity();
		empresaCadastro = new EmpresaEntity();
		empresaCadastro.setEndereco(new Endereco());
	}

	public boolean isPainelEmpresa(){
		return tipoFormulario != null && tipoFormulario == 1;
	}

	public boolean isPainelCliente(){
		return tipoFormulario != null && tipoFormulario == 2;
	}
	
	public ClienteEntity getClienteCadastro() {
		return clienteCadastro;
	}

	public void setClienteCadastro(ClienteEntity clienteCadastro) {
		this.clienteCadastro = clienteCadastro;
	}

	public UserEntity getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(UserEntity usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public EmpresaEntity getEmpresaCadastro() {
		return empresaCadastro;
	}

	public void setEmpresaCadastro(EmpresaEntity empresaCadastro) {
		this.empresaCadastro = empresaCadastro;
	}

	public Integer getTipoFormulario() {
		return tipoFormulario;
	}

	public void setTipoFormulario(Integer tipoFormulario) {
		this.tipoFormulario = tipoFormulario;
	}

	public List<PerfilEntity> getComboPerfilUsuario() {
		return comboPerfilUsuario;
	}

	public void setComboPerfilUsuario(List<PerfilEntity> comboPerfilUsuario) {
		this.comboPerfilUsuario = comboPerfilUsuario;
	}

	public Endereco getEnderecoCadastro() {
		return enderecoCadastro;
	}

	public void setEnderecoCadastro(Endereco enderecoCadastro) {
		this.enderecoCadastro = enderecoCadastro;
	}

}
