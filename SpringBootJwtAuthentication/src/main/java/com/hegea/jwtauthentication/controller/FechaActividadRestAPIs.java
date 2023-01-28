package com.hegea.jwtauthentication.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hegea.jwtauthentication.Utilidades.Utilidades;
import com.hegea.jwtauthentication.model.AltaActividad;
import com.hegea.jwtauthentication.model.AltaActividadCompositeKey;
import com.hegea.jwtauthentication.model.AltaActividadDTO;
import com.hegea.jwtauthentication.model.DayMonthYearDTO;
import com.hegea.jwtauthentication.model.FechaActividad;
import com.hegea.jwtauthentication.model.FechaActividadCompositeKey;
import com.hegea.jwtauthentication.model.Usuario;
import com.hegea.jwtauthentication.model.prueba;
import com.hegea.jwtauthentication.repository.AltaActividadRepository;
import com.hegea.jwtauthentication.repository.FechaActividadRepository;
import com.hegea.jwtauthentication.services.IAltaActividad;
import com.hegea.jwtauthentication.services.IFechaActividad;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class FechaActividadRestAPIs {
	
	@Autowired
	IFechaActividad fechaActividadService;
	
	@Autowired
	IAltaActividad altaActividadService;
	@PostMapping("/api/diaactividad")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	 public List<FechaActividad> fechaActividad(@RequestBody DayMonthYearDTO dayMonthYearDTO ) {			
		return fechaActividadService.extraerSemanaMes(dayMonthYearDTO);

		
	}
	
	@PostMapping("/api/guardarFechaActividad")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	 public void saveFechaActividad(@RequestBody List <FechaActividadCompositeKey> fechaActividadList ) {			
		 
		fechaActividadService.saveAll(fechaActividadList);
		
	}
	@Autowired
	FechaActividadRepository fa;
	@Autowired
	AltaActividadRepository aa;
	@PostMapping("/api/deleteFechaActividad")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	 public void deleteFechaActividad(@RequestBody FechaActividadCompositeKey fechaActividad ) {			
		
		aa.deleteAll(fechaActividad.getAltaActividad());
		fa.delete(fechaActividad);
		//this.fechaActividad.deleteFechaActividad(fechaActividad);
		
		//altaActividadService.deleteAll(altaActividadService.findAllByFechaActividad(fechaActividad.getFecha(),fechaActividad.getNombre_act()));
	}
	

	
	
	@PostMapping("/api/altaActividad")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@ResponseStatus(HttpStatus.OK)
	 public List<AltaActividadDTO> getAltaActividad(@RequestBody String usuario ) {
		return altaActividadService.findFechaActividadJoinAltaActividad(usuario);
	}
	 @PostMapping("/api/deleteAltaActividad")
	public void  deleteAltaActividad(@RequestBody AltaActividadCompositeKey altaActividad) {
		
		 altaActividadService.delete( altaActividad);
	 }
		@PostMapping("/api/guardarAltaActividad")
		public void guardarALtaActividad(@RequestBody AltaActividadCompositeKey altaActividad) {
			altaActividadService.save(altaActividad);
		
	}
	@GetMapping("/api/getFechaActividad")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<FechaActividadCompositeKey> getAllFechaActividad() {
		
		
		return fechaActividadService.findAllFechaActividadOrdenada();
		//return this.fechaActividad.findAllFechaActividadDesdeHoy();
	}
	
	 }
