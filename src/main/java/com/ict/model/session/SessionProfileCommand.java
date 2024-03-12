package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.session.SessionVO;
import com.ict.model.basic.Command;

public class SessionProfileCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	세션을 이용해서 세션에 저장된 svo 를 꺼내온다.
		//HttpSession session = request.getSession();
		//	나올때 Object 로 나오기 때문에 형변환
		//SessionVO svo = (SessionVO) session.getAttribute("svo");
		//request.setAttribute("pwd", svo.getPwd());
		
		//	**세션을 안꺼내고 그냥 보내도 된다.
		//	세션에 저장된 정보는 EL 에서 바로 사용할 수 있기때문에
		//	굳이 자바에서 강제로 끄집어내서 저장할 필요가 없다.
		return "view/session/profile.jsp";
	}
	
}
