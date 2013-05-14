package com.gestion.dto;

import java.io.Serializable;

public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6248412699744102266L;
	private int idVenta;
	private int idCliente;
	private int idUsuario;
	private String fecha;
	private String estado;
	private String fechaenvio;
	private String horaenvio;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(String fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getHoraenvio() {
		return horaenvio;
	}

	public void setHoraenvio(String horaenvio) {
		this.horaenvio = horaenvio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idVenta ^ (idVenta >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (idVenta != other.idVenta)
			return false;
		return true;
	}

}
