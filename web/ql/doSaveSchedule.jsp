<%-- 
    Document   : doSelectRoom
    Created on : Nov 12, 2021, 3:56:15 PM
    Author     : KHAI-PC
--%>

<%@page import="com.google.gson.Gson"%>
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
    
    List<Lesson> listLesson = (ArrayList<Lesson>)session.getAttribute("listLesson");
    EnglishClass englishClass = (EnglishClass)session.getAttribute("englishClass");
    for(Lesson lesson: listLesson){
        lesson.setEnglishClass(englishClass);
    }
    
    if((new LessonDAO()).saveScheduleForClass(listLesson)){
%>
    <script type="text/javascript">
        alert("Đăng kí thành công!");
        window.location.href = "main.jsp";
    </script>
<%
    } else {
%>
    <script type="text/javascript">
        alert("Lỗi đăng kí!");
        history.back();
    </script>
<%
}
%>