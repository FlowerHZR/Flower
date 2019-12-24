package com.hzr.cms.web.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzr.cms.domain.ComMessage;
import com.hzr.cms.domain.User;
import com.hzr.cms.service.ComMessageService;
import com.hzr.cms.web.Constant;

/**
 * 投诉控制器
 * @author Administrator
 *
 */
@Controller
public class TouSuController {
  @Autowired
  public ComMessageService comMessageService;

  /**
   * 点击投诉链接进入投诉页面
   * @param aid
   * @param model
   * @param session
   * @return
   */
  @RequestMapping("/toTouSu")
  public String toTousu(HttpSession session, Integer aid, Model model) {
    ComMessage comMessage = new ComMessage();
    session.setAttribute("aid", aid);
    model.addAttribute("comMessage", comMessage);
    return "tousu";
  }

  /**
   * 添加投诉信息
   * @param message
   * @param model
   * @return
   */
  @RequestMapping("/addMessage")
  public String addMessage(@Valid @ModelAttribute(name = "comMessage") ComMessage comMessage,
    BindingResult br, HttpSession session, Model model) {
    Integer aid = (Integer) session.getAttribute("aid");
    User user = (User) session.getAttribute(Constant.LOGIN_USER);
    Integer uid = user.getId();
    comMessage.setUid(uid);
    comMessage.setAid(aid);
    System.out.println(br.hasErrors());
    if (br.hasErrors()) {
      model.addAttribute("comMessage", comMessage);
      return "tousu";
    }
    comMessageService.addComMessage(comMessage);
    return "redirect:home";
  }
}
