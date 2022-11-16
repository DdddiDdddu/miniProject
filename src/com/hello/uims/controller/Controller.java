package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;
import com.hello.uims.model.service.EnrollService;
import com.hello.uims.model.service.GradeService;
import com.hello.uims.model.service.LectureJugService;
import com.hello.uims.model.service.LoginService;
import com.hello.uims.model.service.SignUpService;
import com.hello.uims.view.PrintResult;

public class Controller {

	private PrintResult printResult = new PrintResult();
	// private final EnrollService enrollService;
	private GradeService gradeService = new GradeService();
	// private final LectureJugService lectureJugService;
	private LoginService loginService = new LoginService();
	private final EnrollService enrollService;
	// private final LectureJugService lectureJugService;
	private final LoginService logInService;
	private SignUpService signUpService = new SignUpService();
	
	public Controller() {
		enrollService = new EnrollService();
		logInService = new LoginService();
		// lectureJugService = new LectureJugService()

	}


	public void selectGradeCheck(Map<String, String> parameter) {

		int studentNo = Integer.parseInt(parameter.get("studentNo"));

		ArrayList<GradeDTO> list = gradeService.selectGradeCheck(studentNo);

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

	public void insertScores(Map<String, String> parameter) {

		if (gradeService.insertScores(parameter))
			printResult.printSuccessMessage("insertGrade");

		else
			printResult.printErrorMessage("insertGrade");

	}

	public ArrayList<EnrollmentDTO> selectStudentList(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> list = gradeService.selectStudentList(parameter);

		if (list != null && !list.isEmpty())
			printResult.printSuccessMessage("selectStudentList");
		else
			printResult.printErrorMessage("selectStudentList");

		return list;

	}

	public void inputFinGrade(Map<String, String> parameter) {

		if (gradeService.inputFinGrade(parameter))

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

	public void lectureJug() {

	}

	public void selectGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list = gradeService.selectGrade(parameter);

		if (list != null && !list.isEmpty())
			printResult.printGrade(list);
		else
			printResult.printErrorMessage("selectGrade");

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

//	public void selectByLectureNo(Map<String, String> parameter) {
//		int lectureNo = Integer.parseInt(parameter.get("lectureNo"));
//
//		ArrayList<LectureJugDTO> list = LectureJugService.selectByLectureNo(lectureNo);
//
//		if (list != null && !list.isEmpty()) {
//			printResult.printLecture(list);
//		} else {
//			printResult.printErrorMessage("selectByProfNo");
//		}
//
//	}


	public ArrayList<LectureJugDTO> selectLectureNo(Map<String, String> parameter) {
		ArrayList<LectureJugDTO> list = LectureJugService.selectLectureNo(parameter);

		return list;
	}


//	public void selectLecture() {
//
//		List<LectureDTO> lectureList = EnrollService.selectLecture();
//
//		if (lectureList != null)
//			printResult.printLecture(lectureList);
//
//		else
//			printResult.printErrorMessage("selectLecture");
//	}
	
//	public void inputJudgement(Map<String, String> parameter) {
//		ArrayList<LectureJugDTO> list = LectureJugService.inputJudgement(parameter);
//
//	}

	public StudentDTO selectLoginStudent(Map<String, String> parameter) {

		StudentDTO student = loginService.selectLoginStudent(parameter);

		if (student == null) {
			printResult.printErrorMessage("selectLoginStudent");
		}

		return student;

	}
	
	public ProfessorDTO selectLoginProfessor(Map<String, String> parameter) {
		
		ProfessorDTO professor = loginService.selectLoginProfessor(parameter);
		
		if (professor == null) {
			printResult.printErrorMessage("selectLoginProfessor");
		}
		
		return professor;
	}


	public void insertStudent(HashMap<String, String> infoMap) {
		
		String studentId = infoMap.get("studentId");
		String studentPwd = infoMap.get("studentPwd");
		String studentName = infoMap.get("studentName");
		String studentTelNo = infoMap.get("studentTelNo");
		
		StudentDTO stu = new StudentDTO();
		stu.setStudentId(studentId);
		stu.setStudentPwd(studentPwd);
		stu.setStudentName(studentName);
		stu.setStudentTelNo(studentTelNo);
		
		if (signUpService.insertStudent(stu)) {
			printResult.printSuccessMessage("insertStudent");
		}else {
			printResult.printErrorMessage("insertStudent");
		}
	}
	public void insertProfessor(HashMap<String, String> infoMap) {
	
		int profNo = Integer.parseInt(infoMap.get("profNo"));
		String profPwd = infoMap.get("profPwd");
		String profName = infoMap.get("profName");
		String profTelNo = infoMap.get("profTelNo");
	
		ProfessorDTO pro = new ProfessorDTO();
		pro.setProfNo(profNo);
		pro.setProfPwd(profPwd);
		pro.setProfName(profName);
		pro.setProfTelNo(profTelNo);
	
		if (signUpService.insertProfessor(pro)) {
			printResult.printSuccessMessage("insertMember");
		}else {
			printResult.printErrorMessage("insertMember");
		}
	
	}

}
