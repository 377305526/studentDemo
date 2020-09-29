package com.dm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.dao.BedsDao;
import com.dm.entity.Beds;
import com.google.gson.Gson;

/**
 * Servlet implementation class BedServlet
 */
@WebServlet("/BedServlet")
public class BedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("query".equals(op)) {
			this.query(request, response);
		} else if ("queryBeds".equals(op)) {
			queryBeds(request, response);
		}
	}

	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BedsDao bd = new BedsDao();
		int id = Integer.parseInt(request.getParameter("bedid"));
		Beds bed = bd.queryById(id);
		Gson gson = new Gson();
		String Strbed = gson.toJson(bed);
		response.getWriter().println(Strbed);
	}

	protected void queryBeds(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("room"));
		List<Beds> beds = new BedsDao().queryByRoomId(id);
		String json = new Gson().toJson(beds);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
