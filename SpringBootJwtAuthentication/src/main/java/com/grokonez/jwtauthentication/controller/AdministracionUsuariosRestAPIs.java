package com.grokonez.jwtauthentication.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.Utilidades.Utilidades;
import com.grokonez.jwtauthentication.model.DayMonthYearDTO;
import com.grokonez.jwtauthentication.model.FechaActividad;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Usuario;
import com.grokonez.jwtauthentication.services.IAdministracionUsuarios;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class AdministracionUsuariosRestAPIs {
	
	@Autowired
	IAdministracionUsuarios administracionUsuarios;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/api/usuarios")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Usuario> getUsuarios() {
	
		return Utilidades.userListToUsuarioList(administracionUsuarios.getUsuariosAll());
	}
	@PostMapping("/api/editusuario")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	 public Usuario update(@RequestBody Usuario usuario ) {

		if(usuario.getPassword().length()<17){
		usuario.setPassword(encoder.encode(usuario.getPassword()));
	}
		if(administracionUsuarios.existsByUsername(usuario .getUsername())) {
			administracionUsuarios.deleteById(usuario .getId());
			//administrcionUsuarios.deleteByUsername(usuario.getUsername());
			//User u = administrcionUsuarios.findByUsername2(usuario .getUsername());
			
			administracionUsuarios.createUsuario(Utilidades.usuarioToUser(usuario));		
	}
		
		return usuario;
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/api/deleteUsuario/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable long id) {
		administracionUsuarios.deleteById(id);
	}
	
	
	
	
	
}
