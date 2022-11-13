package com.hello.uims.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hello.uims.controller.Controller;

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
//				login();
				mainMenu();
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

	private void login() {// 학생용 교수용 나누나?? 나눌거면 메인메뉴도 교수용거 하나 만들어야겠다
		// TODO Auto-generated method stub

	}

	private void signIn() {
		// TODO Auto-generated method stub

	}

	public void mainMenu() {

		do {
			int no;
			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 마이페이지");
			System.out.println("2. 수강신청");
			System.out.println("3. 학점조회/부여");
			System.out.println("4. 강의평가");
			System.out.println("5. 로그아웃");
			System.out.println("9. 프로그램 종료");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
//				con.myPage();
				break;
			case 2:
//				con.enroll();
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

	private static Map<String, String> inputStudentNo() {

		System.out.print("학번을 입력하세요. : ");
		String studentNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("studentNo", studentNo);

		return parameter;
	}

}
