package com.ict.model.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class AdCloseCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	창을 닫기 위해 res2 저장
		request.setAttribute("res2", 1);
		
		return "view/cookie/index.jsp";
	}

}
