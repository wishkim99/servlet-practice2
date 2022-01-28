package com.poscoict.guestbook01.dao.test;

import java.util.List;

import com.poscoict.guestbook01.dao.guestbook01Dao;
import com.poscoict.guestbook01.vo.guestbook01Vo;

public class guestbook01DaoTest {

	public static void main(String[] args) {
		testFindAll();
//		testInsert();

	}
//	
//	private static void testInsert() {
//		guestbook01Vo vo=new guestbook01Vo();
//		vo.setFirstName("김");
//		vo.setLastName("소원");
//		vo.setEmail("kickscar@gammil.com");
//		
//		boolean result= new guestbook01Dao().insert(vo);
//		System.out.println(result ? "success": "fail");
//		
//	}

	private static void testFindAll() {
		
		List <guestbook01Vo> list=new guestbook01Dao().findAll();
		for(guestbook01Vo vo: list) {
			System.out.println(vo);
		}
		
//		assertEqual(2, list.size());
		
	
	}

}
