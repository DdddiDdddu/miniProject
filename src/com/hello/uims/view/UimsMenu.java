package com.hello.uims.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hello.uims.controller.Controller;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.service.LectureJugService;
import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.StudentDTO;
import com.hello.uims.model.service.LectureJugService;

public class UimsMenu {

	private static Scanner sc = new Scanner(System.in);
	private Controller con = new Controller();

	public void initialMenu() {

		label: do {

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
				logIn();
				break;
			case 2:
				signUp();
				break;
			case 9:
				System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");
				if ('y' == sc.next().toLowerCase().charAt(0)) {
					sc.close();
					break label;
				}
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	public void logIn() {
		// 학생용 교수용 나누나?? 나눌거면 메인메뉴도 교수용거 하나 만들어야겠다
		// 이거는 제대로 됬나 확인하려고 일단 임시로 이렇게 해둔거고 지수형이 추가해줘용
		System.out.println("=============로그인============");
		System.out.println("학생입니까? 1번");
		System.out.println("교수입니까? 2번");
		System.out.println("=========================");
		System.out.print("메뉴 선택 : ");

		int no = sc.nextInt();
		sc.nextLine();

		switch (no) {
		case 1:
			while (true) {
				StudentDTO student = con.selectLogin(inputStuId());

				if (student != null) {

					System.out.println("비밀번호를 입력하세요");

					if (student.getStudentPwd().equalsIgnoreCase(sc.nextLine())) {
						stuMainMenu();
						break;
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
				}
			}
			break;
		case 2:
			// con.profMainMenu();
			break;
		}
	}

	private HashMap<String, String> inputStuId() {

		HashMap<String, String> loginMap = new HashMap<>();
		System.out.println("아이디를 입력하세요");
		loginMap.put("studentId", sc.nextLine());

		return loginMap;

	}

	private void signUp() {
		// 지수형 회원가입 파트
		System.out.println("=============회원가입============");
		System.out.println("학생입니까? 1번");
		System.out.println("교수입니까? 2번");
		System.out.println("=========================");
		System.out.print("메뉴 선택 : ");

		int no = sc.nextInt();
		sc.nextLine();
		
		switch (no) {
		case 1:
			while (true) {
				HashMap<String, String> infoMap = new HashMap<>();
				
				System.out.println("===============================회원가입===================================");
				System.out.println("아이디를 설정하세요");
				infoMap.put("studentId", sc.nextLine());
				System.out.println("비밀번호를 설정하세요(특수문자 제외)");
				infoMap.put("studentPwd", sc.nextLine());
				System.out.println("이름을 입력하세요");
				infoMap.put("studentName", sc.nextLine());
				System.out.println("휴대전화번호를 입력하세요");
				infoMap.put("studentTelNo", sc.nextLine());
				
				con.insertStudent(infoMap);
				
				break;
				
				}
			
		case 2:
			while (true) {

				HashMap<String, String> infoMap = new HashMap<>();
			
				System.out.println("===============================회원가입===================================");
				System.out.println("아이디를 설정하세요");
				infoMap.put("professorId", sc.nextLine());
				System.out.println("비밀번호를 설정하세요(특수문자 제외)");
				infoMap.put("professorPwd", sc.nextLine());
				System.out.println("이름을 입력하세요");
				infoMap.put("professorName", sc.nextLine());
				System.out.println("휴대전화번호를 입력하세요");
				infoMap.put("professorTelNo", sc.nextLine());
				
				con.insertProfessor(infoMap);
				break;
			}
		}	
		
	}

	public void stuMainMenu() { // 학생용 메뉴 화면

		do {
			int no;

			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 마이페이지");
			System.out.println("2. 수강신청 메뉴");
			System.out.println("3. 학점조회");
			System.out.println("4. 강의평가");
			System.out.println("5. 로그아웃");
			System.out.println("========================================================================");
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
				con.selectGradeCheck(inputStudentNo());
				break;
			case 4:
				lectureJug();
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

	// 수강신청 메뉴
	public void enrollMenu() {

		do {
			int no;

			System.out.println("================================ 수강신청 =================================");
			System.out.println("1. 강의목록 조회");
			System.out.println("2. 수강신청");
			System.out.println("3. 수강신청 내역");
			System.out.println("4. 수강신청 취소");
			// 검색기능 강의명, 학과코드
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			no = sc.nextInt();
			sc.nextLine(); // 버퍼에서 엔터제거

			switch (no) {
			case 1:
				con.selectAllLecture(); // 수강신청 강의목록 조회
				break;

			case 2:
				con.enroll(inputEnroll());
				break;

			case 3:
				con.selectEnroll(inputStudentNo()); // 수강신청 내역
				break;

			case 4:
				con.deleteEnroll(inputEnroll());
				break;

			case 9:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

		} while (true);

	}

	// 학번 강의코드 입력
	public Map<String, String> inputEnroll() {

		Map<String, String> parameter = new HashMap<>();

		System.out.print("학번을 입력해주세요 : ");
		parameter.put("studentNo", sc.nextLine());

		System.out.print("강의코드를 입력해주세요 : ");
		parameter.put("lectureNo", sc.nextLine());

		return parameter;

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
				updateGrade(parameter);
				break;
			case 3:
				deleteGrade(parameter);
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

	private void insertGrade(Map<String, String> parameter) {

		ArrayList<EnrollmentDTO> enroll = con.selectStudentList(parameter);
		parameter.put("currNo", Integer.toString(enroll.size()));
		System.out.println("================================ 학생 목록 ================================");

//		HashMap<String, Integer> gradeMap = new HashMap<>();

		for (EnrollmentDTO enrollmentDTO : enroll) {
			System.out.println(enrollmentDTO);

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
			con.insertScores(parameter);
		}

		if (enroll != null && !enroll.isEmpty()) {
			con.inputFinGrade(parameter);
		}

	}

	private void updateGrade(Map<String, String> parameter) {

		con.selectGrade(parameter);

		parameter.put("studentNo", inputStudentNo().get("studentNo"));
		System.out.println("================================ 학점 수정 ================================");
		System.out.print("출석 점수를 입력하세요. : ");
		parameter.put("attScore", sc.nextLine());
		System.out.print("과제 점수를 입력하세요. : ");
		parameter.put("assScore", sc.nextLine());
		System.out.print("중간고사 점수를 입력하세요. : ");
		parameter.put("midScore", sc.nextLine());
		System.out.print("기말고사 점수를 입력하세요. : ");
		parameter.put("finScore", sc.nextLine());

		con.updateGrade(parameter);

	}

	private void deleteGrade(Map<String, String> parameter) {

		con.selectGrade(parameter);

		parameter.put("studentNo", inputStudentNo().get("studentNo"));
		System.out.println("================================ 학점 삭제 ================================");
		con.deleteGrade(parameter);

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

	private void lectureJug() {
		LectureJugService lectureJugService = new LectureJugService();

		do {

			int no;

			System.out.println("================================ 강의평가 =================================");
			System.out.println("1. 교수 강의 평가");
			System.out.println("2. 평가 수정");
			System.out.println("3. 평가 삭제");
			System.out.println("4. 평가조회");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");

			System.out.println("메뉴 선택 : ");

			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
//			case 1: updateJudge(parameter); break;
			case 2: // lectureJugService.modifyJudge(inputChangeJudge()); break;
			case 3: // lectureJugService.deleteJudge(deleteJudge()); break;
			case 4: // lectureJugService.selectJudge(); break;

				System.out.print("메뉴 선택 : ");

				no = sc.nextInt();
				sc.nextLine();

				switch (no) {
				case 1:
//				lectureJugService.judgementProfStudy(inputJudge());
					break;
				case 2: // lectureJugService.modifyJudge(inputChangeJudge()); break;
				case 3: // lectureJugService.deleteJudge(deleteJudge()); break;
				case 4: // lectureJugService.judgementShow(showJudge()); break;

				case 9:
					stuMainMenu();
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}
		} while (true);

	}

	private void updateJudge(Map<String, String> parameter) {

		ArrayList<LectureJugDTO> lectureJugDTO = con.selectLectureNo(parameter);

		double avg = 0.0;

		for (LectureJugDTO lectureJug : lectureJugDTO) {
			System.out.println(lectureJugDTO);
		}

		System.out.println("질문에 알맞게 점수를 입력해주세요");
		System.out.println("강의 목표와 강의내용이 강좌명과 부합하는가? (1 ~ 5점으로 입력해주세요)");
		int score1 = sc.nextInt();
		System.out.println("강의내용은 해당영역의 이론과 지식을 적절히 담고 있는가? (1 ~ 5점으로 입력해주세요)");
		int score2 = sc.nextInt();
		System.out.println("담당교수는 학생들의 이해도를 높이기 위하여 최선을 다하였는가? (1 ~ 5점으로 입력해주세요)");
		int score3 = sc.nextInt();
		System.out.println("담당교수는 열성적이고 성실하게 강의에 임하였는가? (1 ~ 5점으로 입력해주세요)");
		int score4 = sc.nextInt();
		System.out.println("학업평가는 강의내용이 적절히 반영되어 과목의 이해정도를 잘 평가하였 는가? (1 ~ 5점으로 입력해주세요)");
		int score5 = sc.nextInt();
		sc.nextLine();

		avg = (double) (score1 + score2 + score3 + score4 + score5) / 5;

		String avgs = Double.toString(avg);

		parameter.put("StuJugScore", avgs);

		System.out.println("교수님에게 할 말 한 문장으로 남겨주세요.");
		parameter.put("StuOneJug", sc.nextLine());

//		con.inputJudgement(parameter);

	private void showJudge(Map<String, String> parameter) {
		con.selectJudgement(parameter);
		
	}
	
	private void viewJudgement(Map<String, String> inputProfNo) {
		
		while(true) {
			con.selectByProfNo(inputProfNo);
			System.out.print("강의 평가 조회 하고 싶은 ");
			inputProfNo.put("lectureNo", inputLectureNo().get("lectureNo"));
			
			con.selectJudmentProf(inputProfNo);
			
			break;
		}
		
	}

}
