package com.hzr.cms.service;

import java.util.List;

import com.hzr.cms.domain.FriendShip;
/**
 * 友情链接
 * @author Administrator
 *
 */
public interface FriendService {

	List friendList();

	int addFriend(FriendShip friend);

}
