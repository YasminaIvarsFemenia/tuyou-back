package com.tuyou.publication.controller;

import java.sql.Date;
import java.util.List;

public class PublicationDTO {

	private int idPublicacion;

	private int idUsuario;

	private String nombre;

	private String apellidos;

	private String texto;

	private Date fecha;
	
	private List<MegustaDTO> megusta;

	/**
	 * @return the megustaList
	 */
	public List<MegustaDTO> getMegusta() {
		return megusta;
	}

	/**
	 * @param megustaList the megustaList to set
	 */
	public void setMegusta(List<MegustaDTO> megusta) {
		this.megusta = megusta;
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
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
