package com.grokonez.jwtauthentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.model.Actividad;
import com.grokonez.jwtauthentication.repository.ActividadRepository;

public interface IActividad {
	List<Actividad> findAll();
	@Service
	public class ActividadClass implements IActividad{
		@Autowired
		ActividadRepository actividadRepository;
		@Override
		public List<Actividad> findAll() {
			// TODO Auto-generated method stub
			return actividadRepository.findAll();
		}
		
	}
}
