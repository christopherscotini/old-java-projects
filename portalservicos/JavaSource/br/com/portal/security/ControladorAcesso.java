package br.com.portal.security;

import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.portal.model.UserEntity;
import br.com.portal.security.constants.SessionContants;

/**
 * * Controlador utilizado especificamente para verifica��o de permiss�es de *
 * acesso a funcionalidades oferecidas pela aplica��o.
 */
public class ControladorAcesso {
	
	private boolean permissaoAdministrador;
	private boolean permissaoUsuarioCliente;
	private boolean permissaoUsuarioEmpresa;

	public boolean isPermissaoAdministrador() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		UserEntity usuarioSessao = (UserEntity) sessao
				.getAttribute(SessionContants.SESSION_USER);
		if (usuarioSessao != null) {
			permissaoAdministrador = (usuarioSessao.getPerfil().getDescPerfil().equals("ADMINISTRADOR"));
		} else {
			permissaoAdministrador = false;
		}
		return permissaoAdministrador;
	}

	public boolean isPermissaoUsuarioCliente() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		UserEntity usuarioSessao = (UserEntity) sessao.getAttribute(SessionContants.SESSION_USER);
		if (usuarioSessao != null) {
			permissaoAdministrador = (usuarioSessao.getPerfil().getDescPerfil().equals("ADMINISTRADOR"));
			if (permissaoAdministrador) {
				permissaoUsuarioCliente = true;
			} else {
				permissaoUsuarioCliente = (usuarioSessao.getPerfil().getDescPerfil().equals("CLIENTE"));
			}
		} else {
			permissaoUsuarioCliente = false;
		}
		return permissaoUsuarioCliente;
	}
	
	public boolean isPermissaoUsuarioEmpresa() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		UserEntity usuarioSessao = (UserEntity) sessao.getAttribute(SessionContants.SESSION_USER);
		
		if (usuarioSessao != null) {
			permissaoAdministrador = (usuarioSessao.getPerfil().getDescPerfil().equals("ADMINISTRADOR"));
			if (permissaoAdministrador) {
				permissaoUsuarioEmpresa = true;
			} else {
				permissaoUsuarioEmpresa = (usuarioSessao.getPerfil().getDescPerfil().equals("EMPRESA"));
			}
		} else {
			permissaoUsuarioEmpresa = false;
		}
		
		return permissaoUsuarioEmpresa;
	}

	/**
	 * * M�todo utilizado para configurar o perfil de acesso do usu�rio logado
	 * �s * funcionalidades da aplica��o.
	 */
	
	public void configurarAcesso() {
			if(isPermissaoAdministrador()){
				System.out.println(">>>  Usuário da sessão tem tipo: ADMINISTRADOR   <<<");
				permissaoUsuarioCliente = true;
				setPermissaoUsuarioEmpresa(true);
			}else{
				if (isPermissaoUsuarioCliente()) {
					System.out.println(">>>  Usuário da sessão tem tipo: CLIENTE   <<<");
				} else {
					if(isPermissaoUsuarioEmpresa()){
						System.out.println(">>>  Usuário da sessão tem tipo: EMPRESA   <<<");
					}
				}
			}
	}

	public void setPermissaoUsuarioEmpresa(boolean permissaoUsuarioEmpresa) {
		this.permissaoUsuarioEmpresa = permissaoUsuarioEmpresa;
	}
	
}
