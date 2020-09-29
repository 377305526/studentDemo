package com.dm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dm.dao.AdminDao;
import com.dm.dao.AnnounceDao;
import com.dm.entity.Admin;
import com.dm.entity.Announce;
import com.dm.service.AnnounceService;
import com.dm.utils.BaseUtils;
import com.google.gson.Gson;

/**
 * Servlet implementation class AnnounceServlet
 */
@MultipartConfig
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AnnounceService anns = new AnnounceService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnounceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("publish".equals(op)) {
			this.publish(request, response);
		} else if ("query".equals(op)) {
			query(request, response);
		} else if ("del".equals(op)) {
			del(request, response);
		}
	}

	public void del(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		if (new AnnounceDao().deleteAnn(id) == 1) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void query(HttpServletRequest request, HttpServletResponse response) {
		List<Announce> a = new AnnounceDao().queryAllAnn();
		List listStr = new ArrayList();
		for (int i = 0; i < a.size(); i++) {
			List l = new ArrayList();
			l.add(a.get(i));
			l.add(new AdminDao().queryById(a.get(i).getAnnouncer()).getName());
			listStr.add(l);
		}
		String json = new Gson().toJson(listStr);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void publish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = (Admin) request.getSession().getAttribute("adminInfo");
		int id = admin.getId();

		Part part = request.getPart("file");
		String header = part.getHeader("content-disposition");
		String tempPath = "/File/img";
		String realPath = request.getServletContext().getRealPath(tempPath);
		System.out.println(realPath);
		String suffix = header.substring(header.lastIndexOf("."), header.length() - 1);
		System.out.println(suffix);
		String filePath = UUID.randomUUID().toString() + suffix;
		realPath += "/" + filePath;
		part.write(realPath);
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		System.out.println(title + " " + context + " " + id);

		BaseUtils bu = new BaseUtils();
		String time = bu.getTime();
		Announce ann = new Announce();
		ann.setContent(context);
		ann.setTitle(title);
		ann.setPic(filePath);
		ann.setTime(time);
		ann.setAnnouncer(id);
		System.out.println(ann.toString());
		if (anns.addAnn(ann)) {
			System.out.println("上传成功！");
			response.sendRedirect("/DM-2/background/register/background/home.html");
		} else {
			System.out.println("上传失败！");
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
