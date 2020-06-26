package com.tuyou.publication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuyou.publication.service.PublicationService;


@RestController
@CrossOrigin
public class PublicationController {

	@Autowired
	PublicationService publiService;
	
	@RequestMapping(value = "/rest/user/publications/{idUser}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPublicaciones(@PathVariable("idUser") final String idUser) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0) {
			List<PublicationDTO> friendsList = publiService.getPublications(idUsuario);
			response = new ResponseEntity<Object>(friendsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/rest/user/publications/{idUser}/new", method = RequestMethod.POST)
	public ResponseEntity<Object> addPublication(@PathVariable("idUser") final int idUser, 
			@RequestBody final PublicationRequest publicacion) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0) {
			PublicationDTO publicationDTO = publiService.createPublication(idUsuario, publicacion.getText());
			response = new ResponseEntity<Object>(publicationDTO, HttpStatus.OK);
			
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}

	@RequestMapping(value = "/rest/user/{idUser}/publications/{idPublication}/delete", method = RequestMethod.GET)
	public ResponseEntity<Object> deletePublicaciones(@PathVariable("idUser") final String idUser,
			@PathVariable("idPublication") final String idPublication) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		Integer idPublicacion = Integer.valueOf(idPublication);
		if (idUsuario > 0 && idPublicacion > 0) {
			List<PublicationDTO> friendsList = publiService.removePublications(idUsuario, idPublicacion);
			response = new ResponseEntity<Object>(friendsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
}
