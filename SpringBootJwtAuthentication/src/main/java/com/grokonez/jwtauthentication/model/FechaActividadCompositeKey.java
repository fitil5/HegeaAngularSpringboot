package com.grokonez.jwtauthentication.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name = "fecha_actividad")
@IdClass(FechaActividad.class)
public class FechaActividadCompositeKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	



	@Id
	@Column(name="fecha")
	private Date fecha;
	@Id
	@Column(name="nombre_act")
	private String nombre_act;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JoinColumns({
        @JoinColumn(name="fecha", referencedColumnName="fecha"),
        @JoinColumn(name="nombre_act", referencedColumnName="nombre_act")
    })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AltaActividadCompositeKey> altaActividad;
	
	
	public FechaActividadCompositeKey(List<AltaActividadCompositeKey> altaActividad) {
		super();
		this.altaActividad = altaActividad;
	}



	public FechaActividadCompositeKey(Date fecha, String nombre_act) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	public FechaActividadCompositeKey(Date fecha, String nombre_act, List<AltaActividadCompositeKey> altaActividad) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
		this.altaActividad = altaActividad;
	}



	public FechaActividadCompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNombre_act() {
		return nombre_act;
	}

	public void setNombre_act(String nombre_act) {
		this.nombre_act = nombre_act;
	}

	

	
	public List<AltaActividadCompositeKey> getAltaActividad() {
		return altaActividad;
	}



	public void setAltaActividad(List<AltaActividadCompositeKey> altaActividad) {
		this.altaActividad = altaActividad;
	}

}
