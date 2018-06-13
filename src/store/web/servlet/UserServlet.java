package store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.service.UserService;
import store.domain.User;
import store.utils.BeanFactory;
import store.utils.MyBeanUtils;
import store.utils.UUIDUtils;
import store.web.base.BaseServlet;

public class UserServlet extends BaseServlet {
	UserService userService =(UserService)BeanFactory.createObject("UserService");

	// 显示注册页面
	public String registerUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	
	// 用户是否存在？
	public String exists(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		
		User user = null; // todo
		if (user != null) {
			response.getWriter().print("1"); // 已经存在此用户
		} else {
			response.getWriter().print("0");
		}
		return null;
	}

	// 注册
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		User newuser = MyBeanUtils.populate(User.class, request.getParameterMap());
		newuser.setUid(UUIDUtils.getId());
		newuser.setState(0);
		newuser.setCode(UUIDUtils.getId());
		System.out.println(newuser);
		userService.userRegist(newuser);
		request.setAttribute("msg", "注册成功， 请激活");
		return "/jsp/info.jsp";
	}
}
