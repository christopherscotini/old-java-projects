package br.com.contestacao.security;

import java.security.acl.Group;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import br.com.contestacao.model.Usuario;
import br.com.contestacao.service.UsuarioService;
import br.com.contestacao.utils.HashUtils;

import com.google.common.base.Throwables;

public class AuthLoginModule extends UsernamePasswordLoginModule {

	@Override
	protected String getUsersPassword() throws LoginException {
		UsuarioService usuarioService = null;
		try {
			usuarioService = InitialContext.doLookup("UsuarioServiceImpl/local");
		} catch (NamingException e) {
			throw Throwables.propagate(e);
		}

		Usuario usuario = null;
		try {
			 usuario = usuarioService.buscarPorLogin(getUsername());
		} catch (EJBException e) {
			throw new LoginException("Usuário não encontrado: " + getUsername());
		}

		if (usuario == null) {
			throw new LoginException("Usuário não encontrado: " + getUsername());
		}

		return usuario.getSenha();
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		SimpleGroup userRoles = new SimpleGroup("Roles");
	    userRoles.addMember(new SimplePrincipal("AUTENTICADO"));
	    return new Group[] {userRoles};
	}

	@Override
	protected boolean validatePassword(String inputPassword, String expectedPassword) {
		String password = HashUtils.md5(inputPassword);
		return super.validatePassword(password, expectedPassword);
	}
}
