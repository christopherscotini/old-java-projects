package br.com.contestacao.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import br.com.contestacao.model.SimNaoEnum;
import br.com.contestacao.model.Usuario;
import br.com.contestacao.service.TelaService;
import br.com.contestacao.service.UsuarioService;

@SessionScoped
@Named
public class SessaoBean implements Serializable {

	private static final long serialVersionUID = -7731575437479043617L;

	@Inject
	private UsuarioService usuarioService = null;

	@Inject
	private TelaService telaService = null;

	private Boolean admin = null;

	private Set<String> telasAcessoPermitido = null;

	private String data = null;

	public SessaoBean() {
		super();

		this.telasAcessoPermitido = new HashSet<String>();
	}

	@PostConstruct
	public void iniciar() {
		String login = Faces.getRemoteUser();

		Usuario usuario = usuarioService.buscarPorLogin(login);

		if (SimNaoEnum.S.equals(usuario.getAdmin())) {
			admin = Boolean.TRUE;
			Faces.getSession().setAttribute("admin", admin);
		} else {
			telasAcessoPermitido = telaService.buscarPorUsuarioLogin(login);
			Faces.getSession().setAttribute("telasPermissao", telasAcessoPermitido);
		}
	}

	public String logout() {
		Faces.invalidateSession();

		return "/index";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
