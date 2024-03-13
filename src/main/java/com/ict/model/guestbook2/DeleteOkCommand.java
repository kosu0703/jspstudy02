package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;

public class DeleteOkCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		int res = Guest2DAO.getDelete(idx);
		
		return "Guest2?cmd=list";
	}

}
