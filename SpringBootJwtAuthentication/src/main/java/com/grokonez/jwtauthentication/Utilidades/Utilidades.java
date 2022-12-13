package com.grokonez.jwtauthentication.Utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Usuario;

public class Utilidades {

	public static Usuario userToUsuario(User user){
		Set<Role> roles = user.getRoles();
		String usuarioRole ="";
		for (Role role : roles) {			
			usuarioRole = role.getName().toString();
		}
		return new Usuario(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), usuarioRole,user.isEnabled());
	}
	public static List<Usuario> userListToUsuarioList(List<User> userList){
		List<Usuario> usuarioList = new ArrayList<>();
		for(User user : userList) {
			 usuarioList.add(userToUsuario(user));
		}
		return usuarioList;
	}
	

	public static User usuarioToUser(Usuario usuario){
		Set<Role> roles = new HashSet<>();
		if(usuario.getRole().equals("ROLE_ADMIN")) {
		roles.add(new Role((long)1,RoleName.ROLE_ADMIN));	
		}
		else if( usuario.getRole().equals("ROLE_USER")){
			roles.add(new Role((long)3,RoleName.ROLE_USER));
		}
		else {
			roles.add(new Role((long)2,RoleName.ROLE_PM));
		}
		//Set<Role> roles = new Role(new Long(1),usuario.getRole();
		String usuarioRole ="";
		for (Role role : roles) {			
			usuarioRole = role.getName().toString();
		}
		User u = new User(usuario.getName(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword(),usuario.isEnabled());
		u.setRoles(roles);
		return u;
	}
	public static List<User> usuarioListToUserList(List<Usuario> usuarioList){
		List<User> userList = new ArrayList<>();
		for(Usuario usuario : usuarioList) {
			userList.add(usuarioToUser(usuario));
		}
		return userList;
	}
		
	
}
