package com.ict.db.cookie;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CookieDBService {
	static private SqlSessionFactory factory;
	static String resource = "com/ict/db/cookie/cookie_config.xml";
	// static 초기화
	static {
		try {
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
		}
	}
	
	// DAO에서 factory를 호출할 메서드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
