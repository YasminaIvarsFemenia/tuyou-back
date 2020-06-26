package com.tuyou;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tuyou.persistence.entity.Perfil;
import com.tuyou.persistence.entity.Usuario;
import com.tuyou.persistence.repository.PerfilRepository;
import com.tuyou.persistence.repository.UsuarioRepository;

@SpringBootTest
class TuyouApplicationTests {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Autowired
	PerfilRepository perfilRepo;
	
	@Test
	void contextLoads() {
		
		Optional<Usuario> user = usuarioRepo.findById(1);
		Usuario user2 = usuarioRepo.findByEmailAndPassword("yasminaivarsfemenia@hotmail.com", "lolo");
		
		Perfil perfil = perfilRepo.findByIdUsuario(1);
		
		System.out.println(user.toString());
		System.out.println(user2.toString());
		System.out.println(perfil.toString());
		assertEquals(true, true);
	}

}
