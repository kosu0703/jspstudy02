package com.ict.model.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.cookie.CookieDAO;
import com.ict.db.cookie.CookieVO;
import com.ict.model.basic.Command;

public class CookieJoinOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입
		CookieVO cvo = new CookieVO();
		cvo.setId(request.getParameter("id"));
		cvo.setPwd(request.getParameter("pwd"));
		cvo.setName(request.getParameter("name"));
		cvo.setEmail(request.getParameter("email"));
		cvo.setAddr(request.getParameter("addr"));
		cvo.setPhone(request.getParameter("phone"));
				
		int result = CookieDAO.getJoin(cvo);
				
		if(result == 1 ) {
			return "view/cookie/loginForm.jsp";
		}else {
			return "view/cookie/joinForm.jsp";
		}
	}
}
