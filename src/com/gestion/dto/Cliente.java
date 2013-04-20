package com.gestion.dto;

public class Cliente {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String ciut;
	private String domicilio;
	private String domicilioValue;
	private boolean estado;
	private CondicionIva condicionIva;
    private Localidad localidad;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiut() {
		return ciut;
	}

	public void setCiut(String ciut) {
		this.ciut = ciut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString(){
		return nombre.concat(",").concat(apellido);
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDomicilioValue() {
		return domicilioValue;
	}

	public void setDomicilioValue(String domicilioValue) {
		this.domicilioValue = domicilioValue;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


}
