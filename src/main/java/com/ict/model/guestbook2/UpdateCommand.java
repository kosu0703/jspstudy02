package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;

public class UpdateCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		//	받은 idx 로 DB 가서 정보를 가져오자
		Guest2VO gvo = Guest2DAO.getOneList(idx);
		request.setAttribute("gvo", gvo);
		
		return "view/guestbook2/update.jsp";
	}

}
