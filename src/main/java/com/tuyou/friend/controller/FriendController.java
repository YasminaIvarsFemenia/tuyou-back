package com.tuyou.friend.controller;

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

import com.tuyou.friend.service.FriendService;

@RestController
@CrossOrigin
public class FriendController {

	@Autowired
	FriendService friendService;

	@RequestMapping(value = "/rest/user/friends/{idUser}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAmigos(@PathVariable("idUser") final String idUser) {

		ResponseEntity<Object> response = null;
		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario != 0) {
			List<FriendDTO> friendsList = friendService.getFriends(idUsuario);
			response = new ResponseEntity<Object>(friendsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/rest/user/friends/{idUser}/request", method = RequestMethod.POST)
	public ResponseEntity<Object> sendFriendshipRequest(@PathVariable("idUser") final int idUser,
			@RequestBody final FriendRequest friend) {

		ResponseEntity<Object> response = null;

		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario > 0) {
			List<FriendDTO> friendsList = friendService.requestFriends(idUsuario, friend);
			response = new ResponseEntity<Object>(friendsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	@RequestMapping(value = "/rest/user/friends/{idUser}/response", method = RequestMethod.POST)
	public ResponseEntity<Object> sendFriendshipResponse(@PathVariable("idUser") final int idUser,
			@RequestBody final FriendRequest friend) {

		ResponseEntity<Object> response = null;

		Integer idUsuario = Integer.valueOf(idUser);
		if (idUsuario > 0) {
			List<FriendDTO> friendsList = friendService.responseFriends(idUsuario, friend);
			response = new ResponseEntity<Object>(friendsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
}
