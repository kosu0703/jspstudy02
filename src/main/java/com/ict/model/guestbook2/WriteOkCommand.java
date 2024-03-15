package com.ict.model.guestbook2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//	multipart 로 넘어오면 무조건 try ~ catch
		try {
			//	1. 실제 저장위치 받자
			String path = request.getServletContext().getRealPath("upload");
			
			//	2. cos 에서 지원하는 클래스 사용
			//		파일업로드 자동으로 됨
			MultipartRequest mr = 
					new MultipartRequest(request, 
							path,			//	3.
							100*1024*1024,	//	100MB , 업로드 용량 제한
							"utf-8",		//	한글처리
							//	업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
							new DefaultFileRenamePolicy()
							);
			
			//String name = mr.getParameter("name");
			//String subject = mr.getParameter("subject");
			//String email = mr.getParameter("email");
			//String pwd = mr.getParameter("pwd");
			//String content = mr.getParameter("content");
			
			Guest2VO gvo = new Guest2VO();
			gvo.setName(mr.getParameter("name"));
			gvo.setSubject(mr.getParameter("subject"));
			gvo.setEmail(mr.getParameter("email"));
			gvo.setPwd(mr.getParameter("pwd"));
			gvo.setContent(mr.getParameter("content"));
			gvo.setF_path(path);
			
			//	첨부파일이 있을때와 없을때를 구분하자
			/*
			String f_name = mr.getFilesystemName("f_name");
			if (f_name != null) {
				File file = new File(path, f_name);
				request.setAttribute("path", path);
				request.setAttribute("f_name", f_name);
			}else {
				f_name = "none";
				path = "none";
			}
			*/
			//gvo.setF_name(f_name);
			//gvo.setF_path(path);
			
			if (mr.getFile("f_name") != null){
				gvo.setF_name(mr.getFilesystemName("f_name"));
			}else {
				gvo.setF_name("");
			}
			int result = Guest2DAO.getInsert(gvo);
			if (result > 0) {
				return "Guest2?cmd=list";
			}
			return "view/guestbook2/error.jsp";
		} catch (IOException e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
		
	}

}
