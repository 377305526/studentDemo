package com.dm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.dao.BedsDao;
import com.dm.dao.BuildDao;
import com.dm.dao.ClassDao;
import com.dm.dao.MsgDao;
import com.dm.dao.RoomDao;
import com.dm.dao.StudentDao;
import com.dm.entity.Beds;
import com.dm.entity.Builds;
import com.dm.entity.Classes;
import com.dm.entity.Msg;
import com.dm.entity.Room;
import com.dm.entity.Student;
import com.dm.service.StudentService;
import com.dm.utils.BaseUtils;
import com.google.gson.Gson;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("login".equals(op)) {
			System.out.println("开始执行登录");
			this.login(request, response);
		} else if ("register".equals(op)) {
			this.register(request, response);
		} else if ("query".equals(op)) {
			this.query(request, response);
		} else if ("updateInfo".equals(op)) {
			updateBasicInfo(request, response);
		} else if ("tobed".equals(op)) {
			toBed(request, response);
		} else if ("out".equals(op)) {
			out(request, response);
		}

	}

	public void out(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("userInfo");
		try {
			response.sendRedirect("/DM-2/front/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 学生查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService ss = new StudentService();
		String statu = request.getParameter("statu");
		List<Student> list = ss.queryByStatu(statu);
		List<Object> list1 = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			String classname = new ClassDao().queryById(list.get(i).getClass_()).getClassname();
			int bedno = new BedsDao().queryById(list.get(i).getBedid()).getBedno();
			String roomname = new RoomDao().queryById(new BedsDao().queryById(list.get(i).getBedid()).getRoomid())
					.getRoomname();
			String buildname = new BuildDao().queryById(
					new RoomDao().queryById(new BedsDao().queryById(list.get(i).getBedid()).getRoomid()).getBuildid())
					.getBuildname();
			List<Object> l = new ArrayList<Object>();
			l.add(list.get(i));
			l.add(classname);
			l.add(bedno);
			l.add(roomname);
			l.add(buildname);
			list1.add(l);
		}
		Gson gson = new Gson();
		String strList = gson.toJson(list1);
		response.getWriter().println(strList);

	}

	public void toBed(HttpServletRequest request, HttpServletResponse response) {
		Integer bedid = Integer.parseInt(request.getParameter("bed"));
		Student stu = (Student) request.getSession().getAttribute("userInfo");
		Integer classid = Integer.parseInt(request.getParameter("classid"));
		Integer stuId = stu.getId();
		boolean updateBed = new StudentDao().updateBed(bedid, classid, stuId);
		if (updateBed) {
			boolean updateState = new BedsDao().updateState(bedid);
			if (updateState) {
				try {
					request.getSession().removeAttribute("userInfo");
					response.getWriter().print("分配成功,请重新登录！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 学生注册
	 * 
	 * @param request
	 * @param response
	 */
	private void register(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String idCard = request.getParameter("idCard");
		String hometown = request.getParameter("hometown");
		Student student = new Student();
		student.setUsername(userName);
		student.setName(name);
		student.setPhone(phone);
		student.setPwd(pwd);
		student.setIdcard(idCard);
		student.setHometown(hometown);
		student.setRegistertime(new BaseUtils().getTime());
		StudentService studentService = new StudentService();
		boolean addStu = studentService.addStu(student);
		if (addStu) {
			try {
				response.getWriter().print("注册成功！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("注册失败！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 学生登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String phone = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		boolean stu = new StudentService().getStu(phone, pwd);
		Student stuInfo = new StudentDao().getStu(phone, pwd);
		System.out.println("session:" + stuInfo.toString());
		if (stu) {
			request.getSession().setAttribute("userInfo", stuInfo);
			if (stuInfo.getBedid() != 0) {
				Beds bed = new BedsDao().queryById(stuInfo.getBedid());
				Room room = new RoomDao().queryById(bed.getRoomid());
				Builds build = new BuildDao().queryById(room.getBuildid());

				request.getSession().setAttribute("buildInfo", build.getBuildname());
				request.getSession().setAttribute("roomInfo", room.getRoomname());
			}

			if (stuInfo.getClass_() != 0) {
				Classes classInfo = new ClassDao().queryById(stuInfo.getClass_());
				request.getSession().setAttribute("classInfo", classInfo.getClassname());
				List<Msg> queryByGet = new MsgDao().queryByGet(stuInfo.getId());
				request.getSession().setAttribute("msg", queryByGet);
			}
			response.getWriter().print("success");

		} else {
			response.getWriter().print("error");
		}
	}

	/**
	 * 修改个人基本信息
	 * 
	 * @param request
	 * @param response
	 */
	private void updateBasicInfo(HttpServletRequest request, HttpServletResponse response) {
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		String company = request.getParameter("company");
		String job = request.getParameter("job");
		Student s = (Student) request.getSession().getAttribute("userInfo");
		boolean flag = new StudentService().updateBasicInfo(phone, email, location, company, job, s.getPhone());
		if (flag) {
			try {
				Student newStu = new StudentDao().getStuByTel(phone);
				request.getSession().setAttribute("userInfo", newStu);
				response.getWriter().print("修改成功！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("修改失败！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
