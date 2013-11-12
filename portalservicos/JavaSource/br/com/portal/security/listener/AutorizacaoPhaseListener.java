package br.com.portal.security.listener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.portal.security.constants.SessionContants;

/**
 * * Respons�vel por manipular requisi��es de usu�rio, permitindo acesso ao *
 * conte�do da aplica��o somente no caso do usu�rio j� ter se autenticado.
 */
public class AutorizacaoPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -8137966371401373854L;
	
	private static final Map<String, String> mapViewIdTelasProtegidas = new HashMap<String, String>();
	private static final Set<String> listaIdTelasPermitidas = new HashSet<String>();
	
	static {
		mapViewIdTelasProtegidas.put("/index.xhtml", "/index.xhtml");
		
		
		listaIdTelasPermitidas.add("/formularioCadastro.xhtml");
	}
	
	@Override
	public void afterPhase(PhaseEvent event) {
	}
	
	@Override
	public void beforePhase(PhaseEvent event) {
		
		String nomeView = getNomeView(event.getFacesContext().getViewRoot().getViewId());

		String tela = mapViewIdTelasProtegidas.get(nomeView);
		
		if (tela != null) {
			Boolean admin = (Boolean) Faces.getSession().getAttribute("admin");
			
			if (admin == null) {
				Set<String> telasAcessoPermitido = listaIdTelasPermitidas;
				
				if (telasAcessoPermitido != null && telasAcessoPermitido.contains(tela) || Faces.getSession().getAttribute(SessionContants.SESSION_USER) != null) {
					return;
				}
				
				Faces.getApplication().getNavigationHandler().handleNavigation(Faces.getContext(), null, "/login.xhtml");
			}
		}
	
	}

	private String getNomeView(String viewId) {
		String nomeView = "";
		if (viewId != null) {
			int index = viewId.lastIndexOf("/");
			if (index >= 0) {
				nomeView = viewId.substring(index);
			}
		}
		return nomeView;
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
