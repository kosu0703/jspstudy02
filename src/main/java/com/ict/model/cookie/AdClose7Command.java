package com.ict.model.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class AdClose7Command implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	쿠키 생성
		Cookie cookie = new Cookie("ad_close7", "7");
		//	쿠키 유효시간 조정
		cookie.setMaxAge(60*60*24*7);
		//	브라우저에 쿠키 저장
		response.addCookie(cookie);
		//	창을 닫기 위한 res2 값 저장
		request.setAttribute("res2", 1);
		
		return "view/cookie/index.jsp";
	}

}
