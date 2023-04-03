package com.smhrd.model;

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
}
