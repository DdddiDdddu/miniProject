package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.StudentDTO;
import com.hello.uims.model.service.EnrollService;
import com.hello.uims.model.service.GradeService;
import com.hello.uims.model.service.LectureJugService;
import com.hello.uims.model.service.LogInService;
import com.hello.uims.view.PrintResult;

public class Controller {

	private PrintResult printResult = new PrintResult();
	// private final EnrollService enrollService;
	private GradeService gradeService = new GradeService();
	// private final LectureJugService lectureJugService;
	private LogInService loginService = new LogInService();
	private final EnrollService enrollService;
	// private final LectureJugService lectureJugService;
	private final LogInService logInService;

	public Controller() {
		enrollService = new EnrollService();
		logInService = new LogInService();
		// lectureJugService = new LectureJugService()

	}


	public void selectGradeCheck(Map<String, String> parameter) {

		

		ArrayList<GradeDTO> list = gradeService.selectGradeCheck(parameter);

		if (list != null && !list.isEmpty())
			printResult.printGrade(list);

		else
			printResult.printErrorMessage("gradeCheck");

	}

	public void selectByProfNo(Map<String, String> parameter) {

		

		ArrayList<LectureDTO> list = gradeService.selectByProfNo(parameter);

		if (list != null && !list.isEmpty())
			printResult.printLecture(list);

		else
			printResult.printErrorMessage("selectByProfNo");

	}

	public void insertScores(Map<String, String> parameter) {
		
		ArrayList<GradeDTO> list = gradeService.selectGradeCheck(parameter);
		
		if(list != null && !list.isEmpty()) {
			printResult.printErrorMessage("insertGrade");
		} else {
			if (gradeService.insertScores(parameter))
				printResult.printSuccessMessage("insertGrade");
		}

	}

	public ArrayList<EnrollmentDTO> selectStudentList(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> list = gradeService.selectStudentList(parameter);

		if (list != null && !list.isEmpty())
			printResult.printSuccessMessage("selectStudentList");
		else
			printResult.printErrorMessage("selectStudentList");

		return list;

	}

	public void inputFinGrade() {
		
		
		
		if (gradeService.inputFinGrade())
			printResult.printSuccessMessage("inputFinGrade");
		else
			printResult.printErrorMessage("inputFinGrade");

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
	public void selectEnroll(Map<String, String> parameter) {

		ArrayList<LectureDTO> lectureList = enrollService.selectEnroll(parameter);

		if (lectureList != null)
			printResult.printLecture(lectureList);
		else
			printResult.printErrorMessage("selectEnroll");

	}

	// 수강신청 취소
	public void deleteEnroll(Map<String, String> parameter) {

		if (enrollService.deleteEnroll(parameter))
			printResult.printSuccessMessage("deleteEnroll");
		else
			printResult.printErrorMessage("deleteEnroll");

	}

	public ArrayList<GradeDTO> selectGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list = gradeService.selectGrade(parameter);

		if (list != null && !list.isEmpty())
			printResult.printGrade(list);
		else
			printResult.printErrorMessage("selectGrade");
		
		return (list != null && !list.isEmpty())? list : null;
	}

	public void updateGrade(Map<String, String> parameter) {

		if (gradeService.updateGrade(parameter))
			printResult.printSuccessMessage("updateGrade");
		else
			printResult.printErrorMessage("updateGrade");

	}

	public void deleteGrade(Map<String, String> parameter) {
		
		if (gradeService.deleteGrade(parameter))
			printResult.printSuccessMessage("deleteGrade");
		else
			printResult.printErrorMessage("deleteGrade");

	}


	public void selectByStudentNo(Map<String, String> parameter) {

		int studentNo = Integer.parseInt(parameter.get("studentNo"));

		ArrayList<StudentDTO> list = LectureJugService.selectByStudentNo(studentNo);

		if (list != null && !list.isEmpty())
			printResult.printStudent(list);

		else
			printResult.printErrorMessage("selectBystudentNo");
		
	}

	public void inputJudgement(Map<String, String> parameter) {
		if (LectureJugService.inputJudgement(parameter))
			printResult.printSuccessMessage("inputJudgement");

		else
			printResult.printErrorMessage("inputJudgement");
		
	}

	public StudentDTO selectLogin(Map<String, String> parameter) {

		StudentDTO student = loginService.selectLogin(parameter);

		if (student == null) {
			printResult.printErrorMessage("selectLogin");
		}

		return student;

	}


	public void modifyJudgement(Map<String, String> parameter) {
		
		if (LectureJugService.modifyJudgement(parameter))
			printResult.printSuccessMessage("modifyJudgement");
		else
			printResult.printErrorMessage("modifyJudgement");
		
	}


	public ArrayList<LectureJugDTO> selectJudgement(Map<String, String> parameter) {
		
		ArrayList<LectureJugDTO> list = LectureJugService.selectJudgement(parameter);

		if (list != null && !list.isEmpty())
			printResult.printJudgement(list);
		else
			printResult.printErrorMessage("selectJudgement");
		
		return (list != null && !list.isEmpty())? list : null;
		
	}


	public void deleteJudgement(Map<String, String> parameter) {

		if (LectureJugService.deleteJudgement(parameter))
			printResult.printSuccessMessage("deleteJudgement");
		else
			printResult.printErrorMessage("deleteJudgement");
	}

}
