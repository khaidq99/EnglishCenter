<%-- 
    Document   : addLesson
    Created on : Nov 12, 2021, 11:10:23 AM
    Author     : KHAI-PC
--%>

<%@page import="java.util.*"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm 1 buổi học</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.date_shift').change(function ()
                {
                    $.ajax({
                        type: "post",
                        url: "doSelectRoom.jsp", //this is my servlet
                        data: "date=" + $('#datepicker').val() + "&shift_id="+$('#shift').val(),
                        success: function(responseJson){
                            var $select = $("#room");
                            $select.find("option").remove(); 
                            $.each(responseJson, function(index, room) {
                                $("<option>").val(room.id).text(room.name).appendTo($select);
                            });
                        }
                    });
                });

            });
        </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    </head>
    <%
        // lay id user
        User user = (User) session.getAttribute("ql");
        if (user == null) {
            response.sendRedirect("login.jsp?err=timeout");
        }
        
        List<Lesson> listLesson = (ArrayList<Lesson>)session.getAttribute("listLesson");
        Level level = (Level)session.getAttribute("level");
        
        List<Shift> listShift = new ShiftDAO().getAllShift();
        List<Skill> listSkill = new SkillDAO().getAllSkill();
        
        session.setAttribute("listLesson", listLesson);
        session.setAttribute("level", level);
        
    %>
    
    
    <style>
        h2.title {
            margin-top: 30px;
            margin-bottom: 40px;
        }
        .btn-add {
            margin-top: 20px;
        }
    </style>
    
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-3">
                    <h2 class="text-center title"> Thêm 1 buổi học </h2>
                    <form action="doAddLesson.jsp" method="post">
                        <div class="form-group">
                            <label for="date">Ngày học: </label>
                            <input id="datepicker" class="date_shift" width="150" name="date" required/>
                        </div>
                        <div class="form-group">
                            <label for="shift">Ca: </label>
                            <select class="form-control date_shift" id="shift" name="shift">
<!--                                <option value="-1" selected>--chọn--</option>-->
                                <% for (Shift shift : listShift) {%>
                                <option value="<%=shift.getId()%>"><%=shift.getName()%></option>
                                <%}
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="room">Phòng học: </label>
                            <select class="form-control" id="room" name="room">
<!--                                <option value="-1" selected>--chọn--</option>-->
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="skill">Kĩ năng: </label>
                            <select class="form-control" id="skill" name="skill">
<!--                                <option value="-1" selected>--chọn--</option>-->
                                <% for (Skill skill : listSkill) {%>
                                <option value="<%=skill.getId()%>"><%=skill.getName()%></option>
                                <%}
                                %>
                            </select>
                        </div>
                        
                        <div class="row">
                            <div class="col text-center">
                                <button type="submit" class="btn btn-primary btn-add">
                                    Thêm vào danh sách
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <script>
            $('#datepicker').datepicker({
                uiLibrary: 'bootstrap4',
                format: 'dd/mm/yyyy'
            });
        </script>
    </body>
</html>
