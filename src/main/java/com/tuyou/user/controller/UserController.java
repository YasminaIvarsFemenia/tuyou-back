package com.tuyou.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuyou.user.service.UserService;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/rest/user/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody final UserRequest usuario) {

		ResponseEntity<Object> response = null;
		
		if (usuario.getMail() != null && usuario.getPwd() != null) {
			UserDTO user = userService.addUser(usuario);
			if (user != null) {
				response = new ResponseEntity<Object>(user, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/rest/user", method = RequestMethod.POST)
	public ResponseEntity<Object> loginUser(@RequestBody final LoginRequest usuario) {

		ResponseEntity<Object> response = null;
		
		if (usuario.getMail() != null && usuario.getPwd() != null) {
			UserDTO user = userService.loginUser(usuario.getMail(), usuario.getPwd());
			
			if (user != null) {
				response = new ResponseEntity<Object>(user, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/rest/user/{idUser}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@PathVariable("idUser") final int idUser,
			@RequestBody final LoginRequest usuario) {

		ResponseEntity<Object> response = null;
		
		if (usuario.getMail() != null && usuario.getPwd() != null) {
			//userService.editUser(usuario.getMail(), usuario.getPwd());
			response = new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
}
