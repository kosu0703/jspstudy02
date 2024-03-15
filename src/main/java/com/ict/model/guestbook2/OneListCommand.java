package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;

public class OneListCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	방명록 전체목록 list 에서 제목을 클릭하면 
		//	idx 를 가지고 오므로 받아주자
		String idx = request.getParameter("idx");
		
		//	idx 로 DB 갔다가 오면 VO 를 가지고 온다
		Guest2VO gvo = Guest2DAO.getOneList(idx);
		
		if (gvo != null) {
			request.setAttribute("gvo", gvo);
			return "view/guestbook2/onelist.jsp";
		}else {
			return "view/guestbook2/error.jsp";
		}
		
	}

}
