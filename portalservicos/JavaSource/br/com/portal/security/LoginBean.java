package br.com.portal.security;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;

import br.com.portal.business.UserBO;
import br.com.portal.model.UserEntity;
import br.com.portal.security.constants.SessionContants;
import br.com.portal.utils.constants.PagesContants;

/**
 * * Bean respons�vel por controlar opera��es de login, logout e controle de *
 * sess�es de usu�rios.
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -8081378309027791765L;

	@ManagedProperty(value = "#{userBOImpl}")
	private UserBO userBO = null;
	
	public static final String LOGIN_FALHA = "login_falha";
	public static final String SESSAO_INEXISTENTE = "sessao_invalida";
	public static final String USUARIO_SESSAO = "usuario";
	private boolean erro;

	private UserEntity usuario;
	private ControladorAcesso controladorAcesso;

	public LoginBean() {
	}

	@PostConstruct
	public void inicializar() {
		usuario = new UserEntity();
		controladorAcesso = new ControladorAcesso();
	}
	
	@PreDestroy
	public void destruirSessao(){

		Faces.invalidateSession();
	}

	/**
	 * * Utilizado para tentativas de login no sistema, confrontando dados
	 * fornecidos * pelo usu�rio com registros de usu�rios cadastrados. * * @return
	 * Outcome associado a fracasso ou sucesso na tentativa de login.
	 */
	public String doLogin() {
		if (camposPreenchidos()){
				UserEntity userTentandoLogar = userBO.verificarLogin(usuario);
				if (userTentandoLogar != null) { 
					
					// Descobrindo o tipo de usu�rio que est� tentando acessar o sistema.
					UserEntity usuarioLogado = userTentandoLogar;
					
					if (usuarioLogado.getPerfil().getDescPerfil().equals("ADMINISTRADOR")) {
						Faces.getSession().setAttribute("admin", Boolean.TRUE);
					}
					
					Faces.getSession().setAttribute(SessionContants.SESSION_USER, usuarioLogado);
					controladorAcesso.configurarAcesso(); 
					setUsuario(usuarioLogado);
					erro = false;
					return PagesContants.PAGINA_INDEX;
				}
		}
		
		erro = true;
		return LOGIN_FALHA;
	}

	/**
	 * * Utilizado para finalizar uma sess�o de um usu�rio no sistema. * 
	 * * @return
	 * Outcome associado a fracasso ou sucesso na tentativa de logout.
	 */
	public String doLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		UserEntity usuarioSessao = (UserEntity) sessao.getAttribute(SessionContants.SESSION_USER);
		
		if (usuarioSessao != null) {
			sessao.setAttribute(SessionContants.SESSION_USER, null);
		}
		
		context.getExternalContext().invalidateSession();
		
		return PagesContants.PAGINA_LOGIN;
	}

	/**
	 * * Utilizado para verificar se as credenciais necess�rias para realiza��o
	 * do * login foram preenchidas. * * @return <code>true</code> em caso de
	 * dados preenchidos. * <code>false</code> caso contr�rio.
	 */
	private boolean camposPreenchidos() {
		return (usuario != null && usuario.getUsername() != null
				&& !"".equals(usuario.getUsername())
				&& usuario.getPassword() != null && !"".equals(usuario.getPassword()));
	}

	/**
	 * * M�todo utilizado para verificar se um usu�rio tentando logar na
	 * aplica��o * j� n�o possui alguma sess�o aberta em outro navegador ou
	 * outra aba. A * aplica��o est� barrando m�ltiplos acessos simult�neos de um
	 * usu�rio. * * @return <code>true</code> se j� existir uma sess�o ativa para
	 * o usu�rio. * <code>false</code> caso contr�rio.
	 */

	/** * Limpa todos os dados da tela de login. */
	public void limparTela() {
		this.usuario = new UserEntity();
	}

	public UserEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}

	public ControladorAcesso getControladorAcesso() {
		return controladorAcesso;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}
}
