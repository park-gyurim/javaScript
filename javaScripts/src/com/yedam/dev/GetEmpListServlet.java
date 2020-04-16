package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.Board;
import com.yedam.board.BoardDao;
import com.yedam.board.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetEmpListServlet
 */
@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmpListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append().append(request.getContextPath()).append();
		
		EmpDao dao = new EmpDao();
		List<Board> boardList = dao.getBoardList();
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		for(Employee e : dao.getEmpList()) {
			obj.put("empId", e.getEmployeeId());
			obj.put("firstName", e.getFirstName());
			obj.put("lastName", e.getLastName());
			ary.add(obj);
		}
		PrintWriter out = response.getWriter();
		out.print(ary.toString());
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
