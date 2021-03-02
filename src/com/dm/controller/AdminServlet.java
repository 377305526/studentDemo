package com.dm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.dao.AdminDao;
import com.dm.dao.PermissionDao;
import com.dm.entity.Admin;
import com.dm.entity.Permission;
import com.dm.service.AdminService;
import com.google.gson.Gson;

/**
 * 管理员登录
 *
 * @author Administrator
 */

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    AdminService as = new AdminService();

    /**
     * Constructor of the object.
     */
    public AdminServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("wwww!!!!!!!!!!!!!");
        this.doPost(request, response);

    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
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
            this.login(request, response);
        } else if (op.equals("query")) {
            this.queryAll(request, response);
        } else if ("add".equals(op)) {
            add(request, response);
        } else if ("del".equals(op)) {
            del(request, response);
        } else if ("out".equals(op)) {
            out(request, response);
        } else if ("updateInfo".equals(op)) {
            updateInfo(request, response);
        } else if ("updatepwd".equals(op)) {
            updatepwd(request, response);
        } else if ("updatePermission".equals(op)) {
            updatePermission(request, response);
        }

    }

    public void updatePermission(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer pId = Integer.parseInt(request.getParameter("permission"));
        System.out.println(id + " " + pId);
        if (new AdminDao().updatePermission(pId, id) == 1) {
            try {
                response.getWriter().print("success");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void updatepwd(HttpServletRequest request, HttpServletResponse response) {
        String pwd = request.getParameter("pwd");
        Admin admin = (Admin) request.getSession().getAttribute("adminInfo");
        Integer id = admin.getId();
        if (new AdminDao().updatePwd(pwd, id) == 1) {
            try {
                response.getWriter().print("success");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void updateInfo(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        Admin admin = (Admin) request.getSession().getAttribute("adminInfo");
        Integer id = admin.getId();
        if (new AdminDao().update(name, tel, id) == 1) {
            try {
                admin.setName(name);
                admin.setPhone(tel);
                request.getSession().setAttribute("adminInfo", admin);
                response.getWriter().print("success");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void out(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("adminInfo");
        request.getSession().removeAttribute("userPermission");
        try {
            response.sendRedirect("/DM-2/background/index.html");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int deleteAdmin = new AdminDao().deleteAdmin(id);
        if (deleteAdmin == 1) {
            try {
                response.getWriter().print("success");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        Integer id = Integer.parseInt(request.getParameter("permission"));
        System.out.println(name + tel + id);
        Admin a = new Admin();
        a.setName(name);
        a.setPhone(tel);
        a.setPermission(id);
        boolean add = new AdminDao().add(a);
        try {
            response.sendRedirect("/DM-2/background/register/background/administrator.html");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("code");
        boolean adm = as.getAdm(phone, pwd);
        Admin adminInfo = new AdminDao().getAdm(phone, pwd);
        Permission p = new PermissionDao().queryById(adminInfo.getPermission());
        System.out.println(p.toString());
        request.getSession().setAttribute("userPermission", p);
        if (adm) {
            request.getSession().setAttribute("adminInfo", adminInfo);
            response.getWriter().print("success");
        } else {
            response.getWriter().print("error");
        }

    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Admin> list = (ArrayList<Admin>) as.queryAllAdm();
        List<Object> strList = new ArrayList<Object>();
        for (int i = 0; i < list.size(); i++) {
            String name = new PermissionDao().queryById(list.get(i).getPermission()).getName();
            List<Object> l = new ArrayList<Object>();
            l.add(list.get(i));
            l.add(name);
            strList.add(l);
        }
        Gson gson = new Gson();
        String strlist = gson.toJson(strList);
        response.getWriter().print(strlist);
    }

}
