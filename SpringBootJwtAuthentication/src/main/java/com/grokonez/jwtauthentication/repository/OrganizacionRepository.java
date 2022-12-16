package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.model.FechaActividad;
import com.grokonez.jwtauthentication.model.FechaActividadCompositeKey;
import com.grokonez.jwtauthentication.model.Organizacion;

public interface OrganizacionRepository extends JpaRepository<Organizacion, String>{

}
