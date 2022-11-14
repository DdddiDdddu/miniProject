package com.hello.uims.model.service;

import java.util.List;

import com.hello.uims.model.DTO.EnrollmentDTO;
import com.hello.uims.model.DTO.LectureDTO;

public class EnrollService {
	
	public EnrollService() { // 수용 파트 

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

	public static List<LectureDTO> selectLecture() {
		
		
		
		return null;
	}

}
