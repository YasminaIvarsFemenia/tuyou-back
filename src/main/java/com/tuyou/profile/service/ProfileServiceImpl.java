package com.tuyou.profile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyou.persistence.entity.Amigo;
import com.tuyou.persistence.entity.Perfil;
import com.tuyou.persistence.repository.AmigoRepository;
import com.tuyou.persistence.repository.PerfilRepository;
import com.tuyou.profile.controller.ProfileDTO;
import com.tuyou.profile.controller.ProfileEditRequest;
import com.tuyou.profile.controller.ProfileSearchDTO;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	PerfilRepository perfilRepo;
	
	@Autowired
	AmigoRepository amigoRepo;
	
	@Override
	public ProfileDTO getProfile(int idUser) {
		
		Perfil perfil = perfilRepo.findByIdUsuario(idUser);
		
		ProfileDTO perfilDTO = null;
		
		if (perfil != null) {
			perfilDTO = new ProfileDTO();
			perfilDTO.setIdPerfil(perfil.getIdPerfil());
			perfilDTO.setNombre(perfil.getNombre());
			perfilDTO.setApellidos(perfil.getApellidos());
			perfilDTO.setEstudios(perfil.getEstudios());
			perfilDTO.setLugarNacimiento(perfil.getLugarNacimiento());
			perfilDTO.setFechaNacimiento(perfil.getFechaNacimiento());
			perfilDTO.setIdUsuario(idUser);
		}
		
		return perfilDTO;
	}

	@Override
	public List<ProfileSearchDTO> serchProfile(int idUser, String query) {
		List<Perfil> perfilList = perfilRepo.findByText(query);
		List<Amigo> amigoList = amigoRepo.findByidUsuario(idUser);
		
		List<ProfileSearchDTO> busquedaList = new ArrayList<>();

		for (Perfil p : perfilList) {
			if (p.getIdUsuario() == idUser) {
				continue;
			}
			
			ProfileSearchDTO ps = new ProfileSearchDTO();
			ps.setIdPerfil(p.getIdPerfil());
			ps.setNombre(p.getNombre());
			ps.setApellidos(p.getApellidos());
			ps.setIdUsuario(p.getIdUsuario());
						
			for (Amigo a : amigoList) {
				if (a.getUsuario2() == p.getIdUsuario()) {
					ps.setEstado(a.getEstado());
				} else if (a.getUsuario1() == p.getIdUsuario() && a.getEstado() == 2) {
					ps.setEstado(a.getEstado());
				} else if (a.getUsuario1() == p.getIdUsuario() && a.getEstado() == 1) {
					ps.setEstado(4); // falta aceptar petición de amistad
				}
			}
			busquedaList.add(ps);
			
		}
		
		return busquedaList;
	}

	@Override
	public ProfileDTO editProfile(int idUser, ProfileEditRequest perfil) {

		Perfil perfilUser = perfilRepo.findByIdUsuario(idUser);
		
		perfilUser.setNombre(perfil.getName());
		perfilUser.setApellidos(perfil.getSurname());
		perfilUser.setEstudios(perfil.getStudies());
		perfilUser.setLugarNacimiento(perfil.getBirthplace());
		
		Perfil perfilNuevo = perfilRepo.save(perfilUser);
		
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setIdPerfil(perfilNuevo.getIdPerfil());
		profileDTO.setNombre(perfilNuevo.getNombre());
		profileDTO.setApellidos(perfilNuevo.getApellidos());
		profileDTO.setEstudios(perfilNuevo.getEstudios());
		profileDTO.setFechaNacimiento(perfilNuevo.getFechaNacimiento());
		profileDTO.setLugarNacimiento(perfilNuevo.getLugarNacimiento());
		profileDTO.setIdUsuario(perfilNuevo.getIdUsuario());
		
		
		return profileDTO;
	}
}
