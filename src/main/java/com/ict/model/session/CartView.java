package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartView {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "view/session_cart/session_cart_view.jsp";
	}
}
