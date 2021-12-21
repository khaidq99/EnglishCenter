<%-- 
    Document   : main
    Created on : Nov 11, 2021, 1:34:55 PM
    Author     : KHAI-PC
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Trang chủ quản lý</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <style>
        h2 {
            margin-top: 30px;
            font-size: 22px;
            margin-bottom: 30px;
        }
        
        button {
            margin-left: 106px;
        }
    </style>
    <body>
        <%
            User user = (User)session.getAttribute("ql");
            if(user == null){
                response.sendRedirect("login.jsp?err=timeout");
            }
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-4">
                    <h2 class="text-center"> Trang chủ quản lý </h2>
                        <button class="btn btn-primary" onclick="openPage('selectCourse.jsp')">Lên lịch lớp mới</button>
                    </div>
                </div>
            </div>
        </div>
        
</body>
</html>
