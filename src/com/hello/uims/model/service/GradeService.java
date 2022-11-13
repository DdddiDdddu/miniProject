package com.hello.uims.model.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.GradeDTO;
import static com.hello.common.Template.getSqlSession;

public class GradeService {
	
	SqlSession sqlSession = null;
	
	public GradeService() { // 승재형 파트 

	}

	public ArrayList<GradeDTO> gradeCheck(int studentNo) {
		
		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		ArrayList<GradeDTO> list = mapper.gradeCheck(studentNo);
		
		sqlSession.close();
		
		return list;
	}

}
