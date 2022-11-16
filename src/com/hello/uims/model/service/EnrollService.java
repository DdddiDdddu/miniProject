package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.TimeTableDTO;

public class EnrollService {

	SqlSession sqlSession = null;
	UimsMapper mapper;

	// 수강신청 강의목록 조회
	public ArrayList<LectureDTO> selectAllLecture() {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.selectAllLecture();

		sqlSession.close();

		return lectureList;

	}

	// 수강신청
	public String enroll(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		// 등록 성공 여부 판단
		int enrollResult = mapper.enroll(parameter);
		int totalCredit = 0;
		boolean duplication = true;
		boolean timeDuplication = true;

		// 시간표를 ArrayList로 받아옴
		ArrayList<TimeTableDTO> timeList = mapper.timeTable(parameter);
		ArrayList<LectureDTO> enrollList = mapper.selectEnroll(parameter);

		// 강의중복체크
//		Set<Integer> lectureNoSet = new HashSet<>(mapper.selectEnroll(parameter));

//		List<Integer> numList = Arrays.asList(1, 1, 2, 3, 4, 5);


//		중복검사 내용 수정, 시간중복검사 왜 안잡히지?

//		// 중복 검사
//		for (int i = 0; i < timeList.size(); i++) {
//
//		}
//
//		for (int i = 0; i < timeList.size(); i++) {
//
//			for (int j = 0; j < i; j++) {
//
//				if (timeList.get(i).equals(timeList.get(j))) {
//					duplication = false;
//
//				}
//
//			}
//
//		}

		// 날짜 시간 넣어서 2차원 배열 선언 및 초기화
		int[][] timeTables = new int[5][9];

		// 강의시간중복체크, 수강가능학점 카운트
		for (TimeTableDTO time : timeList) {
			
//			System.out.println("get 출력");
//			System.out.println(time.getEnrollId());
//			System.out.println(time.getStudentNo());
//			System.out.println(time.getLectureNo());
//			System.out.println(time.getDay());
//			System.out.println(time.getFirstClass());
//			System.out.println(time.getSecondClass());
//			System.out.println(time.getCredit());
			// 커밋안됨 ㅁㅁㅁ

			if (timeTables[time.getDay()][time.getFirstClass()] == 0)
				timeTables[time.getDay()][time.getFirstClass()] = time.getLectureNo();
			else
				timeDuplication = false;

			if (timeTables[time.getDay()][time.getSecondClass()] == 0)
				timeTables[time.getDay()][time.getSecondClass()] = time.getLectureNo();
			else
				timeDuplication = false;

			totalCredit += time.getCredit();

			for (TimeTableDTO inTime : timeList) {
				if (time.getLectureNo() == inTime.getLectureNo()) {
					duplication = false;

				}

			}

		}

		if (enrollResult > 0 && duplication && timeDuplication && totalCredit <= 18) {
			sqlSession.commit();
			sqlSession.close();
			return "enrollSuccess";

		} else if (timeDuplication) {
			sqlSession.rollback();
			sqlSession.close();
			return "timeDuplication";

		} else if (duplication) {
			sqlSession.rollback();
			sqlSession.close();
			return "duplication";

		} else if (totalCredit > 18) {
			sqlSession.rollback();
			sqlSession.close();
			return "totalCreditOver";

		} else {
			sqlSession.rollback();
			sqlSession.close();
			return "enrollFail";
		}

	}

	// 수강신청 내역
	public ArrayList<LectureDTO> selectEnroll(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.selectEnroll(parameter);

		sqlSession.close();

		return lectureList;

	}

	// 수강신청 취소
	public boolean deleteEnroll(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		int result = mapper.deleteEnroll(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;

	}

//		public List<MenuDTO> selectAllMenu() {
//			
//			SqlSession sqlSession = getSqlSession();
//			
//			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//			
//			List<MenuDTO> menuList = menuMapper.selectAllMenu();
//			
//			sqlSession.close();
//			
//			return menuList;
//			
//		}
//
//		public MenuDTO selectMenuByCode(int code) {
//			
//			SqlSession sqlSession = getSqlSession();
//			
//			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//			MenuDTO menu = menuMapper.selectMenuByCode(code);
//			
//			sqlSession.close();
//			
//			return menu;
//		}
//
//		public boolean registMenu(MenuDTO menu) {
//			
//			SqlSession sqlSession = getSqlSession();
//			
//			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//			int result = menuMapper.insertMenu(menu);
//			
//			if(result > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//			
//			sqlSession.close();
//			
//			return result > 0? true: false;
//			
//		}
//
//		public boolean modifyMenu(MenuDTO menu) {
//			
//			SqlSession sqlSession = getSqlSession();
//			
//			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//			int result = menuMapper.updateMenu(menu);
//			
//			if(result > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//			
//			sqlSession.close();
//			
//			return result > 0? true: false;
//			
//		}
//
//		public boolean deleteMenu(int code) {
//			
//			SqlSession sqlSession = getSqlSession();
//			
//			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//			int result = menuMapper.deleteMenu(code);
//			
//			if(result > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//			
//			sqlSession.close();
//			
//			return result > 0? true: false;
//			
//		}

}
