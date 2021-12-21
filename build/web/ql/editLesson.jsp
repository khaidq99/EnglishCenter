<%-- 
    Document   : addLesson
    Created on : Nov 12, 2021, 11:10:23 AM
    Author     : KHAI-PC
--%>

<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="dao.*"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa buổi học</title>
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
        
        List<Shift> listShift = new ShiftDAO().getAllShift();
        List<Skill> listSkill = new SkillDAO().getAllSkill();
        
        List<Lesson> listLesson = (ArrayList<Lesson>)session.getAttribute("listLesson");
        Level level = (Level)session.getAttribute("level");
        
        int id = Integer.parseInt(request.getParameter("id"));
        Lesson lesson = listLesson.get(id-1);
        
        // get available room
        int branch_id = new BranchDAO().getBranchOfUser(user).getId();
        Date date = lesson.getDate();
        int shiftId = lesson.getShift().getId();
        List<Room> listRoom = new RoomDAO().findAvailableRoom(branch_id, date, shiftId);
        
        // find room in temporary list lesson
        List<Room> listUnavailableRoom = new ArrayList<Room>();
        for(Lesson l : listLesson){
            if(l.getDate().equals(date) && l.getShift().getId() == shiftId){
                Room room = l.getRoom();
                listUnavailableRoom.add(room);
            }
        }
    
        listRoom.removeAll(listUnavailableRoom);
        
        session.setAttribute("listLesson", listLesson);
        session.setAttribute("level", level);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    %>
    
    
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-3">
                    <h2>Sửa 1 buổi học</h2>
                    <form action="doEditLesson.jsp?id=<%= id %>" method="post">
                        <div class="form-group">
                            <label for="date">Ngày học: </label>
                            <input id="datepicker" class="date_shift" width="150" name="date" value="<%= sdf.format(lesson.getDate()) %>" />
                        </div>
                        <div class="form-group">
                            <label for="shift">Ca: </label>
                            <select class="form-control date_shift" id="shift" name="shift">
                                <option value="<%= lesson.getShift().getId() %>" selected> <%= lesson.getShift().getName()%> </option>
                                <% for (Shift shift : listShift) {%>
                                <% if(shift.getId() != lesson.getShift().getId()) {%>
                                <option value="<%= shift.getId() %>"><%= shift.getName() %></option>
                                <%}}
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="room">Phòng học: </label>
                            <select class="form-control" id="room" name="room">
                                <option value="<%= lesson.getRoom().getId() %>" selected> <%= lesson.getRoom().getName()%> </option>
                                    <% for (Room room : listRoom) {%>
                                    <% if(room.getId() != lesson.getRoom().getId()) {%>
                                    <option value="<%=room.getId()%>"><%=room.getName()%></option>
                                    <%}}
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="skill">Kĩ năng: </label>
                            <select class="form-control" id="skill" name="skill">
                                <option value="<%= lesson.getSkill().getId() %>" selected> <%= lesson.getSkill().getName()%> </option>
                                <% for (Skill skill : listSkill) {%>
                                <% if(skill.getId() != lesson.getSkill().getId()) {%>
                                <option value="<%=skill.getId()%>"><%=skill.getName()%></option>
                                <%}}
                                %>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">
                            Sửa
                        </button>
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
