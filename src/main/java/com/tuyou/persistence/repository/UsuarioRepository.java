package com.tuyou.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuyou.persistence.entity.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	/**
	 * Método para consultar un usuario por email
	 * @param email
	 * @return Usuario
	 */
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Usuario findByEmail(@Param("email") String email);
	/**
	 * Método loguear un usuario por email y contraseña
	 * @param email
	 * @param contrasena
	 * @return Usuario
	 */
	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.contrasena= :contrasena")
	Usuario findByEmailAndPassword(@Param("email") String email, @Param("contrasena") String contrasena);

}
