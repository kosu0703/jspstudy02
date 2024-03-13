package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ict.db.guestbook2.Guest2VO;
import com.ict.db.guestbook2.Guest2DBService;

public class Guest2DAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSesstion() {
		if(ss == null) {
			ss = Guest2DBService.getFactory().openSession();
		}
		return ss;
	}
	
//	DB 처리하는 메서드들
	
	//	리스트
	public static List<Guest2VO> getList() {
		List<Guest2VO> list = null;
		list = getSesstion().selectList("guestbook2.list");
		return list;
	}
	
	// 	insert
	public static int getInsert(Guest2VO gvo){
		int result = 0;
		result = getSesstion().insert("guestbook2.insert", gvo);	
		//	삽입, 삭제, 수정은 항상 커밋을 해주자
		ss.commit();
		return result;
	}
	
	//	idx 로 검색하기	
	public static Guest2VO getOneList(String idx) {
		Guest2VO gvo = null;
		gvo = getSesstion().selectOne("guestbook2.detail", idx);
		return gvo;
	}
	
	//	idx 로 삭제하기
	public static int getDelete(String idx){
		int result = 0;
		result = getSesstion().delete("guestbook2.delete", idx);
		//	삽입, 삭제, 수정은 항상 커밋을 해주자
		ss.commit();
		return result;
	}
	
	//	수정하기
	public static int getUpdate(Guest2VO gvo){
		int result = 0;
		result = getSesstion().update("guestbook2.update", gvo);
		ss.commit();
		return result;
	}

}











