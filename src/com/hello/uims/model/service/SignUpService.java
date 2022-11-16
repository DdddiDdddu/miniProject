package com.hello.uims.model.service;
import static com.hello.common.Template.getSqlSession;

//import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.StudentDTO;


public class SignUpService {

	public boolean insertMember(StudentDTO stu) {
		
		SqlSession sqlSession = getSqlSession();
		UimsMapper uimsMapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = uimsMapper.insertMember(stu);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return (result > 0)? true : false;
	}
	
	

}
