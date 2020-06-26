package com.tuyou.megusta.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyou.persistence.entity.MeGusta;
import com.tuyou.persistence.repository.MegustaRepository;
import com.tuyou.publication.controller.PublicationDTO;
import com.tuyou.publication.service.PublicationService;

@Service
public class MegustaServiceImpl implements MegustaService {

	@Autowired
	MegustaRepository megustaRepo;
	
	@Autowired
	PublicationService publiService;

	@Override
	public List<PublicationDTO> likeIt(int idUsuario, int idPublicacion) {

		MeGusta megusta = new MeGusta();
		
		megusta.setIdPublicacion(idPublicacion);
		megusta.setIdUsuario(idUsuario);
		megusta.setFechaMeGusta(new Date(Calendar.getInstance().getTime().getTime()));
		
		megustaRepo.save(megusta);
		
		return publiService.getPublications(idUsuario);
	}
	

}
