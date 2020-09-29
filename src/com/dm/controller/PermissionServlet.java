package com.dm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.dao.PermissionDao;
import com.dm.entity.Permission;
import com.google.gson.Gson;

/**
 * Servlet implementation class PermissionServlet
 */
@WebServlet("/PermissionServlet")
public class PermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("add".equals(op)) {
			add(request, response);
		} else if ("query".equals(op)) {
			query(request, response);
		} else if ("del".equals(op)) {
			del(request, response);
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String remark = request.getParameter("remark");
		System.out.println(name + " " + remark);
		int buildlist = Integer.parseInt(request.getParameter("buildlist"));
		int roomlist = Integer.parseInt(request.getParameter("roomlist"));
		int usernow = Integer.parseInt(request.getParameter("usernow"));
		int userleft = Integer.parseInt(request.getParameter("userleft"));
		int announcementlist = Integer.parseInt(request.getParameter("announcementlist"));
		int wait = Integer.parseInt(request.getParameter("wait"));
		int history = Integer.parseInt(request.getParameter("history"));
		int perssion = Integer.parseInt(request.getParameter("perssion"));
		int log = Integer.parseInt(request.getParameter("log"));
		Permission p = new Permission();
		p.setName(name);
		p.setRemark(remark);
		p.setBuildmanage(buildlist);
		p.setRoommanage(roomlist);
		p.setUsermanage_now(usernow);
		p.setUsermanage_left(userleft);
		p.setAnnouncementmanage(announcementlist);
		p.setApprovalmanage_wait(wait);
		p.setApprovalmanage_history(history);
		p.setSysmanage_permission(perssion);
		p.setSysmanage_log(log);
		System.out.println(p.toString());
		boolean addPerssion = new PermissionDao().addPerssion(p);
		if (addPerssion) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void del(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean del = new PermissionDao().del(id);
		if (del) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void query(HttpServletRequest request, HttpServletResponse response) {
		List<Permission> queryAll = new PermissionDao().queryAll();
		String json = new Gson().toJson(queryAll);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
