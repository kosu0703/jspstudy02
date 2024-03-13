package com.ict.model.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class AdClose7Command implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie1 = new Cookie("ad_close7", "7");
		cookie1.setMaxAge(60*60*24*7);
		response.addCookie(cookie1);
		request.setAttribute("res2", 1);
		
		return "view/cookie/index.jsp";
	}

}
