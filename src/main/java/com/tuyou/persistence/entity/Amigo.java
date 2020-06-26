package com.tuyou.persistence.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_amigo")
	private int idAmigo;

	@Column(name = "id_usuario1")
	private int usuario1;

	@Column(name = "id_usuario2")
	private int usuario2;

	private int estado;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	public int getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	public int getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(int usuario1) {
		this.usuario1 = usuario1;
	}

	public int getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(int usuario2) {
		this.usuario2 = usuario2;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
