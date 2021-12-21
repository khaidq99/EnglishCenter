<%-- 
    Document   : selectCourse
    Created on : Nov 11, 2021, 1:35:30 PM
    Author     : KHAI-PC
--%>

<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#curri').change(function ()
                {
                    $.ajax({
                        type: "post",
                        url: "doSelectCourse.jsp", //this is my servlet
                        data: "curri=" + $('#curri').val(),
                        success: function(responseJson){
                            var $select = $("#level");
                            $select.find("option").remove(); 
                            $.each(responseJson, function(index, level) {
                                $("<option>").val(level.id).text(level.name).appendTo($select);
                            });
                        }
                    });
                });

            });
        </script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chọn khóa học</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    
    <style>
        h2 {
            margin-top: 30px;
        }
        form {
            margin-left: 213px;
            margin-top: 30px;
        }
        .td-title {
            margin-right: 20px;
            display: inline-block;
        }
        .btn.btn-primary {
            margin-top: 15px;
        }
        
    </style>
    
    
    <%
        //lay id user
        User user = (User) session.getAttribute("ql");
        if (user == null) {
            response.sendRedirect("login.jsp?err=timeout");
        }
        
        List<Curriculum> listCurri = new CurriculumDAO().getAllCurriculum();
        session.setAttribute("listCurri", listCurri);
    %>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8 offset-2">
                    <h2 class="text-center"> Chọn khóa học </h2>
                    <form name="select-course" action="scheduleLesson.jsp" method="post">
                        <table border="0">
                            <tr>
                                <td class="td-title">Chọn khóa học:</td>
                                <td>
                                    <select name="curri" size=1 id="curri">
                                        <option value="-1" selected>--chọn chương trình--</option>
                                        <% for (Curriculum curri : listCurri) {%>
                                            <option value="<%=curri.getId()%>"><%=curri.getName()%></option>
                                        <%}
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="td-title">Chọn mức độ:</td>
                                <td>
                                    <select name="level" size=1 id="level">
                                        <option value="-1" selected>--chọn mức độ--</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="btn btn-primary" type="submit" value="Thêm lịch học" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
