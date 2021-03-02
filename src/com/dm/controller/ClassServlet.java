package com.dm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.dao.ClassDao;
import com.dm.entity.Classes;
import com.google.gson.Gson;

/**
 * Servlet implementation class ClassServlet
 * @author Administrator
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if ("query".equals(op)) {
            query(request, response);
        }
    }

    public void query(HttpServletRequest request, HttpServletResponse response) {
        List<Classes> queryAll = new ClassDao().queryAll();
        String json = new Gson().toJson(queryAll);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
