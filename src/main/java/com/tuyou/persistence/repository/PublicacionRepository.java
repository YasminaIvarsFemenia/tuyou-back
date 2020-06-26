package com.tuyou.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuyou.persistence.entity.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

	/**
	 * Método para consultar las publicaciones
	 * 
	 * @param idUsuario
	 * @return Publicacion
	 */
	@Query("SELECT p FROM Publicacion p WHERE p.idUsuario = :idUsuario")
	List<Publicacion> findByIdUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT p FROM Publicacion p WHERE p.idPublicacion = :idPublicacion")
	Publicacion findByIdPublicacion(@Param("idPublicacion") int idPublicacion);
	
}
