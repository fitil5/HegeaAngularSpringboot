package com.hegea.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hegea.jwtauthentication.model.FechaActividad;
import com.hegea.jwtauthentication.model.FechaActividadCompositeKey;
import com.hegea.jwtauthentication.model.Organizacion;

public interface OrganizacionRepository extends JpaRepository<Organizacion, String>{

}
