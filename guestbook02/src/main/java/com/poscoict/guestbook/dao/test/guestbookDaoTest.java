package com.poscoict.guestbook.dao.test;

import java.util.List;

import com.poscoict.guestbook.dao.guestbookDao;
import com.poscoict.guestbook.vo.guestbookVo;

public class guestbookDaoTest {

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
		// TODO Auto-generated method stub
		List <guestbookVo> list=new guestbookDao().findAll();
		for(guestbookVo vo: list) {
			System.out.println(vo);
		}
		
//		assertEqual(2, list.size());
		
	
	}

}
