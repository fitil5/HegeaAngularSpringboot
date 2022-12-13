package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.AltaActividadCompositeKey;
import com.grokonez.jwtauthentication.model.Usuario;
import com.grokonez.jwtauthentication.services.IAltaActividad;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class RegistadosRestAPIs {
	@Autowired
	IAltaActividad altaActividad;

	@GetMapping("/api/registrados")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<AltaActividadCompositeKey> getUsuarios() {
		return altaActividad.findAllOrderByFecha();
	}
}
