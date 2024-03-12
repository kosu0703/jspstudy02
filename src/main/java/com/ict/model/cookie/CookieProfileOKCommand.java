package com.ict.model.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.cookie.CookieDAO;
import com.ict.db.cookie.CookieVO;
import com.ict.model.basic.Command;

public class CookieProfileOKCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// 쿠키를 이용해서 id가 넘어온다.
		Cookie[] cookies = request.getCookies();
		String id = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("id")) {
					id = cookies[i].getValue();
					CookieVO cvo = CookieDAO.getDetail(id);
					request.setAttribute("cvo", cvo);	
					return "view/cookie/detail.jsp";
				}
			}
		}
		return null;
		
	}
}
