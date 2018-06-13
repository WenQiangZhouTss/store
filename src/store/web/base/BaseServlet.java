package store.web.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：实现统一异常处理逻辑；根据请求参数分派到子类的不同方法
 */
public class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String methodName = req.getParameter("method");

			// 默认方法名
			if (methodName == null) {
				methodName = "execute";
			}

			// 当前运行的类， 需要调用的方法
			Method m = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

			// 执行方法
			String jspPath = (String) m.invoke(this, req, res);

			// 如果此方法有返回值，重定向到指定的jsp页面
			if (jspPath != null) {
				req.getRequestDispatcher(jspPath).forward(req, res);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 默认方法， 子类覆写
	 */
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// NOOP
		return null;
	}

}
