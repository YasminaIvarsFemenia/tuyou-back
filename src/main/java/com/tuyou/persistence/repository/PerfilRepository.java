package com.tuyou.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuyou.persistence.entity.Perfil;

public interface PerfilRepository extends JpaRepository < Perfil, Integer> {
	/**
	 * Método para consultar el perfil a través de idUsuario
	 * @param idUsuario
	 * @return Perfil
	 */
	@Query("SELECT p FROM Perfil p WHERE p.idUsuario = :idUsuario ")
	Perfil findByIdUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT p FROM Perfil p WHERE lower(p.nombre) like lower(concat('%', :text,'%')) or lower(p.apellidos) like lower(concat('%', :text,'%'))")
	List<Perfil> findByText(@Param("text") String text);

}
