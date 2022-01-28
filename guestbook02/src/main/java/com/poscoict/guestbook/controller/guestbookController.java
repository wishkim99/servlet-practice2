package com.poscoict.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.guestbook.dao.guestbookDao;
import com.poscoict.guestbook.vo.guestbookVo;

public class guestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String actionName = request.getParameter("gb");

		if ("form".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		} else if ("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");

			guestbookVo vo = new guestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);

			new guestbookDao().insert(vo);

			response.sendRedirect(request.getContextPath() + "/gb");
			
		}else if("delete".equals(actionName)) {
			int no = Integer.valueOf(request.getParameter("no"));
			String password= (String)request.getParameter("password");

			
			guestbookVo vo = new guestbookVo();
			vo.setNo(no);
			vo.setPassword(password);                             
			
			new guestbookDao().delete(vo);
			
			response.sendRedirect(request.getContextPath() + "/gb");
		}
		else {
			guestbookDao dao = new guestbookDao();
			List<guestbookVo> list = dao.findAll();

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
