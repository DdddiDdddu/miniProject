package com.hello.uims.view;

import java.util.Scanner;

public class UimsMenu {

	Scanner sc = new Scanner(System.in);

	public void loginMenu() {

		do {

			int no;
			System.out.println("============================ 학사 통합 관리 시스템 ============================");
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
				break;

			case 2:
//				signIn();
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

}
