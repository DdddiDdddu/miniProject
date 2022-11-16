package com.hello.uims.model.service;
import static com.hello.common.Template.getSqlSession;

//import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;


public class SignUpService {

	public boolean insertStudent(StudentDTO stu) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper uimsMapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = uimsMapper.insertStudent(stu);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return (result > 0)? true : false;
	}

	public boolean insertProfessor(ProfessorDTO pro) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper uimsMapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = uimsMapper.insertProfessor(pro);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return (result > 0)? true : false;
	}

}
