package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class LectureJugService {
	
	public LectureJugService() { // 종호씨 파트 
		SqlSession sqlSession = null;
		
		
	}

	
	public List<LectureJugDTO> updateJudge(Object inputJudge) {
		
		return null;
	}


	public List<LectureJugDTO> selectJudge() {
		SqlSession sqlSession = getSqlSession();
		
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		List<LectureJugDTO> lectureJugList = mapper.selectJug();
		
		sqlSession.close();
		
		return lectureJugList;
		
	}


	public static ArrayList<LectureJugDTO> selectLectureNo(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<LectureJugDTO> list = mapper.updateJug(parameter);
		
		sqlSession.close();
		
		return list;
	}

	public static boolean inputJudgement(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		int result = mapper.inputJudgement(parameter);
		
		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return (result > 0) ? true : false;
	}


	public static ArrayList<StudentDTO> selectByStudentNo(int studentNo) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<StudentDTO> list = mapper.selectByStudentNo(studentNo);

		sqlSession.close();
		
		return list;
	}


}
