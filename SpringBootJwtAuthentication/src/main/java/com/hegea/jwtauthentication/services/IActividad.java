package com.hegea.jwtauthentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hegea.jwtauthentication.model.Actividad;
import com.hegea.jwtauthentication.repository.ActividadRepository;

public interface IActividad {
	List<Actividad> findAll();
	Actividad saveActividad(Actividad actividad);
	@Service
	public class ActividadClass implements IActividad{
		@Autowired
		ActividadRepository actividadRepository;
		@Override
		public List<Actividad> findAll() {
			// TODO Auto-generated method stub
			return actividadRepository.findAll();
		}
		@Override
		public Actividad saveActividad(Actividad actividad ) {
			// TODO Auto-generated method stub
			return actividadRepository.save(actividad);
		}
		
	}
}
