package com.hello.uims.model.service;

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
