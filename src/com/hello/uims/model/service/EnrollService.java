package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.LectureDTO;
import com.hello.uims.model.DTO.TimeTableDTO;

public class EnrollService {

	SqlSession sqlSession = null;
	UimsMapper mapper;

	// 강의목록 조회
	public ArrayList<LectureDTO> selectAllLecture() throws Exception {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.selectAllLecture();

		sqlSession.close();

		return lectureList;
	}

	// 수강신청
	public String enroll(Map<String, String> parameter) throws Exception {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		int totalCredit = 0;
		boolean duplication = false;
		boolean timeDuplication = false;

		// 등록 성공 여부
		int enrollResult = mapper.enroll(parameter);

		// 수강신청 내역
		ArrayList<LectureDTO> lectureList = mapper.selectEnroll(parameter);

		// 강의 중복 여부
		for (int i = 0; i < lectureList.size() - 1; i++) {
//			System.out.println("인덱스" + lectureList.get(i).getLectureNo()); 테스트
			if (lectureList.get(i).getLectureNo() == Integer.parseInt(parameter.get("lectureNo"))) {
				duplication = true;
			}

		}

		// 시간표를 ArrayList로 받아옴
		ArrayList<TimeTableDTO> timeList = mapper.timeTable(parameter);

		// 날짜, 시간 넣어서 2차원 배열 선언 및 초기화
		int[][] timeTables = new int[5][9];

		// 강의시간 중복 여부, 수강가능 학점 카운트
		for (TimeTableDTO time : timeList) {

			// 테스트
//			System.out.println(time.getEnrollId());
//			System.out.println(time.getStudentNo());
//			System.out.println(time.getLectureNo());
//			System.out.println(time.getDay());
//			System.out.println(time.getFirstClass());
//			System.out.println(time.getSecondClass());
//			System.out.println(time.getCredit());

			if (timeTables[time.getDay()][time.getFirstClass()] == 0)
				timeTables[time.getDay()][time.getFirstClass()] = time.getLectureNo();
			else
				timeDuplication = true;

			if (timeTables[time.getDay()][time.getSecondClass()] == 0)
				timeTables[time.getDay()][time.getSecondClass()] = time.getLectureNo();
			else
				timeDuplication = true;

			// 수강학점 카운트
			totalCredit += time.getCredit();

		}

		// 테스트
//		System.out.println("수강신청 결과" + enrollResult);
//		System.out.println("강의 중복여부" + duplication);
//		System.out.println("시간 중복여부" + timeDuplication);
//		System.out.println("수강학점" + totalCredit);

		if (enrollResult > 0 && !duplication && !timeDuplication && totalCredit <= 18) {
			sqlSession.commit();
			sqlSession.close();

			return "enrollSuccess";

		} else if (totalCredit > 18) {
			sqlSession.rollback();
			sqlSession.close();

			return "totalCreditOver";

		} else if (duplication) {
			sqlSession.rollback();
			sqlSession.close();

			return "duplication";

		} else if (timeDuplication) {
			sqlSession.rollback();
			sqlSession.close();

			return "timeDuplication";

		} else {
			sqlSession.rollback();
			sqlSession.close();

			return "enrollFail";
		}
	}

	// 수강신청 내역
	public ArrayList<LectureDTO> selectEnroll(Map<String, String> parameter) throws Exception {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.selectEnroll(parameter);

		sqlSession.close();

		return lectureList;
	}

	// 수강신청 취소
	public boolean deleteEnroll(Map<String, String> parameter) throws Exception {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		// 수강신청 취소 성공 여부
		int result = mapper.deleteEnroll(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;
	}

	// 강의목록 검색
	public ArrayList<LectureDTO> searchLectureByLectureNameOrProfName(Map<String, String> criteria) throws Exception {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.searchLectureByLectureNameOrProfName(criteria);

		sqlSession.close();

		return lectureList;
	}

}
