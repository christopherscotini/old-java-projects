package br.com.contestacao.security.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

public class AutorizacaoPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -4993632155122251733L;

	private static final Map<String, String> mapViewIdTelasProtegidas = new HashMap<String, String>();

	static {
		mapViewIdTelasProtegidas.put("/cadastroCliente.xhtml", "Cadastro de Clientes");
		mapViewIdTelasProtegidas.put("/consultaListagemCliente.xhtml", "Cadastro de Clientes");
		mapViewIdTelasProtegidas.put("/cadastroPerfis.xhtml", "Cadastro de Perfis");
		mapViewIdTelasProtegidas.put("/cadastroListagemServico.xhtml", "Cadastro de Serviços");
		mapViewIdTelasProtegidas.put("/cadastroListagemSubServico.xhtml", "Cadastro de Sub-Serviços");
		mapViewIdTelasProtegidas.put("/cadastroListagemUsuario.xhtml", "Cadastro de Usuários");
		mapViewIdTelasProtegidas.put("/consultaTarifas.xhtml", "Exportar arquivos");
		mapViewIdTelasProtegidas.put("/exportarArquivos.xhtml", "Exportar arquivos");
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
				Set<String> telasAcessoPermitido = (Set<String>) Faces.getSession().getAttribute("telasPermissao");
				if (telasAcessoPermitido != null && telasAcessoPermitido.contains(tela)) {
					return;
				}

				Faces.getApplication().getNavigationHandler().handleNavigation(Faces.getContext(), null, "/acessoNegado.xhtml");
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
