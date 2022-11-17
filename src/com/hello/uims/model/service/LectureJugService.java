package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class LectureJugService {
	
	public LectureJugService() { // 종호씨 파트 
	}

	public static ArrayList<LectureJugDTO> selectLectureNo(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<LectureJugDTO> list = mapper.updateJug(parameter);
		
		sqlSession.close();
		
		return list;
	}
	
	//강의 평가 작성
	public static boolean inputJudgement(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		boolean jugplication = false;
		int result = mapper.inputJudgement(parameter);
		
		ArrayList<LectureJugDTO> list = selectJudgement(parameter);
		
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i).getLectureNo() == Integer.parseInt(parameter.get("lectureNo"))) {
				jugplication = true;
			}
		}
		
		if (result > 0 && !jugplication)
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return (result > 0 && !jugplication) ? true : false;
	}
	
	
	public static ArrayList<StudentDTO> selectByStudentNo(int studentNo) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<StudentDTO> list = mapper.selectByStudentNo(studentNo);

		sqlSession.close();
		
		return list;
	}

	public static ArrayList<LectureJugDTO> selectJudgementProf(Map<String, String> inputProfNo) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<LectureJugDTO> list = mapper.selectJudgementProf(inputProfNo);

		sqlSession.close();
		
		return list;
	}


	public static boolean modifyJudgement(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		boolean jugplication = false;
		int result = mapper.modifyJudgement(parameter);
		
		ArrayList<LectureJugDTO> list = selectJudgement(parameter);
		
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.isEmpty()) {
				jugplication = true;
			}
		}
		
		if (result > 0 && !jugplication)
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return (result > 0 && !jugplication) ? true : false;
	}


	public static ArrayList<LectureJugDTO> selectJudgement(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureJugDTO> list = mapper.selectJudgement(parameter);
		
		sqlSession.close();

		return list;
	}

	public static boolean deleteJudgement(Map<String, String> parameter) {
		SqlSession sqlSession = getSqlSession();
		UimsMapper mapper = sqlSession.getMapper(UimsMapper.class);
		boolean jugplication = false;
		int result = mapper.deleteJudgement(parameter);
		
		ArrayList<LectureJugDTO> list = selectJudgement(parameter);
		
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.isEmpty()) {
				jugplication = true;
			}
		}
		
		if (result > 0 && !jugplication)
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return (result > 0 && !jugplication) ? true : false;
	}


}
