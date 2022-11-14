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
	private UimsMapper mapper;

	public ArrayList<LectureDTO> selectAllLecture() {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		ArrayList<LectureDTO> lectureList = mapper.selectAllLecture();

		for (LectureDTO lecture : lectureList) // 용도?
			System.out.println(lecture);

		sqlSession.close();

		return lectureList;

	}

	public boolean enroll(Map<String, String> parameter) {
		
		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		int result = mapper.enroll(parameter);

		if (result > 0)
			sqlSession.commit();
		else
			sqlSession.rollback();

		return (result > 0) ? true : false;

	}

	// 예시
	public ArrayList<EnrollmentDTO> selectStuGrade(Map<String, String> parameter) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);
		ArrayList<EnrollmentDTO> list = mapper.selectStuGrade(parameter);

		sqlSession.close();

		return list;
	}

	public EnrollService() { // 수용 파트

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
