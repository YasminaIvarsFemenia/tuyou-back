package com.tuyou.publication.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyou.persistence.entity.Amigo;
import com.tuyou.persistence.entity.MeGusta;
import com.tuyou.persistence.entity.Perfil;
import com.tuyou.persistence.entity.Publicacion;
import com.tuyou.persistence.repository.AmigoRepository;
import com.tuyou.persistence.repository.MegustaRepository;
import com.tuyou.persistence.repository.PerfilRepository;
import com.tuyou.persistence.repository.PublicacionRepository;
import com.tuyou.publication.controller.MegustaDTO;
import com.tuyou.publication.controller.PublicationDTO;

@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	AmigoRepository amigoRepo;

	@Autowired
	PublicacionRepository publiRepo;

	@Autowired
	PerfilRepository perfilRepo;
	
	@Autowired
	MegustaRepository megustaRepo;

	@Override
	public List<PublicationDTO> getPublications(int idUser) {
		List<Amigo> amigoList = amigoRepo.findByidUsuario(idUser);
		List<PublicationDTO> publicationDTOList = new ArrayList<>();

		//publicaciones de amigos
		for (Amigo amigo : amigoList) {
			
			if (amigo.getEstado() != 2) {
				continue;
			}
			
			int idToSearch;
			if (amigo.getUsuario1() == idUser) {
				idToSearch = amigo.getUsuario2();
			} else {
				idToSearch = amigo.getUsuario1();
			}

			List<Publicacion> publicacionList = publiRepo.findByIdUsuario(idToSearch);
			Perfil perfil = perfilRepo.findByIdUsuario(idToSearch);

			for (Publicacion p : publicacionList) {
				
				PublicationDTO publicationDTO = new PublicationDTO();
				publicationDTO.setIdPublicacion(p.getIdPublicacion());
				publicationDTO.setIdUsuario(idToSearch);
				publicationDTO.setNombre(perfil.getNombre());
				publicationDTO.setApellidos(perfil.getApellidos());
				publicationDTO.setTexto(p.getTexto());
				publicationDTO.setFecha(p.getFechaPublicacion());

				publicationDTO.setMegusta(obtenerMegusta(p.getIdPublicacion()));
				
				publicationDTOList.add(publicationDTO);
			}

		}

		// publicaciones propias
		List<Publicacion> publicacionList = publiRepo.findByIdUsuario(idUser);
		Perfil perfil = perfilRepo.findByIdUsuario(idUser);

		for (Publicacion p : publicacionList) {
			PublicationDTO publicationDTO = new PublicationDTO();
			publicationDTO.setIdPublicacion(p.getIdPublicacion());
			publicationDTO.setIdUsuario(idUser);
			publicationDTO.setNombre(perfil.getNombre());
			publicationDTO.setApellidos(perfil.getApellidos());
			publicationDTO.setTexto(p.getTexto());
			publicationDTO.setFecha(p.getFechaPublicacion());

			publicationDTO.setMegusta(obtenerMegusta(p.getIdPublicacion()));
			
			publicationDTOList.add(publicationDTO);
		}

		return publicationDTOList;
	}

	private List<MegustaDTO> obtenerMegusta(int idPublicacion) {
		List<MegustaDTO> megustaDTOList = new ArrayList<>();
		List<MeGusta> megustaList = megustaRepo.findByIdPublicacion(idPublicacion);
		
		for (MeGusta m : megustaList) {
			Perfil perfil = perfilRepo.findByIdUsuario(m.getIdUsuario());
			
			MegustaDTO megustaDTO = new MegustaDTO();
			megustaDTO.setIdMegusta(m.getIdMeGusta());
			megustaDTO.setIdUsuario(m.getIdUsuario());
			megustaDTO.setNombre(perfil.getNombre());
			megustaDTO.setApellidos(perfil.getApellidos());
			megustaDTO.setFecha(m.getFechaMeGusta());
			
			megustaDTOList.add(megustaDTO);
		}
		
		return megustaDTOList;
	}

	@Override
	public PublicationDTO createPublication(int idUser, String text) {

		Publicacion publicacion = new Publicacion();
		publicacion.setFechaPublicacion(new Date(Calendar.getInstance().getTime().getTime()));
		publicacion.setIdUsuario(idUser);
		publicacion.setTexto(text);
		
		Publicacion publicacionNueva = publiRepo.save(publicacion);
		
		Perfil perfil = perfilRepo.findByIdUsuario(idUser);
		
		PublicationDTO publicacionDTO = new PublicationDTO();
		publicacionDTO.setNombre(perfil.getNombre());
		publicacionDTO.setApellidos(perfil.getApellidos());
		publicacionDTO.setFecha(publicacionNueva.getFechaPublicacion());
		publicacionDTO.setTexto(publicacionNueva.getTexto());
		publicacionDTO.setIdPublicacion(publicacionNueva.getIdPublicacion());
		publicacionDTO.setIdUsuario(publicacionNueva.getIdUsuario());
		publicacionDTO.setMegusta(new ArrayList<>());
		
		return publicacionDTO;
	}

	@Override
	public List<PublicationDTO> removePublications(int idUser, int idPublication) {
		
		Publicacion publicacion = publiRepo.findByIdPublicacion(idPublication);
		
		List<MeGusta> megustaList = megustaRepo.findByIdPublicacion(idPublication);
		
		for (MeGusta m : megustaList) {
			megustaRepo.delete(m);
		}
		
		publiRepo.delete(publicacion);
		
		return getPublications(idUser);
	}

}
