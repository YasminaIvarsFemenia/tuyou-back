package com.tuyou.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuyou.persistence.entity.Amigo;

public interface AmigoRepository extends JpaRepository<Amigo, Integer> {

	/**
	 * Método para consultar todos los amigos
	 * 
	 * @param idUsuario
	 * @return lista de amigos anotacion para mi: aqui cmo parametro solo paso 1
	 *         idusuario
	 */
	@Query("SELECT a FROM Amigo a WHERE a.usuario1= :idUsuario or a.usuario2 =:idUsuario")
	List<Amigo> findByidUsuario(@Param("idUsuario") int idUsuario);

	@Query("SELECT a FROM Amigo a WHERE a.usuario1= :idUsuarioReq and a.usuario2 =:idUsuarioRes")
	Amigo findByRequestAndReponseUsers(@Param("idUsuarioReq") int idUsuario, @Param("idUsuarioRes") int idUsuario2);
	
}
