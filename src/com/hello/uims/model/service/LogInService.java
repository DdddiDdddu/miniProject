package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.StudentDTO;


public class LogInService {

	public StudentDTO selectLogin(Map<String, String> parameter) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		StudentDTO student = mapper.selectLogin(parameter);
		
		sqlSession.close();
		
		return student;
	}
	


		
	


}
