package com.tuyou.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuyou.persistence.entity.MeGusta;



public interface MegustaRepository extends JpaRepository< MeGusta, Integer> {

	@Query("SELECT m FROM Megusta m WHERE m.idPublicacion = :idPubli ")
	List<MeGusta> findByIdPublicacion(@Param("idPubli") int idPubli);

}
