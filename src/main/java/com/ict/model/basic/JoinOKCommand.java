package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.basic.BasicDAO;
import com.ict.db.basic.BasicVO;

public class JoinOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입
		BasicVO bvo = new BasicVO();
		bvo.setId(request.getParameter("id"));
		bvo.setPwd(request.getParameter("pwd"));
		bvo.setName(request.getParameter("name"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setAddr(request.getParameter("addr"));
		bvo.setPhone(request.getParameter("phone"));
		
		int result = BasicDAO.getJoin(bvo);
		
		if(result == 1 ) {
			return "view/basic/loginForm.jsp";
		}else {
			return "view/basic/joinForm.jsp";
		}
		
	}
}
