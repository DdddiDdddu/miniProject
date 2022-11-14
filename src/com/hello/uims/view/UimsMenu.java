package com.hello.uims.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hello.uims.controller.Controller;
import com.hello.uims.model.DTO.EnrollmentDTO;

public class UimsMenu {

	private static Scanner sc = new Scanner(System.in);
	private Controller con = new Controller();

	public void initialMenu() {

		do {

			int no;
			
			System.out.println("============================ 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 프로그램 종료");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
				login();
				break;
				
			case 2:
				signIn();
				break;
				
			case 9:
				System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");
				if ('y' == sc.next().toLowerCase().charAt(0)) {
					sc.close();
					return;
				}
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

		} while (true);

	}

	private void login() {
		// 학생용 교수용 나누나?? 나눌거면 메인메뉴도 교수용거 하나 만들어야겠다
		// 이거는 제대로 됬나 확인하려고 일단 임시로 이렇게 해둔거고 지수형이 추가해줘용
		int no = sc.nextInt();
		sc.nextLine();
		
		System.out.println("학생 : 1");
		System.out.println("교수 : 2");

		switch (no) {
		case 1:
			stuMainMenu();
			break;
			
		case 2:
			profMainMenu();
			break;
		}

	}

	private void signIn() {
		// 지수형 회원가입 파트
	}

	public void stuMainMenu() { // 학생용 메뉴 화면

		do {
			int no;
			
			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 마이페이지");
			System.out.println("2. 수강신청");
			System.out.println("3. 학점조회");
			System.out.println("4. 강의평가");
			System.out.println("5. 로그아웃");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
//				con.myPage();
				break;
				
			case 2:
				enrollMenu();
				break;
				
			case 3:
				con.gradeCheck(inputStudentNo());
				break;
				
			case 4:
//				con.lectureJug();
				break;
				
			case 5:
				initialMenu();
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		} while (true);

	}

	private void profMainMenu() { // 교수용 메뉴 화면
		// 이거도 일단 임시로 복붙한거라 다들 자기 파트 부분 수정해 죠 해 줘
		do {
			int no;
			
			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 지수형");
			System.out.println("2. 학점관리");
			System.out.println("3. 종호");
			System.out.println("9. 로그아웃");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
//				con.myPage();
				break;
				
			case 2:
				manageGrade(inputProfNo());
				break;
				
			case 3:
//				con.lectureJug();
				break;
				
			case 9:
				initialMenu();
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		} while (true);

	}
	

	private void enrollMenu() {

		do {

			int no;
			
			System.out.println("================================ 수강신청 =================================");
			System.out.println("1. 수강신청");
			System.out.println("2. 수강신청 내역");
			System.out.println("3. 수강신청 취소");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
				con.selectLecture();
//				enroll();
				break;
				
			case 2:
//				con.selectEnroll();
				break;
				
			case 3:
//				con.deleteEnroll(inputEnrollId());
				break;
				
			case 9:
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

		} while (true);
		
	}

	private void manageGrade(Map<String, String> parameter) { // 교수 학점 관리 메뉴

		con.selectByProfNo(parameter);
		parameter.put("lectureNo", inputLectureNo().get("lectureNo"));

		int no;

		do {
			System.out.println("================================ 학점 관리 ================================");
			System.out.println("1. 학점 부여");
			System.out.println("2. 학점 수정");
			System.out.println("3. 학점 삭제");
			System.out.println("4. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
				insertGrade(parameter);
				break;
				
			case 2:
//				con.updateGrade(inputLectureNo());
				break;
				
			case 3:
//				con.deleteGrade(inputLectureNo());
				break;
				
			case 4:
				profMainMenu();
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		} while (true);

	}

	private Map<String, String> inputStudentNo() {

		System.out.println("=========================================================================");
		System.out.print("학번을 입력하세요. : ");
		String studentNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("studentNo", studentNo);

		return parameter;

	}

	private Map<String, String> inputProfNo() {

		System.out.println("=========================================================================");
		System.out.print("교수 번호를 입력하세요. : ");
		String profNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("profNo", profNo);

		return parameter;

	}

	private Map<String, String> inputLectureNo() {

		System.out.println("=========================================================================");
		System.out.print("강의 번호를 입력하세요. : ");
		String lectureNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("lectureNo", lectureNo);

		return parameter;

	}

	private void insertGrade(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> enroll = con.selectStuGrade(parameter);


			for (EnrollmentDTO enrollmentDTO : enroll) {
					System.out.println(enrollmentDTO);
			}
			System.out.print("학번을 입력하세요. : ");
			parameter.put("studentNo", sc.next());
			
			System.out.print("출석 점수를 입력하세요. : ");
			parameter.put("attScore", sc.next());
			
			System.out.print("과제 점수를 입력하세요. : ");
			parameter.put("assScore", sc.next());
			
			System.out.print("중간 점수를 입력하세요. : ");
			parameter.put("midScore", sc.next());
			
			System.out.print("기말 점수를 입력하세요. : ");
			parameter.put("finScore", sc.next());
			con.insertGrade(parameter);
			
			con.inputFinGrade(parameter);
			
		}

	}

