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
import com.dm.dao.BuildDao;
import com.dm.entity.Builds;
import com.dm.entity.Room;
import com.dm.service.BuildsService;
import com.google.gson.Gson;

/**
 * Servlet implementation class BuildServlet
 */
@WebServlet("/BuildServlet")
public class BuildServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BuildsService bs = new BuildsService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if ("queryById".equals(op)) {
            this.queryById(request, response);
        } else if (op.equals("del")) {
            this.del(request, response);
        } else if (op.equals("alt")) {
            this.alt(request, response);
        } else if (op.equals("add")) {
            this.add(request, response);
        } else if ("queryAll".equals(op)) {
            queryAll(request, response);
        }

    }

    protected void queryById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int buildsid = Integer.parseInt(request.getParameter("id"));
        Builds build = bs.getOneBuildsService(buildsid);
        Gson gson = new Gson();
        String strbuild = gson.toJson(build);
        response.getWriter().println(strbuild);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

        String op = request.getParameter("op");
        if (op.equals("query")) {
            this.query(request, response);
        }
    }

    protected int queryId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int buildsid = Integer.parseInt(request.getParameter("id"));
        Builds build = bs.getOneBuildsService(buildsid);
        Gson gson = new Gson();
        String strbuild = gson.toJson(build);
        response.getWriter().println(strbuild);
        return buildsid;

    }

    /**
     * 查询所有
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Builds> li = null;
        li = bs.getBuildsService();
        List listStr = new ArrayList();
        for (int i = 0; i < li.size(); i++) {
            List list = new ArrayList();
            list.add(li.get(i));
            String adminName = new AdminDao().queryById(li.get(i).getAdmin()).getName();
            list.add(adminName);
            listStr.add(list);
        }
        Gson gson = new Gson();
        String strbuild = gson.toJson(listStr);
        response.getWriter().println(strbuild);
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (bs.isDel(id)) {
            System.out.println("删除成功!");
            response.getWriter().print("success");
        } else {
            System.out.println("删除失败！");
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String bdn = request.getParameter("buildname");
        int admin = Integer.parseInt(request.getParameter("admin"));
        String remark = request.getParameter("remark");

        if (bs.isAdd(null, bdn, admin, remark)) {
            System.out.println("修改成功！");
            response.getWriter().print("success");

        } else {
            System.out.println("修改失败！");
            response.getWriter().print("error");

        }

    }

    public void alt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String bdn = request.getParameter("buildname");
        int admin = Integer.parseInt(request.getParameter("admin"));
        String remark = request.getParameter("remark");
        if (bs.isAlt(bdn, admin, remark, id)) {
            System.out.println("修改成功！");
            response.getWriter().print("success");

        } else {
            System.out.println("修改失败！");
            response.getWriter().print("error");

        }
    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Builds> list = bs.getBuildsService();

        Gson gson = new Gson();
        String strlist = gson.toJson(list);
        response.getWriter().print(strlist);
    }

}
