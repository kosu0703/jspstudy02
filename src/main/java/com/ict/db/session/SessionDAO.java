package com.ict.db.session;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SessionDAO {
	// 살제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = SessionDBService.getFactory().openSession();
		}
		return ss;
	}
	
	// DB처리하는 메서드들
	// 회원가입
	public static int getJoin(SessionVO svo) {
		int result = 0 ;
		result = getSession().insert("sessionUser.s_join", svo);
		ss.commit();
		return result;
	}
	
	public static SessionVO getLogIn(SessionVO svo) {
		SessionVO svo2 = null;
		svo2 = getSession().selectOne("sessionUser.s_login", svo);
		return svo2;
	}
	
	public static SessionVO getDetail(String id){
		SessionVO svo2 = null;
		svo2 = getSession().selectOne("sessionUser.s_detail", id);
		return svo2;
	}
}











