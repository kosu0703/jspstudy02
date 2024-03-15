package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ict.db.guestbook2.Guest2VO;
import com.ict.db.guestbook2.Guest2DBService;

//	실제 DB 갔다오는 클래스
public class Guest2DAO {
	//	DB 갔다오기위해 Sql 세션을 사용
	private static SqlSession ss;
	
	//	Sql 세션을 반환하는 메서드
	private synchronized static SqlSession getSesstion() {
		//	처음에는 무조건 null
		if(ss == null) {
			//	처음에는 세션을 만들어라
			ss = Guest2DBService.getFactory().openSession();
		}
		return ss;
	}
	
//	DB 처리하는 메서드들
	
	//	메인화면
	//	전체 목록 가져오기
	//	selectList
	public static List<Guest2VO> getList(){
		//	오류 생길것을 생각해서 항상 try catch 해주자
		try {
			List<Guest2VO> list = null;
			list = getSesstion().selectList("guestbook2.list");
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//	삽입
	// 	insert 
	public static int getInsert(Guest2VO gvo){
		try {
			int result = 0;
			result = getSesstion().insert("guestbook2.insert", gvo);	
			//	삽입, 삭제, 수정은 항상 커밋을 해주자
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	//	상세보기
	//	idx 로 검색하기	
	//	selectOne
	public static Guest2VO getOneList(String idx) {
		try {
			Guest2VO gvo = null;
			gvo = getSesstion().selectOne("guestbook2.detail", idx);
			return gvo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//	삭제
	//	idx 로 삭제하기
	//	delete
	public static int getDelete(String idx){
		try {
			int result = 0;
			result = getSesstion().delete("guestbook2.delete", idx);
			//	삽입, 삭제, 수정은 항상 커밋을 해주자
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	//	수정하기
	//	update
	public static int getUpdate(Guest2VO gvo){
		try {
			int result = 0;
			result = getSesstion().update("guestbook2.update", gvo);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}











