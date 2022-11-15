package com.hello.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.StudentDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.StudentDTO;

public interface UimsMapper {

	// 전체 강의목록 조회
	ArrayList<LectureDTO> selectAllLecture();

	// 수강신청
	int enroll(Map<String, String> parameter);
	
	// 강의시간 조회
	ArrayList<LectureDTO> timeTable(Map<String, String> parameter);

	// 수강신청 내역
	ArrayList<LectureDTO> selectEnroll(Map<String, String> parameter);

	// 수강신청 취소
	int deleteEnroll(Map<String, String> parameter);

	int insertGrade(Map<String, String> parameter);

	StudentDTO selectLogin(Map<String, String> parameter);

	// 학생 : 학점 조회
	ArrayList<GradeDTO> selectGradeCheck(Map<String, String> parameter);
	
	// 교수 : 강의 목록 조회
	ArrayList<LectureDTO> selectByProfNo(int profNo);

	// 교수 : 강의 수강중인 학생 목록 조회
	ArrayList<EnrollmentDTO> selectStudentList(Map<String, String> parameter);

	// 교수 : 4가지 점수들 입력
	int insertScores(Map<String, String> parameter);

	// 교수 : A~D, F 학점 입력
	int inputFinGrade();
	
	// 교수 : 학점 관리를 위한 학점 목록 조회
	ArrayList<GradeDTO> selectGrade(Map<String, String> parameter);

	// 교수 : 학점 수정
	int updateGrade(Map<String, String> parameter);

	// 교수 : 학점 삭제
	int deleteGrade(Map<String, String> parameter);

	// 학생 : 강의 평가 메뉴
	ArrayList<LectureJugDTO> updateJug(Map<String, String> parameter);

	// 학생 : 강의 평가 하기
	List<LectureJugDTO> selectJug();

  //학생 : 강의 평가 작성
	int inputJudgement(Map<String, String> parameter);
	
  //학생 : 강의 목록 조회
	ArrayList<StudentDTO> selectByStudentNo(int studentNo);

}
