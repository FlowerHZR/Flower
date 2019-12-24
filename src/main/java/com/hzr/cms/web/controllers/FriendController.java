package com.hzr.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzr.cms.core.CMSRuntimeException;
import com.hzr.cms.domain.FriendShip;
import com.hzr.cms.service.FriendService;

// 友情链接的controller
@Controller
public class FriendController {
	@Resource
	private FriendService  friendService;
	
	@RequestMapping("friendList")//friendList
	@ResponseBody
	public Object friendList() {
		List  list=friendService.friendList();
		return list;
	}
	
	@RequestMapping("/toFriendAdd")
	public String toFriendAdd(Model model) {
		model.addAttribute("friend", new FriendShip());
		return "friendAdd";
	}
	@RequestMapping("/addFriend")
	public String addFriend(FriendShip friend,Model model) {
		model.addAttribute("friend", new FriendShip());
		try {
			int i=friendService.addFriend(friend);
			return "redirect:/home";
		} catch (CMSRuntimeException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", e.getMessage());
			return "friendAdd";
		}
			
	}
}
