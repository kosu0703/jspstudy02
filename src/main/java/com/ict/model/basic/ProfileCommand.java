package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		return "view/basic/profile.jsp";
	}
}
