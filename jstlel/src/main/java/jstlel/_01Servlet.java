package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값
	
		int iVal=10;
		long lVal=10;
		float fVal=3.14f; //f안붙이면 double로 인식하여 값이 깨질 위험이 있음
		boolean bVal=true;
		String sVal="가나다라마바사";
		
		//객체
		Object obj=null;
		UserVo userVo=new UserVo();
		userVo.setNo(10L);
		userVo.setName("둘리");
		
		//map
		Map<String, Object> map=new HashMap<>();
		map.put("iVal", iVal);
		map.put("lVal", lVal);
		map.put("fVal", iVal);
		map.put("bVal", lVal);
		map.put("sVal", iVal);

		
		
		request.setAttribute("iVal", iVal);
		request.setAttribute("lVal", lVal);
		request.setAttribute("fVal", fVal);
		request.setAttribute("bVal", bVal);
		request.setAttribute("sVal", sVal);
		
		request.setAttribute("obj", obj);
		request.setAttribute("user", userVo);
		request.setAttribute("m", map);
		
		request.getRequestDispatcher("/WEB-INF/views/01.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
