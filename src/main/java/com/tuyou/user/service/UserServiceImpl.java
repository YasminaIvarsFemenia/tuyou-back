package com.tuyou.user.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyou.persistence.entity.Perfil;
import com.tuyou.persistence.entity.Usuario;
import com.tuyou.persistence.repository.AmigoRepository;
import com.tuyou.persistence.repository.PerfilRepository;
import com.tuyou.persistence.repository.PublicacionRepository;
import com.tuyou.persistence.repository.UsuarioRepository;
import com.tuyou.user.controller.UserDTO;
import com.tuyou.user.controller.UserRequest;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsuarioRepository userRepo;

	@Autowired
	PerfilRepository perfilRepo;

	@Autowired
	AmigoRepository amigoRepo;

	@Autowired
	PublicacionRepository publiRepo;

	@Override
	public UserDTO loginUser(String mail, String contrasena) {

		Usuario usuario = userRepo.findByEmailAndPassword(mail, contrasena);

		UserDTO user = null;
				
		if (usuario != null) {
			// Perfil perfil = perfilRepo.findByIdUsuario(usuario.getIdUsuario());
			// List<Amigo> amigoList = amigoRepo.findByidUsuario(usuario.getIdUsuario());
			// List<Publicacion> publicacionList = publiRepo.findByIdUsuario(usuario.getIdUsuario());

			user = new UserDTO(usuario.getIdUsuario(), usuario.getEmail(), usuario.getFechaRegistro());
		}
		
		return user;
	}

	@Override
	public UserDTO addUser(UserRequest user) {

		Usuario usuario = new Usuario();
		usuario.setEmail(user.getMail());
		usuario.setContrasena(user.getPwd());
		usuario.setFechaRegistro(new Date(Calendar.getInstance().getTime().getTime()));
		
		Usuario nuevoUsuario = userRepo.save(usuario);
		
		Perfil perfil = new Perfil();
		
		perfil.setNombre(user.getName());
		perfil.setApellidos(user.getSurname());
		perfil.setEstudios(user.getStudies());
		perfil.setFechaNacimiento(new Date(Calendar.getInstance().getTime().getTime()));
		perfil.setLugarNacimiento(user.getBirthplace());
		perfil.setIdUsuario(nuevoUsuario.getIdUsuario());
		
		perfilRepo.save(perfil);
		
		return new UserDTO(usuario.getIdUsuario(), usuario.getEmail(), usuario.getFechaRegistro());
		
	}

	@Override
	public void editUser(String mail, String contrasena, int idUser) {

		Optional<Usuario> usuarioOptional = userRepo.findById(idUser);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();

			if (mail != null && !mail.isEmpty()) {
				usuario.setEmail(mail);
			}

			if (contrasena != null && !contrasena.isEmpty()) {
				usuario.setContrasena(contrasena);
			}
			
			userRepo.save(usuario);
		}

	}
}
