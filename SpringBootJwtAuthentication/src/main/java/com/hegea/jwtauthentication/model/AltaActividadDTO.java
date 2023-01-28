package com.hegea.jwtauthentication.model;

import java.util.Date;

public class AltaActividadDTO {
private Date fecha;
private String nombre_act;
private String usuario;
private Boolean alta;
public AltaActividadDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getNombre_act() {
	return nombre_act;
}
public void setNombre_act(String nombre_act) {
	this.nombre_act = nombre_act;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public Boolean getAlta() {
	return alta;
}

public void setAlta(Boolean alta) {
	this.alta = alta;
}

public AltaActividadDTO(Date fecha, String nombre_act, String usuario, Boolean alta) {
	super();
	this.fecha = fecha;
	this.nombre_act = nombre_act;
	this.usuario = usuario;
	this.alta = alta;
}
}
