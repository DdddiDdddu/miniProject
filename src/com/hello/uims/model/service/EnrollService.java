package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.LectureDTO;

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
	public boolean enroll(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		// 등록 성공 여부 판단 
		int result = mapper.enroll(parameter);
		
		// 시간표를 ArrayList로 받아옴
		ArrayList<LectureDTO> timeList = mapper.timeTable(parameter);
		
		// 시간 중복되는지 체크
		boolean duplication;

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;

	}
	
	public ArrayList<LectureDTO> selectEnroll(Map<String, String> parameter) {
		
		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);
		
		ArrayList<LectureDTO> lectureList = mapper.selectEnroll(parameter);
		
		sqlSession.close();

		return lectureList;
		
	}

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
