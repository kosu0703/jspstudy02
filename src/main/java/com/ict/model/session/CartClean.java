package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartClean {
public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	세션을 전체 초기화하자
		//request.getSession().invalidate();
		
		request.getSession().removeAttribute("list");
		
		return "view/session_cart/session_cart.jsp";
	}
}
