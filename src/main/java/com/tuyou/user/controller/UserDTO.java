package com.tuyou.user.controller;

import java.sql.Date;

public class UserDTO {

	
	private int idUsuario;

	private String email;

	private Date fechaRegistro;

	
	/**
	 * @param idUsuario
	 * @param email
	 * @param fechaRegistro
	 */
	public UserDTO(int idUsuario, String email, Date fechaRegistro) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



}
