package com.example.dampouring.filter;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 管理员校验过滤器
 */
public class AdminFilter implements Filter {
	@Autowired
	UserService userService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();
		// 获取当前登陆用户
		UserTable currentUser = (UserTable)session.getAttribute(Constant.DAM_POUR_USer);
		if (currentUser == null) {
			PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
			out.write(ApiRestResponse.error(DampouringExceptionEnum.NOT_ADMIN).toStr());
			out.flush();
			out.close();
			return;
		}
		// 管理员校验借助了userService
		boolean adminRole = userService.checkAdminRole(currentUser);

		if (adminRole) {
			filterChain.doFilter(servletRequest, servletResponse);
		}else {
			PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
			out.write("{\n" +
					"    \"status\": 10009,\n" +
					"    \"msg\": \"NEED_ADMIN\",\n" +
					"    \"data\": null\n" +
					"}");
			out.flush();
			out.close();
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
