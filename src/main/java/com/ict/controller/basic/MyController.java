package com.ict.controller.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;
import com.ict.model.basic.JoinCommand;
import com.ict.model.basic.JoinOKCommand;
import com.ict.model.basic.LoginCommand;
import com.ict.model.basic.LoginOKCommand;
import com.ict.model.basic.LogoutCommand;
import com.ict.model.basic.ProfileCommand;
import com.ict.model.basic.ProfileOKCommand;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
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
			case "join" : comm = new JoinCommand();  break;
			case "join_ok" : comm = new JoinOKCommand(); break;
			case "login_ok" : comm = new LoginOKCommand(); break;
			case "login" : comm = new LoginCommand(); break;
			case "profile" : comm = new ProfileCommand(); break;
			case "profile_ok" : comm = new ProfileOKCommand(); break;
			case "logout" : comm = new LogoutCommand(); break;
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
}





