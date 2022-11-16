package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

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
}
