package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class LoginService {
	
	// 학생 로그인용 조회
	public StudentDTO selectLoginStudent(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		StudentDTO student = mapper.selectLoginStudent(parameter);

		sqlSession.close();

		return student;
	}
	
	// 교수 로그인용 조회
	public ProfessorDTO selectLoginProfessor(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ProfessorDTO professor = mapper.selectLoginProfessor(parameter);

		sqlSession.close();

		return professor;
	}
	
	// 학생 조회
	public StudentDTO selectStuId(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		StudentDTO student = mapper.selectStuId(parameter);

		sqlSession.close();

		return student;
	}
	
	// 학생 수정
	public boolean updateStuId(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		int result = mapper.updateStuId(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		sqlSession.close();

		return (result > 0) ? true : false;
	}
	
	// 학생 삭제
	public boolean deleteStuId(Map<String, String> parameter) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = mapper.deleteStuId(parameter);
		
		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return (result > 0)? true : false;
	}
	
	// 교수 조회
	public ProfessorDTO selectProfId(HashMap<String, String> parameter) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ProfessorDTO professor = mapper.selectProfId(parameter);

		sqlSession.close();

		return professor;
		
	}
	
	// 교수 수정
	public boolean updateProfId(Map<String, String> parameter) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		int result = mapper.updateProfId(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		sqlSession.close();

		return (result > 0) ? true : false;
	}
}
