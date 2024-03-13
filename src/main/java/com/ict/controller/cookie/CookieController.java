package com.ict.controller.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;
import com.ict.model.cookie.AdClose7Command;
import com.ict.model.cookie.AdCloseCommand;
import com.ict.model.cookie.CookieJoinCommand;
import com.ict.model.cookie.CookieJoinOKCommand;
import com.ict.model.cookie.CookieLoginCommand;
import com.ict.model.cookie.CookieLoginOKCommand;
import com.ict.model.cookie.CookieLogoutCommand;
import com.ict.model.cookie.CookieProfileCommand;
import com.ict.model.cookie.CookieProfileOKCommand;

@WebServlet("/CookieController")
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		switch (cmd) {
			case "c_join" : comm = new CookieJoinCommand();  break;
			case "c_join_ok" : comm = new CookieJoinOKCommand(); break;
			case "c_login" : comm = new CookieLoginCommand(); break;
			case "c_login_ok" : comm = new CookieLoginOKCommand(); break;
			case "c_profile" : comm = new CookieProfileCommand(); break;
			case "c_profile_ok" : comm = new CookieProfileOKCommand(); break;
			case "c_logout" : comm = new CookieLogoutCommand(); break;
			case "ad_close" : comm = new AdCloseCommand(); break;
			case "ad_close7" : comm = new AdClose7Command(); break;
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
