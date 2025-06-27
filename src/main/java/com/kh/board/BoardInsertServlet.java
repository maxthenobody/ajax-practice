package com.kh.board;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		
//		System.out.println(title);
//		System.out.println(nickname);
//		System.out.println(content);
		
		List<Board> list = (List<Board>)session.getAttribute("list");
		
		Board board = new Board(list.size()+1, title, nickname, content, new Date());
		
		list.add(board);
		
		session.setAttribute("list", list);
		
		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
//		response.sendRedirect("/board");
	}

}
