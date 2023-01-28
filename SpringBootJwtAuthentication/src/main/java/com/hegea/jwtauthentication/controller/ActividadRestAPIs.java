package com.hegea.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hegea.jwtauthentication.model.Actividad;
import com.hegea.jwtauthentication.services.IActividad;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class ActividadRestAPIs {

	@Autowired
	IActividad actividadService;
	
	@GetMapping("/api/actividades")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Actividad> getActividades() {
		
		return actividadService.findAll();
	}
	@PostMapping("/api/addActividad")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	   public void addActividad(@RequestBody Actividad actividad) {
		actividadService.saveActividad(actividad);
	}
	
}
