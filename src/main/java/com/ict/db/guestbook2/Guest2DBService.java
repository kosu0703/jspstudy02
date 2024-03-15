package com.ict.db.guestbook2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Guest2DBService {
	//	SqlSession 을 반환하는 것이 목적이다.
	static private SqlSessionFactory factory;
	
	//	resource 는 config.xml 을 읽어와야한다.
	static String resource = "com/ict/db/guestbook2/guest2_config.xml";
	
	// static 초기화
	static {
		try {
			//	마이바티스 리소스를 가져오자
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//	이걸 쓰기 위해서 인풋스트림을 썼고, 인풋스트림을 쓰기위해 config.xml 리소스를 사용했다.
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			//	**항상 오류나는 것을 찍어서 고쳐주자
			System.out.println(e);
		}
	}
	
	// DAO에서 factory를 호출할 메서드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
