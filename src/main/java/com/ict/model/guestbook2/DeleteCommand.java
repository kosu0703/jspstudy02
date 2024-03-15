package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		//	idx 와 pwd 를 받아서
		String idx = request.getParameter("idx");
		String pwd = request.getParameter("pwd");
		
		//	idx 와 pwd 를 같이 넘겨줘야함
		request.setAttribute("idx", idx);
		request.setAttribute("pwd", pwd);
		
		return "view/guestbook2/del.jsp";
	}

}
