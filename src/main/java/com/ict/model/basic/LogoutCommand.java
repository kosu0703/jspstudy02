package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
	
		return "view/basic/index.jsp";
	}
}
