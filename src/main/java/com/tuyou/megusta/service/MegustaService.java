package com.tuyou.megusta.service;

import java.util.List;

import com.tuyou.publication.controller.PublicationDTO;

public interface MegustaService {
	
	List<PublicationDTO> likeIt(int idUsuario, int idPublicacion);

}
