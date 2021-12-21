<%-- 
    Document   : scheduleLesson
    Created on : Nov 12, 2021, 9:36:53 AM
    Author     : KHAI-PC
--%>

<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Thêm lịch học</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <%
        // lay id user
        User user = (User) session.getAttribute("ql");
        if (user == null) {
            response.sendRedirect("login.jsp?err=timeout");
        }
        
        List<Lesson> listLesson = null;
        Level level = null;
        
        String action = request.getParameter("action");
        
        if ((action == null)||(action.trim().length() == 0)) {//goi tu trang chon khoa hoc
            // lay du lieu muc do
            int idLevel = Integer.parseInt(request.getParameter("level"));
            level = new LevelDAO().findById(idLevel);
            
            
            listLesson = new ArrayList<Lesson>();
        } else {
            listLesson = (ArrayList<Lesson>)session.getAttribute("listLesson");
            level = (Level)session.getAttribute("level");
        }
        
        // Create a new english class
        EnglishClass englishClass = new EnglishClass();
        englishClass.setName(level.getCurri().getName() + " " + level.getName());
        // By default, a class has 40 students
        englishClass.setMaxSize(40);
        englishClass.setActualSize(0);
        // Allow student and teacher register 
        englishClass.setOpen(true);
        //englishClass.setDes("");
        englishClass.setUser(user);
        englishClass.setLevel(level);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        session.setAttribute("englishClass", englishClass);
        session.setAttribute("listLesson", listLesson);
        session.setAttribute("level", level);
        
    %>
    
    
    <style>
        h2.title {
            margin-top: 30px;
            margin-bottom: 40px;
        }
        button.btn.btn-primary {
            margin-left: 67px;
        }
    </style>
    
    
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8 offset-2">
                    <h2 class="text-center title"> Thêm lịch học </h2>
                    <h5>Tên quản lí: <%= user.getFullname()%> </h5>  
                    <h5>Chương trình: <%= level.getCurri().getName() %> </h5>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Mức độ: <%= level.getName() %> </h5>
                        </div>
                        <div class="col-md-3 offset-3">
                            <h5 class="num_lesson">Số buổi: <%= listLesson.size() + "/" + level.getNumberLesson()%> </h5>
                        </div>
                    </div>

                    <h2 class="text-center"> Danh sách buổi học </h2>
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Ngày</th>
                            <th scope="col">Ca</th>
                            <th scope="col">Phòng</th>
                            <th scope="col">Kĩ năng</th>
                            <th scope="col">Sửa</th>
                            <th scope="col">Xóa</th>
                          </tr>
                        </thead>
                        <tbody>
                            <%
                                int i = 0;
                                if(listLesson != null)
                                for(Lesson lesson : listLesson){
                            %>
                            <tr>
                                <td><%= ++i %></td>
                                <td><%= sdf.format(lesson.getDate())%></td>
                                <td><%= lesson.getShift().getName() %></td>
                                <td><%= lesson.getRoom().getName() %></td>
                                <td><%= lesson.getSkill().getName() %></td>
                                <td>
                                    <a href="editLesson.jsp?id=<%= i %>">Sửa</a>
                                </td>
                                <td>
                                    <a href="doDeleteLesson.jsp?id=<%= i %>">Xóa</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>

                    </table>
                    
                    <div class="row">
                        <div class="col-md-4">
                            <button class="btn btn-primary" onclick="openPage('main.jsp')">Về trang chính</button>
                        </div>
                        <div class="col-md-4">
                            <button id="btn-next" class="btn btn-primary" onclick="openPage('addLesson.jsp')">Chọn tiếp</button>
                        </div>
                        <div class="col-md-4">
                            <button id="btn-save" class="btn btn-primary" onclick="openPage('doSaveSchedule.jsp')" disabled>Lưu đăng kí</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
            var size = <%= listLesson.size() %>;
            if(size == <%= level.getNumberLesson() %>){
                document.getElementById("btn-save").disabled = false;
                document.getElementById("btn-next").disabled = true;
            }
        </script>

    </body>
</html>
