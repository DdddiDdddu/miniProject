package com.hello.common;

import java.util.ArrayList;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;

public interface UimsMapper {

	// 수강신청 - 강의목록 조회 
	ArrayList<LectureDTO> selectAllLecture();
	
	//수강신청
	int enroll(Map<String, String> parameter);
	
	ArrayList<GradeDTO> gradeCheck(int studentNo);

	ArrayList<LectureDTO> selectByProfNo(int profNo);

	ArrayList<EnrollmentDTO> selectStuGrade(Map<String, String> parameter);

	int insertGrade(Map<String, String> parameter);
	
	ArrayList<GradeDTO> selectGrade(Map<String, String> parameter);

//	List<MenuDTO> selectAllMenu();
//	MenuDTO selectMenuByCode(int code);
//	int insertMenu(MenuDTO menu);
//	int updateMenu(MenuDTO menu);
//	int deleteMenu(int code); // 예시

}
