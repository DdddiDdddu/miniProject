package com.hello.uims.controller;

//import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
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
	private final EnrollService enrollService;
	// private final LectureJugService lectureJugService;
	private final LoginService loginService;
	private SignUpService signUpService = new SignUpService();

	public Controller() {
		enrollService = new EnrollService();
		loginService = new LoginService();
		// lectureJugService = new LectureJugService()

	}

	public void selectGradeCheck(Map<String, String> parameter) {

		ArrayList<GradeDTO> list;
		try {
			list = gradeService.selectGradeCheck(parameter);

			if (list != null && !list.isEmpty())
				printResult.printGrade(list);
			else
				printResult.printErrorMessage("gradeCheck");
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}

	}

	public void selectByProfNo(Map<String, String> parameter) {

		ArrayList<LectureDTO> list;
		try {
			list = gradeService.selectByProfNo(parameter);

			if (list != null && !list.isEmpty())
				printResult.printLecture(list);

			else
				printResult.printErrorMessage("selectByProfNo");

		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}

	}

	public void insertScores(Map<String, String> parameter) {

		ArrayList<GradeDTO> list;
		try {
			list = gradeService.selectGradeCheck(parameter);

			if (list != null && !list.isEmpty()) {
				printResult.printErrorMessage("insertScores");
			} else {
				if (gradeService.insertScores(parameter))
					printResult.printSuccessMessage("insertScores");
			}
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}

	}

	public ArrayList<EnrollmentDTO> selectStudentList(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> list = null;
		try {
			list = gradeService.selectStudentList(parameter);

			if (list != null && !list.isEmpty())
				printResult.printSuccessMessage("selectStudentList");
			else
				printResult.printErrorMessage("selectStudentList");

		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}

		return list;

	}

	public void updateFinGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list;

		try {
			list = gradeService.selectGrade(parameter);

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
				if (result == list2.size()) {
					printResult.printSuccessMessage("updateFinGrade");
				} else {
					printResult.printErrorMessage("updateFinGrade");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}
	}

	// 강의목록 조회
	public void selectAllLecture() {

		ArrayList<LectureDTO> lectureList = enrollService.selectAllLecture();

		if (lectureList != null && !lectureList.isEmpty())
			printResult.printLecture(lectureList);
		else
			printResult.printErrorMessage("selectAllLecture");
	}

	// 수강신청
	public void enroll(Map<String, String> parameter) {

		// 수강신청 결과별 출력메세지
		try {
			switch (enrollService.enroll(parameter)) {
			case "enrollSuccess":
				printResult.printSuccessMessage("enrollSuccess");
				break;
			case "totalCreditOver":
				printResult.printErrorMessage("totalCreditOver");
				break;
			case "enrollFail":
				printResult.printErrorMessage("enrollFail");
				break;
			case "timeDuplication":
				printResult.printErrorMessage("timeDuplication");
				break;
			case "duplication":
				printResult.printErrorMessage("duplication");
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("incorrectInput");
		}

	}

	// 수강신청 내역
	public void selectEnroll(Map<String, String> parameter) {

		ArrayList<LectureDTO> lectureList = enrollService.selectEnroll(parameter);

		if (lectureList != null && !lectureList.isEmpty())
			printResult.printLecture(lectureList);
		else
			printResult.printErrorMessage("selectEnroll");
	}

	// 수강신청 취소
	public void deleteEnroll(Map<String, String> parameter) {

		try {
			if (enrollService.deleteEnroll(parameter))
				printResult.printSuccessMessage("deleteEnroll");
			else
				printResult.printErrorMessage("deleteEnroll");
			
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}
	}

	// 강의목록 검색
	public void searchLectureByLectureNameOrProfName(Map<String, String> criteria) {

		ArrayList<LectureDTO> lectureList;

		lectureList = enrollService.searchLectureByLectureNameOrProfName(criteria);

		if (lectureList != null && !lectureList.isEmpty())
			printResult.printLecture(lectureList);
		else
			printResult.printErrorMessage("searchLectureByLectureNameOrProfName");

	}

	public ArrayList<GradeDTO> selectGrade(Map<String, String> parameter) {

		ArrayList<GradeDTO> list = null;

		try {
			list = gradeService.selectGrade(parameter);

			if (list != null && !list.isEmpty())
				printResult.printGrade(list);
			else
				printResult.printErrorMessage("selectGrade");

		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}

		return (list != null && !list.isEmpty()) ? list : null;
	}

	public void updateGrade(Map<String, String> parameter) {

		try {
			if (gradeService.updateGrade(parameter))
				printResult.printSuccessMessage("updateGrade");
			else
				printResult.printErrorMessage("updateGrade");
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}
	}

	public void deleteGrade(Map<String, String> parameter) {

		try {
			if (gradeService.deleteGrade(parameter))
				printResult.printSuccessMessage("deleteGrade");
			else
				printResult.printErrorMessage("deleteGrade");
		} catch (Exception e) {
			e.printStackTrace();
			printResult.printErrorMessage("error");
		}
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

	public StudentDTO selectLoginStudent(Map<String, String> parameter) {

		StudentDTO student = loginService.selectLoginStudent(parameter);

		if (student == null) {
			printResult.printErrorMessage("selectLogin");
		}

		return student;
	}

	public ProfessorDTO selectLoginProfessor(Map<String, String> parameter) {

		ProfessorDTO professor = loginService.selectLoginProfessor(parameter);

		if (professor == null) {
			printResult.printErrorMessage("selectLogin");
		}

		return professor;
	}

	public void insertStudent(HashMap<String, String> infoMap) {

		if (signUpService.insertStudent(infoMap)) {
			printResult.printSuccessMessage("insertStudent");
		} else {
			printResult.printErrorMessage("insertStudent");
		}
	}

	public void insertProfessor(HashMap<String, String> infoMap) {

		if (signUpService.insertProfessor(infoMap)) {
			printResult.printSuccessMessage("insertProfessor");
		} else {
			printResult.printErrorMessage("insertProfessor");
		}

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
		return list;

	}

	// 교수 : 자기 교수번호에 맞는 강의만 조회
	public ArrayList<LectureJugDTO> selectJudmentProf(Map<String, String> inputProfNo) {

		ArrayList<LectureJugDTO> list = LectureJugService.selectJudgementProf(inputProfNo);

		if (list != null && !list.isEmpty())
			printResult.printJudgementProf(list);
		else
			printResult.printErrorMessage("selectJudgementProf");

		return (list != null && !list.isEmpty()) ? list : null;

	}

	public void deleteJudgement(Map<String, String> parameter) {

		if (LectureJugService.deleteJudgement(parameter))
			printResult.printSuccessMessage("deleteJudgement");
		else
			printResult.printErrorMessage("deleteJudgement");
	}

	public void selectStuId(Map<String, String> parameter) {

		StudentDTO student = loginService.selectStuId(parameter);
		ArrayList<StudentDTO> list = new ArrayList<>();
		list.add(student);

		if (student != null)
			printResult.printStudent(list);
		else
			printResult.printErrorMessage("selectStuId");

	}

	public void updateStuId(Map<String, String> parameter) {

		if (loginService.updateStuId(parameter))
			printResult.printSuccessMessage("updateStudId");
		else
			printResult.printErrorMessage("updateStuId");

	}

	public void deleteStuId(Map<String, String> parameter) {

		if (loginService.deleteStuId(parameter))
			printResult.printSuccessMessage("deleteStuId");
		else
			printResult.printErrorMessage("deleteStuId");

	}

	public void selectProfId(HashMap<String, String> parameter) {

		ProfessorDTO professor = loginService.selectProfId(parameter);
		ArrayList<ProfessorDTO> list = new ArrayList<>();
		list.add(professor);

		if (professor != null)
			printResult.printProfessor(list);
		else
			printResult.printErrorMessage("selectProfId");

	}

	public void updateProfId(Map<String, String> parameter) {

		if (loginService.updateProfId(parameter))
			printResult.printSuccessMessage("updateProfId");
		else
			printResult.printErrorMessage("updateProfId");
	}

}
