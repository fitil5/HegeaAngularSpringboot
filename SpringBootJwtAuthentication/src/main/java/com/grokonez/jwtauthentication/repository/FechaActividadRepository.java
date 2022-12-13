package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grokonez.jwtauthentication.model.AltaActividadCompositeKey;
import com.grokonez.jwtauthentication.model.FechaActividad;
import com.grokonez.jwtauthentication.model.FechaActividadCompositeKey;

public interface FechaActividadRepository extends JpaRepository<FechaActividadCompositeKey, FechaActividad>{

		
		@Query("SELECT f FROM FechaActividadCompositeKey f  order by f.fecha")
			List<FechaActividadCompositeKey> findAllFechaActividadOrderByFecha();
		@Query("SELECT f FROM FechaActividadCompositeKey f WHERE f.fecha > current_date order by f.fecha")
			List<FechaActividadCompositeKey> findAllFechaActividadDesdeHoy();
		
	
}
