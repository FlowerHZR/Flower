package com.hzr.cms.web.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hzr.cms.domain.User;
import com.hzr.cms.service.UserInfoService;
import com.hzr.cms.utils.CookieUtils;
import com.hzr.cms.web.Constant;
import com.hzr.cms.web.forms.UserForm;

/**
 * @用户登录拦截器
 * */
public class LoginInterceptor implements HandlerInterceptor {
  @Resource
  private UserInfoService userInfoService;

  /**
   * 通过预处理方法拦截用户请求，并且读取cookie中的用户名和密码
   * */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {
    //获取cookie
    String userName = CookieUtils.getCookieValue(request, "userName");
    String userPassword = CookieUtils.getCookieValue(request, "userPassword");
    //判断是否从cookie中取出值
    if (userName != null && userPassword != null) {
      //把cookie中获取的用户名和密码封装到对象中
      UserForm userForm = new UserForm();
      userForm.setUsername(userName);
      userForm.setPassword(userPassword);
      //调用业务层
      System.out.println("拦截器：" + userName + userPassword);
      User login = userInfoService.login(userForm);
      if (login != null) {
        // request.getSession().setAttribute("_LOGIN_ADMIN_", login);
        Constant.setLoginUser(request, login);
      }
    }
    return true;

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
    Exception ex) throws Exception {
    // TODO Auto-generated method stub

  }

}
