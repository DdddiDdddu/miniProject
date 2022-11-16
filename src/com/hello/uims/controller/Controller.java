package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

		ArrayList<GradeDTO> list = gradeService.selectGradeCheck(parameter);

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

		ArrayList<GradeDTO> list = gradeService.selectGradeCheck(parameter);

		if (list != null && !list.isEmpty()) {
			printResult.printErrorMessage("insertScores");
		} else {
			if (gradeService.insertScores(parameter))
				printResult.printSuccessMessage("insertScores");
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

	public void updateFinGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list = gradeService.selectGrade(parameter);
		ArrayList<GradeDTO> list2 = new ArrayList<>();
		GradeDTO grade;
		int totScore = 0;
		int result = 0;

		for (int i = 0; i < list.size(); i++) {
			grade = new GradeDTO();
			totScore = list.get(i).getAttScore() + list.get(i).getAssScore() + list.get(i).getMidScore()
					+ list.get(i).getFinScore();
			grade.setAttScore(list.get(i).getAttScore());
			grade.setAssScore(totScore);
			grade.setStudentNo(list.get(i).getStudentNo());
			list2.add(grade);
		}

		list2.sort(new Comparator<GradeDTO>() {
			@Override
			public int compare(GradeDTO o1, GradeDTO o2) {

				return o1.getAssScore() >= o2.getAssScore() ? -1 : 1;
			}
		});

		for (int i = 0; i < list2.size(); i++) {

			parameter.put("studentNo", Integer.toString(list2.get(i).getStudentNo()));
			if (list2.get(i).getAttScore() < 7) {
				parameter.put("grade", "F");
			} else if (i <= list2.size() * 0.1) {
				parameter.put("grade", "A+");
			} else if (i <= list2.size() * 0.2) {
				parameter.put("grade", "A");
			} else if (i <= list2.size() * 0.3) {
				parameter.put("grade", "B+");
			} else if (i <= list2.size() * 0.4) {
				parameter.put("grade", "B");
			} else if (i <= list2.size() * 0.5) {
				parameter.put("grade", "C+");
			} else if (i <= list2.size() * 0.6) {
				parameter.put("grade", "C");
			} else if (i <= list2.size() * 0.7) {
				parameter.put("grade", "D+");
			} else {
				parameter.put("grade", "D");
			}

			if (gradeService.updateFinGrade(parameter)) {
				result++;
			}
		}

		if (result == list2.size()) {
			printResult.printSuccessMessage("updateFinGrade");
		} else {
			printResult.printErrorMessage("updateFinGrade");
		}
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
			printResult.printErrorMessage("selectByProfNo");
	}

	public void inputJudgement(Map<String, String> parameter) {
		if (LectureJugService.inputJudgement(parameter))
			printResult.printSuccessMessage("inputJudgement");

		else
			printResult.printErrorMessage("inputJudgement");
		
	}


	public void modifyJudge() {
		// TODO Auto-generated method stub
		
	}

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


	public void insertMember(HashMap<String, String> infoMap) {
		
		String studentId = infoMap.get("studentId");
		String studentPwd = infoMap.get("studentPwd");
		String studentName = infoMap.get("studentName");
		String studentTelNo = infoMap.get("studentTelNo");
		
		StudentDTO stu = new StudentDTO();
		stu.setStudentId(studentId);
		stu.setStudentPwd(studentPwd);
		stu.setStudentName(studentName);
		stu.setStudentTelNo(studentTelNo);
		
		if (signUpService.insertMember(stu)) {
			printResult.printSuccessMessage("insertMember");
		}else {
			printResult.printErrorMessage("insertMember");
		}
		
	}

}
