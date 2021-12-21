<%-- 
    Document   : test
    Created on : Nov 13, 2021, 8:22:44 AM
    Author     : KHAI-PC
--%>

<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //lay id user
    User user = (User) session.getAttribute("ql");
    if (user == null) {
        response.sendRedirect("login.jsp?err=timeout");
    }
    
    List<Lesson> listLesson = (ArrayList<Lesson>) session.getAttribute("listLesson");
    Level level = (Level) session.getAttribute("level");
    
    int id = Integer.parseInt(request.getParameter("id"));
    Lesson lesson = listLesson.get(id-1);
    
    listLesson.remove(lesson);
    
    session.setAttribute("listLesson", listLesson);
    session.setAttribute("level", level);
    response.sendRedirect("scheduleLesson.jsp?action=delete");
%>
