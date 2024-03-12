package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.basic.BasicDAO;
import com.ict.db.basic.BasicVO;

public class ProfileOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		BasicVO bvo = BasicDAO.getDetail(id);
		request.setAttribute("bvo", bvo);
		return "view/basic/detail.jsp";
	}
}
