package com.tuyou.publication.controller;

import java.sql.Date;

public class MegustaDTO {

	private int idMegusta;

	private int idUsuario;

	private String nombre;

	private String apellidos;

	private Date fecha;

	/**
	 * @return the idMegusta
	 */
	public int getIdMegusta() {
		return idMegusta;
	}

	/**
	 * @param idMegusta the idMegusta to set
	 */
	public void setIdMegusta(int idMegusta) {
		this.idMegusta = idMegusta;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
