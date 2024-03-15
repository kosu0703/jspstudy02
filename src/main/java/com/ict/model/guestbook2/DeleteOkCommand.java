package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;

public class DeleteOkCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		int res = Guest2DAO.getDelete(idx);
		if (res > 0) {
			//	숙제
			//	DB 는 지웠지만 이미지는 지우지 않았다.
			//	파일클래스 이용해서 이미지 파일 삭제하기
			return "Guest2?cmd=list";
		}else {
			return "view/guestbook2/error.jsp";
		}
		
	}

}
