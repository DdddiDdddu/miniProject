package com.hello.uims.model.service;
import static com.hello.common.Template.getSqlSession;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;


public class SignUpService {
	
	// 학생 입력
	public boolean insertStudent(HashMap<String, String> infoMap) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper uimsMapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = uimsMapper.insertStudent(infoMap);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return (result > 0)? true : false;
	}
	
	// 교수 입력
	public boolean insertProfessor(HashMap<String, String> infoMap) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper uimsMapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = uimsMapper.insertProfessor(infoMap);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return (result > 0)? true : false;
	}
}
