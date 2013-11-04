package br.com.chris.sccgo.view.controller;

import br.com.chris.sccgo.model.Usuario;



public class UsuarioBean {
	private final String START_PAGE = "index";
	private Usuario usuario = new Usuario();
	
	
	public String logar(){
		System.out.println("aquii");
		if(verificaUsuario())
			return START_PAGE;
		else
			return "";
	}
	public boolean verificaUsuario(){
//		try{
//			UsuarioDaoImpl dao = new UsuarioDaoImpl();
//		Usuario u = new Usuario();
//		u = dao.findByName(usuario);
////		if (getUsuario().getUsuario().equals("chris") && getUsuario().getSenha().equals(""))
//			return true;
//		}catch(Exception e){
//			return false;
//		}
		
			return true;
			
	}

	public String cadastrarUsuario(){
		usuario = new Usuario();
		return "/content/usuario/incAltUsuario";
	}
	
	public String salvarUsuario(){
//		UsuarioDaoImpl dao = new UsuarioDaoImpl();
//		dao.insert(usuario);
		return "/content/index";
	}
	
	
	/*************************************************************
	* 					 GETTERS AND SETTERS					 *
	*************************************************************/
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
