package com.ict.model.guestbook2;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOkCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	넘어오는게 멀티파트면 트라이캐치
		try {
			//	1. 항상 실제 위치 먼저
			String path = request.getServletContext().getRealPath("upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, 
							path,			//	3.
							100*1024*1024,	//	100MB , 업로드 용량 제한
							"utf-8",		//	한글처리
							//	업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
							new DefaultFileRenamePolicy()
							);
			
			Guest2VO gvo = new Guest2VO();
			gvo.setIdx(mr.getParameter("idx"));
			gvo.setName(mr.getParameter("name"));
			gvo.setSubject(mr.getParameter("subject"));
			gvo.setEmail(mr.getParameter("email"));
			gvo.setPwd(mr.getParameter("pwd"));
			gvo.setContent(mr.getParameter("content"));
			gvo.setF_path(path);
			
			//	예전 이름을 받자
			String old_f_name = mr.getParameter("old_f_name");
			//	새로 올린게 없으면, 이전거를 그대로 쓰고
			if (mr.getFile("f_name") == null) {
				gvo.setF_name(old_f_name);
			//	새로 올린게 있으면, 새로운 파일로 바꿔주자
			}else {
				gvo.setF_name(mr.getFilesystemName("f_name"));
			}
			
			//	DB 가서 업데이트 해주자
			int res = Guest2DAO.getUpdate(gvo);
			if (res > 0) {
				return "Guest2?cmd=onelist&idx="+gvo.getIdx();
			}else {
				return "view/guestbook2/error.jsp";
			}
			
		} catch (IOException e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
		
	}

}
