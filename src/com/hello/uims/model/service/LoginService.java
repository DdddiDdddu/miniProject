package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class LoginService {

	public StudentDTO selectLoginStudent(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		StudentDTO student = mapper.selectLoginStudent(parameter);

		sqlSession.close();

		return student;
	}

	public ProfessorDTO selectLoginProfessor(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ProfessorDTO professor = mapper.selectLoginProfessor(parameter);

		sqlSession.close();

		return professor;
	}

	public StudentDTO selectStuId(Map<String, String> parameter) {

		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		StudentDTO student = mapper.selectStuId(parameter);

		sqlSession.close();

		return student;
	}

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

	public ProfessorDTO selectProfId(HashMap<String, String> parameter) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ProfessorDTO professor = mapper.selectProfId(parameter);

		sqlSession.close();

		return professor;
		
	}


}
