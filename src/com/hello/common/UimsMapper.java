package com.hello.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;

public interface UimsMapper {

	ArrayList<GradeDTO> gradeCheck(int studentNo);

	ArrayList<LectureDTO> selectByProfNo(int profNo);

	ArrayList<EnrollmentDTO> selectStuGrade(Map<String, String> parameter);

	int insertGrade(Map<String, String> parameter);

	ArrayList<GradeDTO> selectGrade(Map<String, String> parameter);


	ArrayList<LectureJugDTO> updateJug(Map<String, String> parameter);


	List<LectureJugDTO> selectJug();

	ArrayList<LectureJugDTO> inputJudgement(Map<String, String> parameter);

	

//	List<MenuDTO> selectAllMenu();
//	MenuDTO selectMenuByCode(int code);
//	int insertMenu(MenuDTO menu);
//	int updateMenu(MenuDTO menu);
//	int deleteMenu(int code); // 예시

}
