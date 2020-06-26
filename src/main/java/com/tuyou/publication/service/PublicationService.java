package com.tuyou.publication.service;

import java.util.List;

import com.tuyou.publication.controller.PublicationDTO;

public interface PublicationService {

	List<PublicationDTO> getPublications(int idUser);

	PublicationDTO createPublication(int idUser, String text);
	
	List<PublicationDTO> removePublications(int idUser, int idPublication);

}
