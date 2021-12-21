<%-- 
    Document   : doLogin
    Created on : Nov 11, 2021, 1:33:49 PM
    Author     : KHAI-PC
--%>

<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    
    UserDAO dao = new UserDAO();
 
    boolean kq = dao.checkLogin(user);
     
    if(kq && (user.getRole().equalsIgnoreCase("ql"))){
        session.setAttribute("ql", user);
        response.sendRedirect("ql\\main.jsp");
    } else {
        response.sendRedirect("login.jsp?err=fail");
    }
%>
