package com.tuyou.user.service;

import com.tuyou.user.controller.UserDTO;
import com.tuyou.user.controller.UserRequest;

public interface UserService {

	UserDTO addUser(UserRequest user);

	UserDTO loginUser(String mail, String contrasena);

	void editUser(String mail, String contrasena, int idUser);
}
