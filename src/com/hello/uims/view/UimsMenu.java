package com.hello.uims.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.hello.uims.controller.Controller;
import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.DTO.LectureJugDTO;
import com.hello.uims.model.DTO.ProfessorDTO;
import com.hello.uims.model.DTO.StudentDTO;

public class UimsMenu {

	private static Scanner sc = new Scanner(System.in);
	private Controller con = new Controller();

	// 초기 메뉴
	public void initialMenu() {

		do {
			System.out.println("============================ 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 프로그램 종료");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				login();
				break;
			case "2":
				signUp();
				break;
			case "9":
				System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");
				if ('y' == sc.nextLine().toLowerCase().charAt(0)) {
					sc.close();
					return;
				}
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 로그인
	private void login() {

		System.out.println("================================= 로그인 =================================");
		System.out.println("학생입니까? 1번");
		System.out.println("교수입니까? 2번");
		System.out.println("=========================================================================");
		System.out.print("메뉴 선택 : ");

		String menu = sc.nextLine();

		switch (menu) {
		case "1":
			while (true) {
				StudentDTO student = con.selectLoginStudent(inputStuId());

				if (student != null) {
					System.out.println("비밀번호를 입력하세요(대소문자 구분합니다)");

					if (student.getStudentPwd().equals(sc.nextLine())) {
						stuMainMenu(student);
						break;
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
				}
			}
			break;
		case "2":
			while (true) {
				ProfessorDTO professor = con.selectLoginProfessor(inputProfId());

				if (professor != null) {
					System.out.println("비밀번호를 입력하세요(대소문자 구분합니다)");
					if (professor.getProfPwd().equals(sc.nextLine())) {
						profMainMenu(professor);
						break;
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
				}
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	// 교수 아이디 입력받기
	private HashMap<String, String> inputProfId() {

		HashMap<String, String> loginMap = new HashMap<>();
		System.out.println("아이디를 입력하세요");
		loginMap.put("profId", sc.nextLine());

		return loginMap;
	}

	// 학생 아이디 입력받기
	private HashMap<String, String> inputStuId() {

		HashMap<String, String> loginMap = new HashMap<>();
		System.out.println("아이디를 입력하세요");
		loginMap.put("studentId", sc.nextLine());

		return loginMap;
	}

	// 회원가입
	private void signUp() {

		System.out.println("================================= 회원가입 ================================");
		System.out.println("학생입니까? 1번");
		System.out.println("교수입니까? 2번");
		System.out.println("=========================================================================");
		System.out.print("메뉴 선택 : ");

		String menu = sc.nextLine();

		switch (menu) {
		case "1":
			HashMap<String, String> infoStuMap = new HashMap<>();

			System.out.println("================================= 회원가입 ================================");
			System.out.println("아이디를 설정하세요");
			infoStuMap.put("studentId", sc.nextLine());
			System.out.println("비밀번호를 설정하세요(특수문자 제외)");
			infoStuMap.put("studentPwd", sc.nextLine());
			System.out.println("이름을 입력하세요");
			infoStuMap.put("studentName", sc.nextLine());
			System.out.println("휴대전화번호를 입력하세요");
			infoStuMap.put("studentTelNo", sc.nextLine());

			con.insertStudent(infoStuMap);
			break;
		case "2":
			HashMap<String, String> infoProMap = new HashMap<>();

			System.out.println("================================= 회원가입 ================================");
			System.out.println("아이디를 설정하세요");
			infoProMap.put("profId", sc.nextLine());
			System.out.println("비밀번호를 설정하세요(특수문자 제외)");
			infoProMap.put("profPwd", sc.nextLine());
			System.out.println("이름을 입력하세요");
			infoProMap.put("profName", sc.nextLine());
			System.out.println("휴대전화번호를 입력하세요");
			infoProMap.put("profTelNo", sc.nextLine());

			con.insertProfessor(infoProMap);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	// 학생용 메뉴 화면
	private void stuMainMenu(StudentDTO student) {

		HashMap<String, String> sm = new HashMap<>();
		sm.put("studentNo", String.valueOf(student.getStudentNo()));

		do {
			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 마이페이지");
			System.out.println("2. 수강신청 메뉴");
			System.out.println("3. 학점조회");
			System.out.println("4. 강의평가");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				myPageStudent(sm);
				break;
			case "2":
				enrollMenu(sm);
				break;
			case "3":
				con.selectGradeCheck(sm);
				break;
			case "4":
				lectureJug(sm);
				break;
			case "9":
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 학생 마이페이지
	private void myPageStudent(HashMap<String, String> sm) {

		while (true) {
			System.out.println("=========================== 마이페이지 ===========================");
			System.out.println("1. 조회");
			System.out.println("2. 수정");
			System.out.println("3. 탈퇴");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				con.selectStuId(sm);
				break;
			case "2":
				updateStuId(sm);
				break;
			case "3":
				System.out.println("정말 탈퇴하시겠습니까? (y/n)");
				if ('y' == sc.nextLine().toLowerCase().charAt(0)) {
					con.deleteStuId(sm);
					return;
				} else {
					break;
				}
			case "9":
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	// 학생 개인정보 수정
	private void updateStuId(Map<String, String> parameter) {

		System.out.println("수정할 비밀번호를 입력하세요");
		parameter.put("studentPwd", sc.nextLine());
		System.out.println("수정할 주소를 입력하세요");
		parameter.put("address", sc.nextLine());
		System.out.println("수정할 전화번호를 입력하세요");
		parameter.put("studentTelNo", sc.nextLine());
		System.out.println("수정할 이메일을 입력하세요");
		parameter.put("email", sc.nextLine());

		con.updateStuId(parameter);
	}

	// 교수용 메뉴 화면
	private void profMainMenu(ProfessorDTO professor) {

		HashMap<String, String> pm = new HashMap<>();
		pm.put("profNo", String.valueOf(professor.getProfNo()));

		do {
			System.out.println("=========================== 학사 통합 관리 시스템 ===========================");
			System.out.println("1. 마이페이지");
			System.out.println("2. 학점관리");
			System.out.println("3. 강의평가조회");
			System.out.println("9. 로그아웃");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				myPageProfessor(pm);
				break;
			case "2":
				manageGrade(pm);
				break;
			case "3":
				viewJudgement(pm);
				break;
			case "9":
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 교수용 마이페이지
	private void myPageProfessor(HashMap<String, String> pm) {

		while (true) {
			System.out.println("=========================== 마이페이지 ===========================");
			System.out.println("1. 조회");
			System.out.println("2. 수정");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			int no;
			no = sc.nextInt();
			sc.nextLine();

			switch (no) {
			case 1:
				con.selectProfId(pm);
				break;
			case 2:
				updateProfId(pm);
				break;
			case 9:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	// 교수 개인정보 수정
	private void updateProfId(Map<String, String> parameter) {

		System.out.println("수정할 비밀번호를 입력하세요");
		parameter.put("profPwd", sc.nextLine());
		System.out.println("수정할 주소를 입력하세요");
		parameter.put("address", sc.nextLine());
		System.out.println("수정할 전화번호를 입력하세요");
		parameter.put("profTelNo", sc.nextLine());
		System.out.println("수정할 이메일을 입력하세요");
		parameter.put("email", sc.nextLine());

		con.updateProfId(parameter);
	}

	// 수강신청 메뉴
	private void enrollMenu(HashMap<String, String> sm) {

		do {
			System.out.println("================================ 수강신청 =================================");
			System.out.println("1. 강의목록 조회");
			System.out.println("2. 수강신청");
			System.out.println("3. 수강신청 내역");
			System.out.println("4. 수강신청 취소");
			System.out.println("5. 강의목록 검색");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				con.selectAllLecture(); // 강의목록 조회
				break;
			case "2":
				con.enroll(inputLectureNo(sm)); // 수강신청
				break;
			case "3":
				con.selectEnroll(sm); // 수강신청 내역
				break;
			case "4":
				con.deleteEnroll(inputLectureNo(sm)); // 수강신청 취소
				break;
			case "5":
				con.searchLectureByLectureNameOrProfName(inputSearchCriteriaMap()); // 강의목록 검색
				break;
			case "9":
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 강의목록 검색 분류 입력
	private Map<String, String> inputSearchCriteriaMap() {

		Map<String, String> criteria = new HashMap<>();

		while (true) {
			System.out.println("검색할 조건을 입력하세요(lectureName or profName) : ");
			String condition = sc.nextLine();

			if ("lectureName".equals(condition)) {

				System.out.print("검색할 강의명을 입력하세요 : ");
				String lectureNameValue = sc.nextLine();

				criteria.put("lectureNameValue", lectureNameValue);
				break;

			} else if ("profName".equals(condition)) {

				System.out.print("검색할 교수명을 입력하세요 : ");
				String profNameValue = sc.nextLine();

				criteria.put("profNameValue", profNameValue);
				break;

			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		return criteria;
	}

	// 교수 학점 관리 메뉴
	private void manageGrade(Map<String, String> parameter) {

		do {
			con.selectByProfNo(parameter);

			System.out.println("================================ 학점 관리 ================================");
			System.out.println("1. 학점 조회");
			System.out.println("2. 학점 부여");
			System.out.println("3. 학점 수정");
			System.out.println("4. 학점 삭제");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");
			System.out.print("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				parameter.put("lectureNo", inputLectureNo().get("lectureNo"));
				con.selectGrade(parameter);
				break;
			case "2":
				parameter.put("lectureNo", inputLectureNo().get("lectureNo"));
				insertScores(parameter);
				break;
			case "3":
				parameter.put("lectureNo", inputLectureNo().get("lectureNo"));
				updateGrade(parameter);
				break;
			case "4":
				parameter.put("lectureNo", inputLectureNo().get("lectureNo"));
				deleteGrade(parameter);
				break;
			case "9":
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 교수 학점관리 - 학점 입력
	private void insertScores(Map<String, String> parameter) {

		String attScore;
		String assScore;
		String midScore;
		String finScore;

		if (parameter.get("studentNo") != null && !parameter.get("studentNo").isEmpty()) {
			parameter.remove("studentNo");
		}

		ArrayList<EnrollmentDTO> enroll = con.selectStudentList(parameter);

		int index1 = 0;
		int size = enroll.size();

		while (index1 < size) {
			System.out.println("================================ 수강생 목록 ================================");
			for (int i = 0; i < size; i++) {
				if (parameter.containsKey("studentNo")) {
					if (Integer.parseInt(parameter.get("studentNo")) != enroll.get(i).getStudentNo()) {
						System.out.println("학번 : " + enroll.get(i).getStudentNo());
					} else {
						System.out.println(" < 여기까지 입력 완료 > ");
					}
				} else {
					System.out.println("학번 : " + enroll.get(i).getStudentNo());
				}
			}
			System.out.println("=========================================================================");
			System.out.print("순서대로 학점을 입력할 학생의 ");
			parameter.put("studentNo", inputStudentNo().get("studentNo"));
			System.out.println("=========================================================================");
			while (true) {
				System.out.print("출석 점수를 입력하세요. (0 ~ 10) : ");
				attScore = sc.nextLine();
				if (Integer.parseInt(attScore) < 0 || Integer.parseInt(attScore) > 10) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 10의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("attScore", attScore);
			while (true) {
				System.out.print("과제 점수를 입력하세요. (0 ~ 30) : ");
				assScore = sc.nextLine();
				if (Integer.parseInt(assScore) < 0 || Integer.parseInt(assScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("assScore", assScore);
			while (true) {
				System.out.print("중간고사 점수를 입력하세요. (0 ~ 30) : ");
				midScore = sc.nextLine();
				if (Integer.parseInt(midScore) < 0 || Integer.parseInt(midScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("midScore", midScore);
			while (true) {
				System.out.print("기말고사 점수를 입력하세요. (0 ~ 30) : ");
				finScore = sc.nextLine();
				if (Integer.parseInt(finScore) < 0 || Integer.parseInt(finScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("finScore", finScore);
			con.insertScores(parameter);

			System.out.println("=========================================================================");
			System.out.println("학점을 추가로 입력하시겠습니까? (y/n)");
			if ('y' == sc.nextLine().toLowerCase().charAt(0)) {
				index1++;
				if (index1 == size) {
					con.updateFinGrade(parameter);
					System.out.println("모든 학생의 학점을 부여했습니다. 학점 관리 메뉴로 돌아갑니다.");
					break;
				}
				continue;
			} else {
				con.updateFinGrade(parameter);
				System.out.println("학점 관리 메뉴로 돌아갑니다.");
				break;
			}
		}
	}

	// 교수 학점관리 - 학점 수정
	private void updateGrade(Map<String, String> parameter) {

		String attScore;
		String assScore;
		String midScore;
		String finScore;

		while (true) {
			ArrayList<GradeDTO> list = con.selectGrade(parameter);

			if (list != null && !list.isEmpty()) {
				System.out.println("=========================================================================");
				System.out.print("수정할 학생의 ");
				parameter.put("studentNo", inputStudentNo().get("studentNo"));
			} else {
				break;
			}
			System.out.println("================================ 학점 수정 ================================");
			while (true) {
				System.out.print("출석 점수를 입력하세요. (0 ~ 10) : ");
				attScore = sc.nextLine();
				if (Integer.parseInt(attScore) < 0 || Integer.parseInt(attScore) > 10) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 10의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("attScore", attScore);
			while (true) {
				System.out.print("과제 점수를 입력하세요. (0 ~ 30) : ");
				assScore = sc.nextLine();
				if (Integer.parseInt(assScore) < 0 || Integer.parseInt(assScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("assScore", assScore);
			while (true) {
				System.out.print("중간고사 점수를 입력하세요. (0 ~ 30) : ");
				midScore = sc.nextLine();
				if (Integer.parseInt(midScore) < 0 || Integer.parseInt(midScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("midScore", midScore);
			while (true) {
				System.out.print("기말고사 점수를 입력하세요. (0 ~ 30) : ");
				finScore = sc.nextLine();
				if (Integer.parseInt(finScore) < 0 || Integer.parseInt(finScore) > 30) {
					System.out.println("잘못된 값을 입력했습니다. 0 ~ 30의 점수를 입력해주세요.");
				} else {
					break;
				}
			}
			parameter.put("finScore", finScore);

			con.updateGrade(parameter);

			System.out.println("추가로 수정하시겠습니까? (y/n)");
			if ('y' == sc.nextLine().toLowerCase().charAt(0)) {
				continue;
			} else {
				con.updateFinGrade(parameter);
				System.out.println("학점 관리 메뉴로 돌아갑니다.");
				break;
			}
		}
	}

	// 교수 학점관리 - 학점 삭제
	private void deleteGrade(Map<String, String> parameter) {

		while (true) {
			ArrayList<GradeDTO> list = con.selectGrade(parameter);

			if (list != null && !list.isEmpty()) {
				System.out.println("=========================================================================");
				System.out.print("학점을 삭제할 학생의 ");
				parameter.put("studentNo", inputStudentNo().get("studentNo"));
			} else {
				break;
			}

			con.deleteGrade(parameter);

			System.out.println("추가로 삭제하시겠습니까? (y/n)");
			if ('y' == sc.nextLine().toLowerCase().charAt(0)) {
				continue;
			} else {
				System.out.println("학점 관리 메뉴로 돌아갑니다.");
				con.updateFinGrade(parameter);
				break;
			}
		}
	}

	// 강의평가 메뉴
	private void lectureJug(Map<String, String> parameter) {

		do {
			con.selectEnroll(parameter);

			System.out.println("================================ 강의평가 =================================");
			System.out.println("1. 교수 강의 평가");
			System.out.println("2. 평가 수정");
			System.out.println("3. 평가 삭제");
			System.out.println("4. 평가조회");
			System.out.println("9. 돌아가기");
			System.out.println("=========================================================================");

			System.out.println("메뉴 선택 : ");

			String menu = sc.nextLine();

			switch (menu) {

			case "1":
				insertJudge(parameter);
				break;
			case "2":
				modifyJudge(parameter);
				break;
			case "3":
				deleteJudge(parameter);
				break;
			case "4":
				showJudge(parameter);
				break;
			case "9":
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 학생 강의평가 - 입력
	private void insertJudge(Map<String, String> parameter) {
		System.out.println("=========================================================================");
		System.out.print("강의 평가할 교수의 ");
		parameter.put("profNo", inputProfNo().get("profNo"));
		System.out.println("=========================================================================");
		System.out.print("강의 평가할 ");
		parameter.put("lectureNo", inputLectureNo().get("lectureNo"));

		int score1, score2, score3, score4, score5 = 0;
		double avg = 0.0;

		System.out.println("질문에 알맞게 점수를 입력해주세요");
		while (true) {
			System.out.println("강의 목표와 강의내용이 강좌명과 부합하는가? (1 ~ 5점으로 입력해주세요)");
			score1 = sc.nextInt();
			if (score1 <= 0 || score1 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {

			System.out.println("강의내용은 해당영역의 이론과 지식을 적절히 담고 있는가? (1 ~ 5점으로 입력해주세요)");
			score2 = sc.nextInt();
			if (score2 <= 0 || score2 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("담당교수는 학생들의 이해도를 높이기 위하여 최선을 다하였는가? (1 ~ 5점으로 입력해주세요)");
			score3 = sc.nextInt();
			if (score3 <= 0 || score3 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("담당교수는 열성적이고 성실하게 강의에 임하였는가? (1 ~ 5점으로 입력해주세요)");
			score4 = sc.nextInt();
			if (score4 <= 0 || score4 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("학업평가는 강의내용이 적절히 반영되어 과목의 이해정도를 잘 평가하였 는가? (1 ~ 5점으로 입력해주세요)");
			score5 = sc.nextInt();
			if (score5 <= 0 || score5 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}

		sc.nextLine();

		avg = (double) (score1 + score2 + score3 + score4 + score5) / 5;

		String avgs = Double.toString(avg);

		parameter.put("stuJugScore", avgs);

		System.out.println("교수님에게 할 말 한 문장으로 남겨주세요.");
		parameter.put("stuOneJug", sc.nextLine());

		System.out.println("평가 점수의 평균은 " + avg + "입니다.");
		con.inputJudgement(parameter);

	}

	// 학생 강의평가 - 수정
	private void modifyJudge(Map<String, String> parameter) {
		double avg = 0.0;
		int score1, score2, score3, score4, score5 = 0;
		while (true) {

			ArrayList<LectureJugDTO> list = con.selectJudgement(parameter);
			if (list != null && !list.isEmpty()) {
				System.out.println("=========================================================================");
				System.out.print("강의 평가 수정할 ");
				parameter.put("lectureNo", inputLectureNo().get("lectureNo"));
			} else {
				break;
			}
			break;

		}
		System.out.println("질문에 알맞게 점수를 입력해주세요");
		while (true) {
			System.out.println("강의 목표와 강의내용이 강좌명과 부합하는가? (1 ~ 5점으로 입력해주세요)");
			score1 = sc.nextInt();
			if (score1 <= 0 || score1 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("강의내용은 해당영역의 이론과 지식을 적절히 담고 있는가? (1 ~ 5점으로 입력해주세요)");
			score2 = sc.nextInt();
			if (score2 <= 0 || score2 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("담당교수는 학생들의 이해도를 높이기 위하여 최선을 다하였는가? (1 ~ 5점으로 입력해주세요)");
			score3 = sc.nextInt();
			if (score3 <= 0 || score3 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("담당교수는 열성적이고 성실하게 강의에 임하였는가? (1 ~ 5점으로 입력해주세요)");
			score4 = sc.nextInt();
			if (score4 <= 0 || score4 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("학업평가는 강의내용이 적절히 반영되어 과목의 이해정도를 잘 평가하였 는가? (1 ~ 5점으로 입력해주세요)");
			score5 = sc.nextInt();
			if (score5 <= 0 || score5 >= 6) {
				System.out.println("1 ~ 5점으로 다시 입력해주세요");
			} else {
				break;
			}
		}

		sc.nextLine();

		avg = (double) (score1 + score2 + score3 + score4 + score5) / 5;

		String avgs = Double.toString(avg);

		parameter.put("stuJugScore", avgs);

		System.out.println("교수님에게 할 말 한 문장으로 다시 남겨주세요.");
		parameter.put("stuOneJug", sc.nextLine());

		System.out.println("평가 점수의 평균은 " + avg + "입니다.");
		con.modifyJudgement(parameter);

	}

	// 학생 강의평가 - 삭제
	private void deleteJudge(Map<String, String> parameter) {

		while (true) {
			ArrayList<LectureJugDTO> list = con.selectJudgement(parameter);
			if (list != null && !list.isEmpty()) {
				System.out.println("=========================================================================");
				System.out.print("강의 평가 삭제할 ");
				parameter.put("judgementNo", inputJudgemnetNo().get("judgementNo"));
			} else {
				break;
			}
			con.deleteJudgement(parameter);

			break;
		}
	}

	// 학생 강의평가 - 조회
	private void showJudge(Map<String, String> parameter) {
		con.selectJudgement(parameter);
	}

	// 교수 강의평가 - 조회
	private void viewJudgement(Map<String, String> inputProfNo) {

		while (true) {
			con.selectByProfNo(inputProfNo);
			System.out.println("=========================================================================");

			con.selectJudmentProf(inputProfNo);

			break;
		}
	}

	// 학번 입력받기
	private Map<String, String> inputStudentNo() {

		System.out.print("학번을 입력하세요. : ");
		String studentNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("studentNo", studentNo);

		return parameter;
	}

	// 교수번호 입력받기
	private Map<String, String> inputProfNo() {

		System.out.print("교수 번호를 입력하세요. : ");
		String profNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("profNo", profNo);

		return parameter;
	}

	// 강의번호 입력
	private Map<String, String> inputLectureNo(HashMap<String, String> parameter) {

		System.out.print("강의코드를 입력해주세요 : ");
		parameter.put("lectureNo", sc.nextLine());

		return parameter;
	}

	// 강의번호 입력
	private Map<String, String> inputLectureNo() {

		System.out.print("강의 번호를 입력하세요. : ");
		String lectureNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("lectureNo", lectureNo);

		return parameter;
	}

	// 강의평가 번호 입력
	private Map<String, String> inputJudgemnetNo() {

		System.out.print("강의 평가 번호를 입력하세요. : ");
		String judgementNo = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("judgementNo", judgementNo);

		return parameter;
	}
}
