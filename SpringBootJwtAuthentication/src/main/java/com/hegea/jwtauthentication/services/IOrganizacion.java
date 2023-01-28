package com.hegea.jwtauthentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hegea.jwtauthentication.model.Organizacion;
import com.hegea.jwtauthentication.repository.OrganizacionRepository;

public interface IOrganizacion {
	List<Organizacion> getOrganizacion();
	Organizacion saveOrganizacion(Organizacion organizacion);
	public void deleteOrganizacionById(String id);
@Service
public class OrganizacionClass implements IOrganizacion{
@Autowired
OrganizacionRepository organizacionRepository;
	@Override
	public List<Organizacion> getOrganizacion() {
		// TODO Auto-generated method stub
		return organizacionRepository.findAll();
	}

	@Override
	public Organizacion saveOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		return organizacionRepository.save(organizacion);
	}

	@Override
	public void deleteOrganizacionById(String id) {
		// TODO Auto-generated method stub
		 organizacionRepository.deleteById(id);
	}
	}
}
