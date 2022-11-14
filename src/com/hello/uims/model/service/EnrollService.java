package com.hello.uims.model.service;

import static com.hello.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hello.common.UimsMapper;
import com.hello.uims.model.DTO.LectureDTO;

public class EnrollService {

	private UimsMapper mapper;

	public void selectLecture() {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UimsMapper.class);

		List<LectureDTO> lectureList = mapper.selectLecture();

		for (LectureDTO menu : lectureList)
			System.out.println(menu);

		sqlSession.close();

	}

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

}
