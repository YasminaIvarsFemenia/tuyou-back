package com.tuyou.megusta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuyou.megusta.service.MegustaService;
import com.tuyou.publication.controller.PublicationDTO;

@RestController
@CrossOrigin
public class MegustaController {

	@Autowired
	MegustaService megustaService;

	@RequestMapping(value = "/rest/user/{idUser}/publication/{idPublication}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAmigos(@PathVariable("idUser") final String idUser,
			@PathVariable("idPublication") final String idPublication) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		Integer idPublicationInt = Integer.valueOf(idPublication);
		
		if (idUsuario > 0 && idPublicationInt > 0) {
			List<PublicationDTO> publicaciones = megustaService.likeIt(idUsuario, idPublicationInt);
			response = new ResponseEntity<Object>(publicaciones, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
