package com.tuyou.persistence.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Megusta")
public class MeGusta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_megusta")
	private int idMeGusta;

	@Column(name = "id_publicacion")
	private int idPublicacion;

	@Column(name = "id_usuariom")
	private int idUsuario;

	@Column(name = "fecha_megusta")
	private Date fechaMeGusta;

	/**
	 * @return the idMeGusta
	 */
	public int getIdMeGusta() {
		return idMeGusta;
	}

	/**
	 * @param idMeGusta the idMeGusta to set
	 */
	public void setIdMeGusta(int idMeGusta) {
		this.idMeGusta = idMeGusta;
	}

	/**
	 * @return the idPublicacion
	 */
	public int getIdPublicacion() {
		return idPublicacion;
	}

	/**
	 * @param idPublicacion the idPublicacion to set
	 */
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
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
	 * @return the fechaMeGusta
	 */
	public Date getFechaMeGusta() {
		return fechaMeGusta;
	}

	/**
	 * @param fechaMeGusta the fechaMeGusta to set
	 */
	public void setFechaMeGusta(Date fechaMeGusta) {
		this.fechaMeGusta = fechaMeGusta;
	}

}
