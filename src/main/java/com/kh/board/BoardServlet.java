package com.kh.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("list") == null) {
			List<Board> list = new ArrayList<>();
			list.add(new Board(1, "kh게시판 1번글", "admin", "aaaa", new Date()));
			list.add(new Board(2, "kh게시판 2번글", "admin", "bbbb", new Date()));
			list.add(new Board(3, "kh게시판 3번글", "mkm", "cccc", new Date()));
			list.add(new Board(4, "kh게시판 4번글", "user01", "dddd", new Date()));
			list.add(new Board(5, "kh게시판 5번글", "user02", "eeee", new Date()));
			session.setAttribute("list", list);
		} else {
			System.out.println("데이터 있음.");
		}
		
//		System.out.println(request.getParameter("posted"));
		if (request.getParameter("posted") == null) {
			request.setAttribute("posted", 0);
		} else {
			request.setAttribute("posted", request.getParameter("posted"));			
		}
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
