package com.hzr.cms.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hzr.cms.core.CMSRuntimeException;
import com.hzr.cms.domain.User;
import com.hzr.cms.service.UserInfoService;
import com.hzr.cms.utils.CookieUtils;
import com.hzr.cms.web.Constant;
import com.hzr.cms.web.forms.UserForm;

@Controller
public class UserInfoController {
  @Resource
  private UserInfoService userInfoService;

  // restfull  可以通过不能的提交方式   来完成方法
  // 因为使用的是jsr 303 所以需要绑定对象  于是 userForm 需要放到model中
  // 方法说明： 跳转到注册页面
  @RequestMapping(value = "/reg", method = RequestMethod.GET)
  public String toReg(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "passport/reg";
  }

  // 当点击注册按钮时完成此功能
  // 方法说明：注册
  @RequestMapping(value = "/reg", method = RequestMethod.POST)
  public String reg(UserForm userForm, RedirectAttributes attr, Model model) {
    System.out.println(userForm);
    try {
      int i = userInfoService.reg(userForm);
      // 重定向传值
      attr.addFlashAttribute("message", "注册成功");
      return "redirect:reg";
    } catch (CMSRuntimeException e) {
      model.addAttribute("message", e.getMessage());
    }
    return "passport/reg";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String tologin(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "passport/login";
  }

  /**
   * 用户登录
   * @param model
   * @param userForm
   * @param request
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@Valid @ModelAttribute(name = "userForm") UserForm userForm, BindingResult br,
    Model model, HttpServletRequest request, HttpServletResponse response) {
    // model.addAttribute("userForm", new UserForm());
    // userForm 中由用户名及密码 但是    数据库中的密码是加密后的而前台接受的密码是未加密
    try {
      if (br.hasErrors()) {
        model.addAttribute("userForm", userForm);
        return "passport/login";
      }
      //调用业务层
      User user = userInfoService.login(userForm);
      // 如果登录成功需要将user对象放入到session中   
      Constant.setLoginUser(request, user);
      //获取是否记住我的标记
      if ("rememberMe".equalsIgnoreCase(userForm.getRemember())) {
        /**********存放cookie********/
        if (user != null) {
          //登录成功时把用户名和密码存入cookie
          CookieUtils.setCookie(request, response, "userName", userForm.getUsername(),
            1000 * 60 * 60 * 24 * 7);
          CookieUtils.setCookie(request, response, "userPassword", userForm.getPassword(),
            1000 * 60 * 60 * 24 * 7);
          System.out.println("*******save*******");
        }
      }
      return "redirect:/index";
    } catch (

    CMSRuntimeException e) {
      // TODO Auto-generated catch block
      model.addAttribute("message", e.getMessage());
    }
    return "passport/login";
  }

  @RequestMapping("/logout")
  public String logOut(HttpServletRequest request, HttpServletResponse response, Model model) {
    model.addAttribute("userForm", new UserForm());
    request.getSession().invalidate();
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
    return "passport/login";
  }
}
