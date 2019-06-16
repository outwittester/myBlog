package com.sincere.web.admin;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/test")
public class ServletTest extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println(req.getParameter("test"));
        PrintWriter out = resp.getWriter();

        HashMap map = new HashMap();
        map.put("1", "xiong1");
        map.put("2", "xiong2");
        map.put("3", "xiong3");
        Gson gson = new Gson();
//        out.println("Hello Xikai");
//        out.println(v3);
        out.println(gson.toJson(map));
        resp.setHeader("pragma", "no-cache");
        resp.setHeader("cache-control", "no-cache");
        out.flush();
    }
}
