package com.tuyou.friend.service;

import java.util.List;

import com.tuyou.friend.controller.FriendDTO;
import com.tuyou.friend.controller.FriendRequest;

public interface FriendService {

	List<FriendDTO> getFriends(int idUser);

	List<FriendDTO> requestFriends(int idRequester, FriendRequest fq);
	
	List<FriendDTO> responseFriends(int idResponser, FriendRequest fq);

}
