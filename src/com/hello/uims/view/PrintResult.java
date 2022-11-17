package com.hello.uims.view;

import java.util.ArrayList;
import java.util.List;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class PrintResult {

	public void printSuccessMessage(String successCode) {

		String successMessage = "";

		switch (successCode) {
		case "insertScores":
			successMessage = "점수 입력에 성공하셨습니다.";
			break;
		case "updateFinGrade":
			successMessage = "학점 부여 성공";
			break;
		case "updateGrade":
			successMessage = "학점 수정에 성공하셨습니다.";
			break;
		case "deleteGrade":
			successMessage = "학점 삭제에 성공하셨습니다.";
			break;

		// 수강신청 파트
		case "enrollSuccess":
			successMessage = "수강신청 성공";
			break;
		case "deleteEnroll":
			successMessage = "수강신청 취소 성공";
			break; // 수강신청 파트 끝

		case "insertStudent":
			successMessage = "회원가입이 되었습니다.";
			break;
		case "modifyJudgement":
			successMessage = "강의 평가 수정에 성공하셨습니다.";
			break;
		case "deleteJudgement":
			successMessage = "강의 평가 삭제에 성공했습니다.";
			break;
		case "insertProfessor":
			successMessage = "회원가입이 되었습니다.";
			break;
		case "updateStuId":
			successMessage = "정보가 수정되었습니다.";
			break;
		case "updateProfId":
			successMessage = "정보가 수정되었습니다.";
			break;
		}

		System.out.println(successMessage);
	}

	public void printGrade(List<GradeDTO> list) {

		System.out.println("================================ 학점 목록 ================================");
		System.out.println("강의명     교수명  학번       학생명 출석 과제 중간 기말 학점");
		for (GradeDTO grade : list)
			System.out.println(grade);
	}

	public void printLecture(List<LectureDTO> list) {

		System.out.println("================================ 강의 목록 ================================");
		System.out.println("학과코드 강의번호 교수명  교수번호 강의명     수강학점  (수강인원/정원인원) 요일    시간");
		for (LectureDTO lecture : list)
			System.out.println(lecture);
	}

	public void printJudgement(List<LectureJugDTO> list) {
		System.out.println("================================ 강의 평가 목록 ================================");
		System.out.println("강의평가번호\t강의번호\t  교수번호\t    학번\t    평가점수\t   한줄평가");

		for (LectureJugDTO lectureJug : list)
			System.out.println(lectureJug);
	}

	public void printStudent(ArrayList<StudentDTO> list) {
		System.out.println("================================ 학생 목록 ================================");
		System.out.println("학생번호    학과코드 아이디     비밀번호 이름   주소   전화번호       이메일  입학일        재학상태");
		for (StudentDTO student : list)
			System.out.println(student);
	}

	public void printJudgementProf(ArrayList<LectureJugDTO> list) {

		System.out.println("================================ 강의 평가 목록 ================================");
		System.out.println("강의평가번호\t강의번호\t  교수번호\t    학번\t    평가점수\t   한줄평가");
		for (LectureJugDTO lectureJug : list)
			System.out.println(lectureJug);

		System.out.println("강의 평가 조회가 완료됐습니다. 통합관리시스템으로 넘어갑니다.");

	}

	public void printErrorMessage(String errorCode) {// 각 메소드에서 호출시케이스마다 추가하면서 하자

		String errorMessage = "";

		switch (errorCode) {
		case "selectLogin":
			errorMessage = "없는 아이디입니다.";
			break;
		case "gradeCheck":
			errorMessage = "수강중인 강의가 없거나 학점 조회 기간이 아닙니다.";
			break;
		case "selectByProfNo":
			errorMessage = "강의중인 강의가 없습니다.";
			break;
		case "insertScores":
			errorMessage = "이미 점수를 부여한 학생입니다.";
			break;
		case "insertScores2":
			errorMessage = "수강중인 학생이 아닙니다.";
			break;
		case "updateFinGrade":
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
			break;
		case "deleteGrade":
			errorMessage = "수강중인 학생이 아닙니다.";
			break;

		// 수강신청 파트
		case "enrollFail":
			errorMessage = "수강신청 실패";
			break;
		case "selectEnroll":
			errorMessage = "수강신청한 강의가 없습니다.";
			break;
		case "totalCreditOver":
			errorMessage = "수강신청 실패 : 수강학점 초과";
			break;
		case "timeDuplication":
			errorMessage = "수강신청 실패 : 시간이 중복되는 강의";
			break;
		case "duplication":
			errorMessage = "수강신청 실패 : 이미 수강신청한 강의";
			break;
		case "selectAllLecture":
			errorMessage = "강의목록 조회 실패 : 데이터가 존재하지 않습니다";
			break;
		case "deleteEnroll":
			errorMessage = "수강신청 취소 실패";
			break;
		case "searchLectureByLectureNameOrProfName":
			errorMessage = "검색결과가 존재하지 않습니다.";
			break; // 수강신청 파트 끝

		case "modifyJudgement":
			errorMessage = "강의 평가 수정 실패.";
			break;
		case "selectBystudentNo":
			errorMessage = "수강중인 강의가 없습니다.";
			break;
		case "selectJudgement":
			errorMessage = "평가한 강의 평가가 없습니다.";
			break;
		case "deleteJudgement":
			errorMessage = "강의 평가 삭제 실패.";
			break;
		case "insertStudent":
			errorMessage = "회원가입이 실패 했습니다";
			break;
		case "insertProfessor":
			errorMessage = "회원가입이 실패 했습니다";
			break;
		case "selectJudgementProf":
			errorMessage = "평가된 강의 평가가 없습니다.";
			break;
		case "error":
			errorMessage = "시스템 에러 발생, 관리자에게 문의하세요.";
			break;
		}
		System.out.println("========================================================================");
		System.out.println(errorMessage);
	}

//	public void printLogStu(StudentDTO id) {
//		System.out.println(id);
//	}
//
//	public void printErrorLogStu(String string) {
//
//	}

	public void printProfessor(ArrayList<ProfessorDTO> list) {

		System.out.println("================================ 교수 목록 ================================");
		System.out.println("교수번호 학과코드 아이디   비밀번호 이름   주소\t       전화번호       이메일           입사일 재직상태");
		for (ProfessorDTO professor : list)
			System.out.println(professor);
		
	}

}
