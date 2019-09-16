package br.ufrn.imd.material.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.material.dominio.Usuario;

public class UsuarioRepositorio {

	public static List<Usuario> usuarios;
	
	public static Usuario getUsuario(String login, String senha) {
		if(usuarios == null) {
			usuarios = new ArrayList<Usuario>();
			Usuario usr = new Usuario("itamir", "itamir");
			usr.setNome("Itamir");
			usuarios.add(usr);
		}
		for(Usuario u : usuarios) {
			if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
				return u;
			}
		}
		return null;
	}
}
