package com.hzr.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzr.cms.dao.FriendDAO;
import com.hzr.cms.domain.FriendShip;
import com.hzr.cms.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {
  @Resource
  private FriendDAO friendDAO;

  @Override
  public List friendList() {
    // TODO Auto-generated method stub
    return friendDAO.friendList();
  }

  @Override
  public int addFriend(FriendShip friend) {
    String url = friend.getUrl();
    //boolean httpUrl = StringUtil.isHttpUrl(url);
    //AssertUtil.isTrue(httpUrl, "添加路径格式不合法");
    return friendDAO.addFriend(friend);
  }

}
