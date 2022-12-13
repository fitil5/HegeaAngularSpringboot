package com.grokonez.jwtauthentication.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.grokonez.jwtauthentication.model.AltaActividadCompositeKey;
import com.grokonez.jwtauthentication.model.AltaActividadDTO;
import com.grokonez.jwtauthentication.repository.AltaActividadRepository;


public interface IAltaActividad {
void deleteAll(List<AltaActividadCompositeKey> altaActividad);
List<AltaActividadCompositeKey> findAllByFechaActividad(Date Fecha,String Nombre_act);
List<AltaActividadDTO> findFechaActividadJoinAltaActividad(String usuario);
void save(AltaActividadCompositeKey altaActividad);
void  delete(AltaActividadCompositeKey altaActividad);
List<AltaActividadCompositeKey> findAllOrderByFecha();
@Service
	public class AltaActividadClass implements IAltaActividad{
@Autowired
AltaActividadRepository altaActividadRepository;
		@Override
		public void deleteAll(List<AltaActividadCompositeKey> altaActividad) {
			// TODO Auto-generated method stub
			altaActividadRepository.deleteAll(altaActividad);
		}
		@Override
		public List<AltaActividadCompositeKey> findAllByFechaActividad(Date fecha, String nombre_act) {
			// TODO Auto-generated method stub
			return altaActividadRepository.findAllByFechaActividad(fecha, nombre_act);
		}
		@Override
		public List<AltaActividadDTO> findFechaActividadJoinAltaActividad(String usuario) {
			// TODO Auto-generated method stub
			return altaActividadRepository.findFechaActividadJoinAltaActividad(usuario);
		}
		@Override
		public void save(AltaActividadCompositeKey altaActividad) {
			// TODO Auto-generated method stub
			altaActividadRepository.save(altaActividad);
		}
		@Override
		public void delete(AltaActividadCompositeKey altaActividad) {
			// TODO Auto-generated method stub
			altaActividadRepository.delete(altaActividad);
		}
		@Override
		public List<AltaActividadCompositeKey> findAllOrderByFecha() {
			// TODO Auto-generated method stub
			return altaActividadRepository.findAllOrderByFecha();
		}
		
	}
}
