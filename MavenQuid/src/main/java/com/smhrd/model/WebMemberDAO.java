package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class WebMemberDAO {
	SqlSessionFactory sessionFactory = SqlSessionManager.getSessionFactory();
	
	// 회원가입
	public int join (WebMember vo) {
		SqlSession sqlSession = sessionFactory.openSession(true); //true: 오토커밋이 가능
		
		int cnt = sqlSession.insert("join",vo);
		
		sqlSession.close();
		
		return cnt;
	}
	
	//로그인
	public WebMember login(WebMember vo) {
		WebMember loginMember = null;
		
		SqlSession sqlSession = sessionFactory.openSession(true);
		loginMember = sqlSession.selectOne("login", vo); // selectOne: 해당 행 한 줄만 가져오기
		
		sqlSession.close();
		
		return loginMember;
	}
	
	//회원정보수정
	public int update(WebMember vo) {
		SqlSession sqlSession = sessionFactory.openSession(true);
		int cnt = sqlSession.update("update",vo);
		sqlSession.close();
		return cnt;		
	}
	
	//전체회원정보 불러오기
		//여러개의 객체를 묶어서 반환 -> List<실제 리스트 안에 들어가는 객체 타입>
		public List<WebMember> select(){
			SqlSession sqlSession = sessionFactory.openSession(true);
			List<WebMember> list = sqlSession.selectList("select");
			sqlSession.close();
			return list;
		}
		
	//회원삭제
		public int delete(String gu_id) {
			SqlSession sqlSession = sessionFactory.openSession(true);
			int cnt = sqlSession.delete("delete",gu_id);
			sqlSession.close();
			return cnt;
		}
		

		
		//아이디 중복체크
//		public boolean gu_idCheck(String input) {
//			SqlSession sqlSession = sessionFactory.openSession(true);
//			boolean result = sqlSession.selectOne("gu_idCheck",input);
//			sqlSession.close();
//			return result; //true(있는 값인 경우 - 사용불가능) / false(없는 값인 경우 - 사용가능)
//		}
//		
//		public WebMember gu_idCheck2(String input) {
//			SqlSession sqlSession = sessionFactory.openSession(true);
//			WebMember result = sqlSession.selectOne("gu_idCheck2",input);
//			sqlSession.close();
//			return result; //true(있는 값인 경우 - 사용불가능) / false(없는 값인 경우 - 사용가능)

//		}
}
