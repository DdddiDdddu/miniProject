package com.hello.common;

import java.util.ArrayList;
import java.util.Map;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.StudentDTO;

public interface UimsMapper {

	ArrayList<GradeDTO> gradeCheck(int studentNo);

	ArrayList<LectureDTO> selectByProfNo(int profNo);

	ArrayList<GradeDTO> selectStuGrade(int lectureNo);

	int insertGrade(Map<String, String> parameter);

	StudentDTO selectLogin(Map<String, String> parameter);


	
//	List<MenuDTO> selectAllMenu();
//	MenuDTO selectMenuByCode(int code);
//	int insertMenu(MenuDTO menu);
//	int updateMenu(MenuDTO menu);
//	int deleteMenu(int code); // 예시
	
}
