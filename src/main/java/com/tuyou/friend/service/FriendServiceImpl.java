package com.tuyou.friend.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyou.friend.controller.FriendDTO;
import com.tuyou.friend.controller.FriendRequest;
import com.tuyou.persistence.entity.Amigo;
import com.tuyou.persistence.entity.Perfil;
import com.tuyou.persistence.repository.AmigoRepository;
import com.tuyou.persistence.repository.PerfilRepository;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	AmigoRepository amigoRepo;

	@Autowired
	PerfilRepository perfilRepo;
	
	@Override
	public List<FriendDTO> getFriends(int idUser) {
		List<Amigo> amigoList = amigoRepo.findByidUsuario(idUser);
		List<FriendDTO> amigoDTOList = new ArrayList<>();
		
		for (Amigo amigo : amigoList) {
			int idToSearch;
			int estado;
			if (amigo.getUsuario1() == idUser) {
				idToSearch = amigo.getUsuario2();
			} else {
				idToSearch = amigo.getUsuario1();	
			}
			
			Perfil perfil = perfilRepo.findByIdUsuario(idToSearch);
			
			FriendDTO amigoDTO = new FriendDTO();
			amigoDTO.setIdUsuario(idToSearch);
			amigoDTO.setNombre(perfil.getNombre());
			amigoDTO.setApellidos(perfil.getApellidos());
			amigoDTO.setEstudios(perfil.getEstudios());
			amigoDTO.setFechaNacimiento(perfil.getFechaNacimiento());
			amigoDTO.setLugarNacimiento(perfil.getLugarNacimiento());
			
			if (amigo.getUsuario2() == idUser && amigo.getEstado() == 1) {
				// si el usuario que lanza la petición es el usuario 1 -> es el que lanzó la petición
				amigoDTO.setEstado(4);
			} else {
				amigoDTO.setEstado(amigo.getEstado());
			}
			
			
			amigoDTOList.add(amigoDTO);
		}
		
		return amigoDTOList;
	}

	@Override
	public List<FriendDTO> requestFriends(int idRequester, FriendRequest friend) {
		
		Amigo amigo = new Amigo();
		amigo.setEstado(friend.getEstado());
		amigo.setUsuario1(idRequester);
		amigo.setUsuario2(friend.getIdUserTo());
		
		amigoRepo.save(amigo);
				
		return getFriends(idRequester);
	}

	@Override
	public List<FriendDTO> responseFriends(int idResponser, FriendRequest friend) {
		
		Amigo amigo = amigoRepo.findByRequestAndReponseUsers(friend.getIdUserTo(), idResponser);
		amigo.setEstado(friend.getEstado());
		amigo.setFechaCreacion(new Date(Calendar.getInstance().getTime().getTime()));
		
		amigoRepo.save(amigo);
				
		return getFriends(idResponser);
	}


}
