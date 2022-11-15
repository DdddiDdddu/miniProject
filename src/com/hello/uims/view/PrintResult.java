package com.hello.uims.view;

import java.util.List;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class PrintResult {

//	public void printMenuList(List<MenuDTO> menuList) {
//
//		for (MenuDTO menu : menuList)
//			System.out.println(menu);
//
//	}
//
//	public void printMenu(MenuDTO menu) {
//		System.out.println(menu);
//	}
//
	public void printSuccessMessage(String successCode) {

		String successMessage = "";

		switch (successCode) {
		case "insertGrade":
			successMessage = "학점 추가에 성공하셨습니다.";
			break;
//		case "selectStudentList":
//			successMessage = "======= 수강생 목록 =======";
//			break;
		case "updateGrade":
			successMessage = "학점 수정에 성공하셨습니다.";
			break;
//		case "update":
//			successMessage = "메뉴 수정에 성공하셨습니다.";
//			break;
//		case "delete":
//			successMessage = "메뉴 삭제에 성공하셨습니다.";
//			break;
		case "enroll":
			successMessage = "수강신청 성공";
			break;
		case "deleteEnroll":
			successMessage = "수강신청 취소 성공";
			break;
		}

		System.out.println(successMessage);

	}

	public void printGrade(List<GradeDTO> list) {

		System.out.println("========================================================================");
		System.out.println("강의명\t교수명\t학번\t학생명\t출석점수\t과제점수\t중간점수\t기말점수\t학점");

		for (GradeDTO grade : list)
			System.out.println(grade);

	}

	public void printLecture(List<LectureDTO> list) {

		System.out.println("=========================================================================");
		System.out.println("학과코드\t       강의번호\t    교수명\t 교수번호\t  강의명\t\t\t 수강학점\t   수강인원    정원인원     요일    시간");

		for (LectureDTO lecture : list)
			System.out.println(lecture);

	}

	public void printErrorMessage(String errorCode) {// 각 메소드에서 호출시케이스마다 추가하면서 하자

		String errorMessage = "";

		switch (errorCode) {
		case "selectLogin":
			errorMessage = "없는 아이디입니다.";
			break;
//		case "selectOne":
//			errorMessage = "메뉴 조회에 실패하셨습니다.";
//			break;
//		case "insert":
//			errorMessage = "신규 메뉴 등록에 실패하셨습니다.";
//			break;
		case "gradeCheck":
			errorMessage = "수강중인 강의가 없거나 학점 조회 기간이 아닙니다.";
			break;
		case "selectByProfNo":
			errorMessage = "강의중인 강의가 없습니다.";
			break;
		case "insertGrade":
			errorMessage = "학점 부여 실패";
			break;
		case "selectStudentList":
			errorMessage = "수강생이 없습니다.";
			break;
		case "selectGrade":
			errorMessage = "등록된 학점이 없습니다.";
			break;
		case "updateGrade":
			errorMessage = "수강중인 학생이 아닙니다.";
		case "enroll":
			errorMessage = "수강신청 실패";
			break;
		case "selectLecture":
			errorMessage = "수강신청한 강의가 없습니다.";
			break; 
		case "deleteEnroll":
			errorMessage = "수강신청 취소 실패";
			break;
//		case "delete":
//			errorMessage = "메뉴 삭제에 실패하셨습니다.";
//			break;
		}
		System.out.println("========================================================================");
		System.out.println(errorMessage);

	}

	public void printLogStu(StudentDTO id) {
		System.out.println(id);
	}

	public void printErrorLogStu(String string) {
		// TODO Auto-generated method stub
		
	}


}
