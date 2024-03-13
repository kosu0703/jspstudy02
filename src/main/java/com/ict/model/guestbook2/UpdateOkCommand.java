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
		try {
			
			request.setCharacterEncoding("utf-8");
			
			String path = request.getServletContext().getRealPath("upload");
			MultipartRequest mr = 
					new MultipartRequest(request, 
							path,			//	3.
							100*1024*1024,	//	100MB , 업로드 용량 제한
							"utf-8",		//	한글처리
							//	업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
							new DefaultFileRenamePolicy()
							);
			
			String idx = mr.getParameter("idx");
			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			String email = mr.getParameter("email");
			String pwd = mr.getParameter("pwd");
			String content = mr.getParameter("content");
			String f_name = mr.getFilesystemName("f_name2");
			
			if (f_name != null) {
				File file = new File(path, f_name);
				request.setAttribute("path", path);
				request.setAttribute("f_name", f_name);
			}else {
				Guest2VO vo = Guest2DAO.getOneList(idx);
				f_name = vo.getF_name();
				path = vo.getF_path();
			}
			
			Guest2VO gvo = new Guest2VO();
			gvo.setIdx(idx);
			gvo.setName(name);
			gvo.setSubject(subject);
			gvo.setEmail(email);
			gvo.setPwd(pwd);
			gvo.setF_name(f_name);
			gvo.setF_path(path);
			gvo.setContent(content);
			
			int res = Guest2DAO.getUpdate(gvo);
			return "Guest2?cmd=onelist&idx="+idx;
		} catch (IOException e) {
			System.out.println(e);
			
		}
		return null;
		
	}

}
