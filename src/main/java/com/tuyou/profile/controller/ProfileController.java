package com.tuyou.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuyou.profile.service.ProfileService;

@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	ProfileService profileService;

	@RequestMapping(value = "/rest/user/profile/{idUser}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProfile(@PathVariable("idUser") final String idUser) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0) {
			ProfileDTO perfil = profileService.getProfile(idUsuario);
			if (perfil != null) {
				response = new ResponseEntity<Object>(perfil, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/rest/user/{idUser}/search", method = RequestMethod.GET)
	public ResponseEntity<Object> searchProfile(@PathVariable("idUser") final String idUser,
			@RequestParam("q") final String query) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0 && query != null && !query.equals("")) {
			List<ProfileSearchDTO> perfilLista = profileService.serchProfile(idUsuario, query);
			response = new ResponseEntity<Object>(perfilLista, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/rest/user/profile/{idUser}/edit", method = RequestMethod.POST)
	public ResponseEntity<Object> editProfile(@PathVariable("idUser") final int idUser, 
			@RequestBody final ProfileEditRequest perfil) {

		ResponseEntity<Object> response = null;
		
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0) {
			ProfileDTO perfilDTO = profileService.editProfile(idUsuario, perfil);
			response = new ResponseEntity<Object>(perfilDTO, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
}
