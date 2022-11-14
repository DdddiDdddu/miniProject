package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.service.EnrollService;
import com.hello.uims.model.service.GradeService;
import com.hello.uims.view.PrintResult;

public class Controller {

	private GradeService gradeService = new GradeService();
	private PrintResult printResult = new PrintResult();
	
	public void gradeCheck(Map<String, String> parameter) {
		
		int studentNo = Integer.parseInt(parameter.get("studentNo"));
		
		ArrayList<GradeDTO> list = gradeService.gradeCheck(studentNo);
		
		if(list != null && !list.isEmpty()) {
			printResult.printGrade(list);
		} else {
			printResult.printErrorMessage("gradeCheck");
		}
		
	}

	public void selectByProfNo(Map<String, String> parameter) {
		
		int profNo = Integer.parseInt(parameter.get("profNo"));
		
		ArrayList<LectureDTO> list = gradeService.selectByProfNo(profNo);
		
		if(list != null && !list.isEmpty()) {
			printResult.printLecture(list);
		} else {
			printResult.printErrorMessage("selectByProfNo");
		}
		
	}

	public void insertGrade(Map<String, String> parameter) {
		
		
		
		if(gradeService.insertGrade(parameter)) {
			printResult.printSuccessMessage("insertGrade");
		} else {
			printResult.printErrorMessage("insertGrade");
		}
		
	}

	public ArrayList<GradeDTO> selectStuGrade(Map<String, String> parameter) {
		
		int lectureNo = Integer.parseInt(parameter.get("lectureNo"));
		
		ArrayList<GradeDTO> list = gradeService.selectStuGrade(lectureNo);
		
		return list;
	}

	public void selectLecture() {

		List<LectureDTO> lectureList = EnrollService.selectLecture();

		if (lectureList != null) 
			printResult.printLecture(lectureList);
			
		 else 
			printResult.printErrorMessage("selectLecture");
		
		
	}

	public void lectureJug() {
		
		
	}

}
