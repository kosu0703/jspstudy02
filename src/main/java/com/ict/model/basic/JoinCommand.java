package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("joinCommand");
		return "view/basic/joinForm.jsp";
	}
	
}
