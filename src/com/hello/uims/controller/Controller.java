package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.service.EnrollService;
import com.hello.uims.model.service.GradeService;
import com.hello.uims.view.PrintResult;
import com.hello.uims.view.studentNo;

public class Controller {

	private EnrollService enrollService = new EnrollService();
	private GradeService gradeService = new GradeService();
	private PrintResult printResult = new PrintResult();

	public void gradeCheck(Map<String, String> parameter) {

		int studentNo = Integer.parseInt(parameter.get("studentNo"));

		ArrayList<GradeDTO> list = gradeService.gradeCheck(studentNo);

		if (list != null && !list.isEmpty())
			printResult.printGrade(list);

		else
			printResult.printErrorMessage("gradeCheck");

	}

	public void selectByProfNo(Map<String, String> parameter) {

		int profNo = Integer.parseInt(parameter.get("profNo"));

		ArrayList<LectureDTO> list = gradeService.selectByProfNo(profNo);

		if (list != null && !list.isEmpty())
			printResult.printLecture(list);

		else
			printResult.printErrorMessage("selectByProfNo");

	}

	public void insertGrade(Map<String, String> parameter) {

		if (gradeService.insertGrade(parameter))
			printResult.printSuccessMessage("insertGrade");

		else
			printResult.printErrorMessage("insertGrade");

	}

	public ArrayList<EnrollmentDTO> selectStuGrade(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> list = gradeService.selectStuGrade(parameter);

		return list;

	}

	public void inputFinGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list = gradeService.selectGrade(parameter);

	}

	// 수강신청 강의목록
	public void selectAllLecture() {

		ArrayList<LectureDTO> lectureList = enrollService.selectAllLecture();

		if (lectureList != null)
			printResult.printLecture(lectureList);

		else
			printResult.printErrorMessage("selectLecture");

	}

	// 수강신청
	public void enroll(Map<String, String> parameter) {
		
		if (enrollService.enroll(parameter))
			printResult.printSuccessMessage("enroll");

		else
			printResult.printErrorMessage("enroll");

	}
	
	// 수강신청 내역
	public void selectEnroll() {
		
		ArrayList<LectureDTO> lectureList = enrollService.selectAllLecture();

		if (lectureList != null)
			printResult.printLecture(lectureList);

		else
			printResult.printErrorMessage("selectLecture");
		
	}

	public void lectureJug() {

	}

}
