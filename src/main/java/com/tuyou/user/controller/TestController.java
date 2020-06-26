package com.tuyou.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String test() {
		return "pong";
	}

}
