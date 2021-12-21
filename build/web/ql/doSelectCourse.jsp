<%-- 
    Document   : doSelectCourse
    Created on : Nov 11, 2021, 1:35:57 PM
    Author     : KHAI-PC
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.*"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //lay id user
    User user = (User) session.getAttribute("ql");
    if (user == null) {
        response.sendRedirect("login.jsp?err=timeout");
    }
    
    int curriId = Integer.parseInt(request.getParameter("curri"));
    List<Level> listLevel = new LevelDAO().getLevelByCurri(curriId);
    
    // convert Java object to JSON
    String json = new Gson().toJson(listLevel);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>
