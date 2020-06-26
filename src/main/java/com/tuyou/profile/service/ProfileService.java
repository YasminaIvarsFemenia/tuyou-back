package com.tuyou.profile.service;

import java.util.List;

import com.tuyou.profile.controller.ProfileDTO;
import com.tuyou.profile.controller.ProfileEditRequest;
import com.tuyou.profile.controller.ProfileSearchDTO;

public interface ProfileService {

	ProfileDTO getProfile(int idUser);

	ProfileDTO editProfile(int idUser, ProfileEditRequest perfil);
	
	List<ProfileSearchDTO> serchProfile(int idUser, String query);
}
