package com.ict.model.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.cookie.CookieDAO;
import com.ict.db.cookie.CookieVO;
import com.ict.model.basic.Command;

public class CookieLoginOKCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 해당 사이트로 다시 요청할때는 쿠기도 함께 전송된다.
		// 요청에서 쿠키정보를 확인할 수 있다.
		// 쿠키 구성 요소
		// 이름 : 쿠키이름
		// 값 : 이름과 연결된값
		// 유효시작 : 초단위 시간 (일반적으로 세션유지시간 동안)
		// 도메인  : 쿠키를 생성한 사이트 
		
		// CookieLoginCommand에서 집어넣은 쿠키를 받아서 확인 해보자
		// Cookie[] cookies = request.getCookies();
		// String uname = null;
		// String upwd = null;
		// 쿠키가 존재할 때만 실행하자 
		// if(cookies != null && cookies.length >0) {
			// 쿠키가 가지고 있는 것 중 이름이 uname인 것 
			// for (int i = 0; i < cookies.length; i++) {
				// if(cookies[i].getName().equals("uname")) {
					// uname = cookies[i].getValue();
				// }
				// if(cookies[i].getName().equals("upwd")) {
				//	upwd = cookies[i].getValue();
				//}
			// }
		// }
		// System.out.println("uname : " + uname);
		// System.out.println("upwd : " + upwd);
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		CookieVO cvo = new CookieVO();
		cvo.setId(id);
		cvo.setPwd(pwd);
		
		CookieVO cvo2 = CookieDAO.getLogIn(cvo);
		
		if(cvo2 == null) {
			return "view/cookie/loginForm.jsp";
		}else {
			
			request.setAttribute("res", 1);
			request.setAttribute("cvo", cvo2);
			
			// 쿠키를 이용해서 id와 pwd를 저장
			Cookie c_id = new Cookie("id", cvo.getId());
			Cookie c_pwd = new Cookie("pwd", cvo.getPwd());
			
			response.addCookie(c_id);
			response.addCookie(c_pwd);
			
			return "view/cookie/index.jsp";
		}

	}

}
