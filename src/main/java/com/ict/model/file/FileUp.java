package com.ict.model.file;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUp {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			//	1.
			//	**실제 저장위치를 얻어내자
			String path = request.getServletContext().getRealPath("upload");
			
			//	2.
			//	cos.jar 라이브러리에서 지원하는 클래스
			//	파일 업로드를 하면 request 대신에 사용하는 클래스
			MultipartRequest mr = 
					new MultipartRequest(request, 
							path,			//	3.
							100*1024*1024,	//	100MB , 업로드 용량 제한
							"utf-8",		//	한글처리
							//	업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
							new DefaultFileRenamePolicy()
							);
			
			//	3.
			//	이젠 request 로는 정보를 얻어낼 수 없다.
			//System.out.println(request.getParameter("name"));
			
			//	**MultipartRequest mr 로 모든 정보를 얻어낼 수 있다.
			//System.out.println(mr.getParameter("name"));
			String name = mr.getParameter("name");
			
			//	사용자가 파일을 올릴 때 이름 => 같은 이름이 있으면 변경될 수 있음
			//String f_name = mr.getOriginalFileName("f_name");
			
			//	**서버가 저장할 당시의 이름
			String f_name = mr.getFilesystemName("f_name");
			
			//	파일의 문서 유형(텍스트, 이미지, 동영상 등을 구분) => MIME
			String contentType = mr.getContentType("f_name");
			
			//					저장 위치, 파일 이름
			File file = new File(path, f_name);
			//	파일의 크기
			long f_size = file.length();
			//	마지막으로 수정한 날짜
			long f_last = file.lastModified();
			
			//System.out.println(name);
			//System.out.println(f_name);
			//System.out.println(contentType);
			//System.out.println(f_size);
			//System.out.println(f_last);	//	밀리초로 나옴
			
			SimpleDateFormat day = 		//	년 월 일 	  시 분 초 요일
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			String f_last2 = day.format(f_last);
			
			request.setAttribute("path", path);
			request.setAttribute("name", name);
			request.setAttribute("f_name", f_name);
			request.setAttribute("contentType", contentType);
			request.setAttribute("f_size", f_size);
			request.setAttribute("f_last", f_last);	
			request.setAttribute("f_last2", f_last2);	
			
			return "view/fileup_down/FileUp_result.jsp";
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
