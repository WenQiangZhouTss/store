package store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.service.UserService;
import store.domain.User;
import store.utils.BeanFactory;
import store.utils.CookUtils;
import store.utils.MyBeanUtils;
import store.utils.UUIDUtils;
import store.web.base.BaseServlet;

public class UserServlet extends BaseServlet {
    UserService userService = (UserService) BeanFactory.createObject("UserService");

    // 显示注册页面
    public String registerUI(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    // 用户是否存在？
    public String exists(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");

        User user = userService.findUserByUsreName(username); // todo
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
        newuser.setState(0); // 未激活
        newuser.setCode(UUIDUtils.getId()); //激活码
        userService.userRegist(newuser);
        // todo: 发邮件
        request.setAttribute("msg", "注册成功， 请激活");
        return "/jsp/info.jsp";
    }

    // 邮箱激活
    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // todo: 激活我!!!
        return "/jsp/login.jsp";
    }

    // 登录页面
    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/login.jsp";
    }

    // 登录
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User to = MyBeanUtils.populate(User.class, request.getParameterMap());
        User user = userService.userLogin(to);

        if (user != null) {
            // 登录成功
            request.getSession().setAttribute("user", user);
            String autoLogin = request.getParameter("autoLogin");
            if ("yes".equals(autoLogin)) { // 自动登录
                Cookie c = new Cookie("autoLogin", user.getUsername() + "#" + user.getPassword());
                c.setPath(request.getContextPath());
                c.setMaxAge(30 * 24 * 3600); // 一个月有效期
                response.addCookie(c);
            }
            String rememberMe = request.getParameter("remUser");
            if ("yes".equals(rememberMe)) { // 记住我
                Cookie c = new Cookie("remUser", user.getUsername());
                c.setPath(request.getContextPath());
                c.setMaxAge(30 * 24 * 3600);
                response.addCookie(c);
            }

            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return null;
        } else {
            request.setAttribute("msg", "用户名和密码不匹配");
            return "/jsp/login.jsp";
        }
    }

    // 退出
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        Cookie c = CookUtils.getCookieByName("autoLogin", request.getCookies());
        if (c != null) {
            c.setMaxAge(0);
            c.setPath(request.getContextPath());
            response.addCookie(c);
        }
        response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        return null;
    }

}
