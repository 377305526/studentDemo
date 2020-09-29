package com.dm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.dm.dao.BuildDao;
import com.dm.dao.RoomDao;
import com.dm.entity.Builds;
import com.dm.entity.Room;
import com.dm.service.BedService;
import com.dm.service.RoomService;
import com.google.gson.Gson;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	RoomService rs = new RoomService();
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public void RoomServlet() {

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("query".equals(op)) {
			query(request, response);
		} else if ("del".equals(op)) {
			del(request, response);
		} else if ("update".equals(op)) {

		} else if ("add".equals(op)) {
			add(request, response);
		} else if ("queryById".equals(op)) {
			queryById(request, response);
		} else if ("query2".equals(op)) {
			query2(request, response);
		}

	}

	/**
	 * 查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Builds> builds = new BuildDao().queryAll();
		this.getServletContext().setAttribute("builds", builds);
		List<Room> list = rs.getRoomService();
		List<Object> list2 = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			List<Object> l = new ArrayList<Object>();
			l.add(list.get(i));
			String buildname = new BuildDao().queryById(list.get(i).getBuildid()).getBuildname();
			l.add(buildname);
			list2.add(l);
		}
		Gson gson = new Gson();
		String strlist = gson.toJson(list2);
		response.getWriter().println(strlist);
	}

	public void query2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("buildID" + request.getParameter("build"));
		System.out.println("宿舍类型：" + request.getParameter("type"));
		System.out.println("性别：" + request.getParameter("sex"));
		Integer build = Integer.parseInt(request.getParameter("build"));
		String type = request.getParameter("type");
		String sex = request.getParameter("sex");
		List<Room> queryByBuildIdAndType = new RoomDao().queryByBuildIdAndType(build, type, sex);
		String json = new Gson().toJson(queryByBuildIdAndType);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	public void del(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		if (rs.isDel(id)) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param params
	 */
	public void alt(HttpServletRequest request, HttpServletResponse response, Object... params) {
		if (rs.isAlt(params)) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败!!");
		}
	}

	/**
	 * 通过Id查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int roomid = Integer.parseInt(request.getParameter("id"));
		Room room = rs.getOneRoomService(roomid);
		System.out.println(room.toString());
		request.getSession().setAttribute("roominfo", room.toString());
		response.getWriter().println("ccess");
	}

	/**
	 * 新增
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int buildid = Integer.parseInt(request.getParameter("buildid"));
		String roomname = request.getParameter("room");
		int bednum = Integer.parseInt(request.getParameter("bednum"));
		String type = request.getParameter("type");
		double rent = Double.parseDouble(request.getParameter("rent"));
		String remark = request.getParameter("remark");
		String sex = request.getParameter("sextype");
		if (rs.isAdd(null, buildid, roomname, bednum, null, type, sex, rent, remark)) {
			response.getWriter().print("success");
			System.out.println("添加成功！");
			Room room = new RoomDao().queryByBuildAndName(buildid, roomname);
			for (int i = 0; i < bednum; i++) {
				if (new BedService().addBed(i + 1, room.getId())) {
					continue;
				} else {
					break;
				}
			}
		} else {
			response.getWriter().print("error");
			System.out.println("添加失败！");
		}
	}

}
