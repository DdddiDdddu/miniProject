package com.hello.uims.view;

import java.util.ArrayList;
import java.util.List;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;

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
			successMessage = "학점 추가 성공.";
			break;
//		case "update":
//			successMessage = "메뉴 수정에 성공하셨습니다.";
//			break;
//		case "delete":
//			successMessage = "메뉴 삭제에 성공하셨습니다.";
//			break;
		}

		System.out.println(successMessage);

	}

	public void printGrade(List<GradeDTO> list) {

		System.out.println("========================================================================");
		System.out.println("강의명     교수명  학번      학생명  출석점수 과제점수 중간점수 기말점수 학점");
		for (GradeDTO grade : list) {
			System.out.println(grade);
		}

	}

	public void printLecture(List<LectureDTO> list) {

		System.out.println("========================================================================");
		System.out.println("강의번호  학과코드  교수번호  강의명  수강학점  수강인원  정원인원  요일  시간");
		for (LectureDTO lecture : list) {
			System.out.println(lecture);
		}

	}

	public void printErrorMessage(String errorCode) {// 각 메소드에서 호출시케이스마다 추가하면서 하자

		String errorMessage = "";

		switch (errorCode) {
//		case "selectList":
//			errorMessage = "메뉴 목록 조회에 실패하셨습니다.";
//			break;
//		case "selectOne":
//			errorMessage = "메뉴 조회에 실패하셨습니다.";
//			break;
//		case "insert":
//			errorMessage = "신규 메뉴 등록에 실패하셨습니다.";
//			break;
		case "gradeCheck":
			errorMessage = "수강중인 강의가 없습니다.";
			break;
		case "selectByProfNo":
			errorMessage = "강의중인 강의가 없습니다.";
			break;
		case "insertGrade":
			errorMessage = "학점 부여 실패";
			break;
//		case "delete":
//			errorMessage = "메뉴 삭제에 실패하셨습니다.";
//			break;
		}
		System.out.println("========================================================================");
		System.out.println(errorMessage);

	}

}
