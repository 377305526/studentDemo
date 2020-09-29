package com.dm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.dao.AdminDao;
import com.dm.dao.ApprovalDao;
import com.dm.dao.BedsDao;
import com.dm.dao.BuildDao;
import com.dm.dao.ClassDao;
import com.dm.dao.MsgDao;
import com.dm.dao.RoomDao;
import com.dm.dao.StudentDao;
import com.dm.entity.Admin;
import com.dm.entity.Approval;
import com.dm.entity.Classes;
import com.dm.entity.Msg;
import com.dm.entity.Room;
import com.dm.entity.Student;
import com.dm.service.ApprovalService;
import com.dm.utils.BaseUtils;
import com.google.gson.Gson;

/**
 * Servlet implementation class ApprovalServlet
 */
@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		System.out.println(action);
		if ("add".equals(action)) {
			addApproval(req, resp);
		} else if ("update".equals(action)) {
			updateApproval(req, resp);
		} else if ("getMyApprovals".equals(action)) {
			queryApproval(req, resp);
		} else if ("detail".equals(action)) {
			System.out.println("detail");
			getDetailById(req, resp);
		} else if ("waitList".equals(action)) {
			selectApproval(req, resp);
		} else if ("history".equals(action)) {
			approvalHistory(req, resp);
		} else if ("delete".equals(action)) {
			deleteById(req, resp);
		} else if ("historydetail".equals(action)) {
			getHistoryDetailById(req, resp);
		}
	}

	/**
	 * 提交申请
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addApproval(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Approval approval = new Approval();
		Student s = (Student) req.getSession().getAttribute("userInfo");
		int buildid = new RoomDao().queryById(new BedsDao().queryById(s.getBedid()).getRoomid()).getBuildid();
		int admin = new BuildDao().queryById(buildid).getAdmin();
		approval.setType(req.getParameter("type"));
		approval.setContent(req.getParameter("content"));
		approval.setApplicant(s.getId());
		approval.setApprover(admin);
		approval.setTime(new BaseUtils().getTime());
		boolean addApproval = new ApprovalService().addApproval(approval);
		if (addApproval) {
			resp.getWriter().print("申请提交成功");
		} else {
			resp.getWriter().print("申请提交失败");
		}

	}

	/**
	 * 审批
	 * 
	 * @param req
	 * @param resp
	 */
	protected void updateApproval(HttpServletRequest req, HttpServletResponse resp) {
		String op = req.getParameter("op");
		String remark = "";
		String state = req.getParameter("state");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Approval approval = new ApprovalDao().queryApprovalById(id);
		boolean flag = false;
		if ("通过".equals(op)) {
			remark = "申请通过！";
			flag = new ApprovalService().updateApproval(state, remark, id);
		} else if ("拒绝".equals(op)) {
			remark = req.getParameter("remark");
			flag = new ApprovalService().updateApproval(state, remark, id);
		}

		if (flag) {
			boolean add = new MsgDao().add(approval.getType(), approval.getContent(), approval.getApplicant(), remark);
			if (add) {
				try {
					resp.getWriter().print("审批成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			try {
				resp.getWriter().print("审批失败");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 申请者查询
	 * 
	 * @param req
	 * @param resp
	 */
	protected void queryApproval(HttpServletRequest req, HttpServletResponse resp) {
		Student student = (Student) req.getSession().getAttribute("userInfo");
		List<Approval> approvals = new ApprovalDao().queryApproval(student.getId());
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < approvals.size(); i++) {
			Admin admin = new AdminDao().queryById(approvals.get(i).getApprover());
			List<Object> l = new ArrayList<Object>();
			l.add(approvals.get(i));
			l.add(admin.getName());
			list.add(l);
		}
		String json = new Gson().toJson(list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 审批人查询
	 * 
	 * @param req
	 * @param resp
	 */
	protected void selectApproval(HttpServletRequest req, HttpServletResponse resp) {
		Admin admin = (Admin) req.getSession().getAttribute("adminInfo");
		Integer id = admin.getId();
		String state = req.getParameter("state");
		List<Approval> queryApproval = new ApprovalDao().queryApproval(id, state);
		List<Object> list = new ArrayList<Object>();
		int size = queryApproval.size();
		list.add(size);
		for (int i = 0; i < queryApproval.size(); i++) {
			List<Object> list2 = new ArrayList<Object>();
			String name = new StudentDao().queryById(queryApproval.get(i).getApplicant()).getName();
			list2.add(queryApproval.get(i));
			list2.add(name);
			list.add(list2);
		}
		String json = new Gson().toJson(list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 记录审批
	 * 
	 * @param req
	 * @param resp
	 */
	protected void approvalHistory(HttpServletRequest req, HttpServletResponse resp) {
		Admin admin = (Admin) req.getSession().getAttribute("adminInfo");
		Integer id = admin.getId();
		String state = req.getParameter("state");
		List<Approval> queryApproval = new ApprovalDao().queryApprovaHistory(id, state);
		List<Object> list = new ArrayList<Object>();
		int size = queryApproval.size();
		list.add(size);
		for (int i = 0; i < queryApproval.size(); i++) {
			List<Object> list2 = new ArrayList<Object>();
			String name = new StudentDao().queryById(queryApproval.get(i).getApplicant()).getName();
			list2.add(queryApproval.get(i));
			list2.add(name);
			list.add(list2);
		}
		String json = new Gson().toJson(list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 申请详情
	 * 
	 * @param req
	 * @param resp
	 */
	protected void getDetailById(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Approval queryApprovalById = new ApprovalDao().queryApprovalById(id);
		Student student = new StudentDao().queryById(queryApprovalById.getApplicant());
		Classes classInfo = new ClassDao().queryById(student.getClass_());
		Room room = new RoomDao().queryById(new BedsDao().queryById(student.getBedid()).getRoomid());
		req.setAttribute("applicant", student);
		req.setAttribute("detail", queryApprovalById);
		req.setAttribute("classInfo", classInfo);
		req.setAttribute("room", room);

		try {
			System.out.println("跳转");
			try {
				req.getRequestDispatcher("background/register/background/applicationdetails.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 申请记录详情
	 * 
	 * @param req
	 * @param resp
	 */
	protected void getHistoryDetailById(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Approval queryApprovalById = new ApprovalDao().queryApprovalById(id);
		Student student = new StudentDao().queryById(queryApprovalById.getApplicant());
		Classes classInfo = new ClassDao().queryById(student.getClass_());
		Room room = new RoomDao().queryById(new BedsDao().queryById(student.getBedid()).getRoomid());
		req.setAttribute("applicant", student);
		req.setAttribute("detail", queryApprovalById);
		req.setAttribute("classInfo", classInfo);
		req.setAttribute("room", room);

		try {
			System.out.println("跳转");
			try {
				req.getRequestDispatcher("background/register/background/applicationDetail.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param resp
	 */
	protected void deleteById(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		boolean flag = new ApprovalDao().deleteById(id);
		if (flag) {
			try {
				resp.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				resp.getWriter().print("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
