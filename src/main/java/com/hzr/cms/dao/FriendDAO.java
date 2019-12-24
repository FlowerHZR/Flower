package com.hzr.cms.dao;

import java.util.List;

import com.hzr.cms.domain.FriendShip;
 /**
  * 友情链接dao层接口
  * @author Administrator
  *
  */
public interface FriendDAO {

	List friendList();

	int addFriend(FriendShip friend);


}
