package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.Actividad;
import com.grokonez.jwtauthentication.model.Organizacion;
import com.grokonez.jwtauthentication.services.IOrganizacion;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class OrganizacionAPIs {

	@Autowired
IOrganizacion organizacionService;
	
	@GetMapping("/api/getOrganizacion")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Organizacion> getActividades() {
		
		return organizacionService.getOrganizacion();
	}
	@PostMapping("/api/addOrganizacion")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	   public Organizacion addOrganizacion(@RequestBody Organizacion organizacion) {
		return organizacionService.saveOrganizacion(organizacion);
	}
	@PostMapping("/api/deleteOrganizacion/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable String id) {
		organizacionService.deleteOrganizacionById(id);
	}
}
