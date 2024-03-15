package com.ict.model.guestbook2;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;

public class ListCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	list.jsp 에서 보여줄 내용을 DB 에 갔다와야함
		//	guestbook 의 모든 정보 다 가져와야 한다.
		
		//	DB 처리는 MyBatis 이다.
		//	오라클라이브러리와 MyBatis 라이브러리를 WEB-INF 안 lib 에 넣자
		
		//	순차적으로 만들면서 넘어가자(이름을 생각하면서)
		//	DAO 로 가자
		
		//	전체목록 가져오기
		//	리스트
		List<Guest2VO> list = Guest2DAO.getList();
		
		//	request 에 가져온 리스트를 담자
		request.setAttribute("list", list);
		
		return "view/guestbook2/list.jsp";
	}

}
