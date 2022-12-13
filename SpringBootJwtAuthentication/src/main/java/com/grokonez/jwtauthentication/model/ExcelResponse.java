package com.grokonez.jwtauthentication.model;

import java.util.List;

public class ExcelResponse {
 public ExcelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
public ExcelResponse(List<Usuario> usuarios, List<Usuario> errores) {
		super();
		this.usuarios = usuarios;
		this.errores = errores;
		
	}
public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Usuario> getErrores() {
		return errores;
	}
	public void setErrores(List<Usuario> errores) {
		this.errores = errores;
	}
	
	private List<Usuario> usuarios;
	private List<Usuario> errores;
	
}
