package com.hello.uims.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;

import static com.hello.common.Template.getSqlSession;

public class GradeService {

	SqlSession sqlSession = null;

	public GradeService() { // 승재형 파트

	}

	// 학생 : 학점 조회
	public ArrayList<GradeDTO> selectGradeCheck(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		ArrayList<GradeDTO> list = mapper.selectGradeCheck(parameter);

		sqlSession.close();

		return list;
	}

	// 교수 : 자기가 강의중인 강의 목록 조회
	public ArrayList<LectureDTO> selectByProfNo(int profNo) {

		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		ArrayList<LectureDTO> list = mapper.selectByProfNo(profNo);

		sqlSession.close();

		return list;
	}

	// 교수 : 강의 수강중인 학생 목록 조회
	public ArrayList<EnrollmentDTO> selectStudentList(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		ArrayList<EnrollmentDTO> list = mapper.selectStudentList(parameter);

		sqlSession.close();

		return list;
	}

	// 교수 : 학생 점수
	public boolean insertScores(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		int result = mapper.insertScores(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;
	}

	public ArrayList<GradeDTO> selectGrade(Map<String, String> parameter) {
		
		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<GradeDTO> list = mapper.selectGrade(parameter);

		sqlSession.close();

		return list;
	}

	public boolean updateFinGrade(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		int result = mapper.updateFinGrade(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;
	}

	public boolean updateGrade(Map<String, String> parameter) {
		
		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		int result = mapper.updateGrade(parameter);
		
		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;
	}

	public boolean deleteGrade(Map<String, String> parameter) {
		
		sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		int result = mapper.deleteGrade(parameter);
		
		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;
	}



}
