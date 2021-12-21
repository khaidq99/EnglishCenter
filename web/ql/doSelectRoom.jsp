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
    
    // find room in DB
    int branch_id = new BranchDAO().getBranchOfUser(user).getId();
    String dateString = request.getParameter("date");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date date = sdf.parse(dateString);
    int shiftId = Integer.parseInt(request.getParameter("shift_id"));
    List<Room> listRoom = new RoomDAO().findAvailableRoom(branch_id, date, shiftId);
    if(listRoom == null) listRoom = new ArrayList<Room>();
    List<Lesson> listLesson = (ArrayList<Lesson>)session.getAttribute("listLesson");
    
    // find room in temporary list lesson
    List<Room> listUnavailableRoom = new ArrayList<Room>();
    for(Lesson lesson : listLesson){
        if(lesson.getDate().equals(date) && lesson.getShift().getId() == shiftId){
            Room room = lesson.getRoom();
            listUnavailableRoom.add(room);
        }
    }
    
    listRoom.removeAll(listUnavailableRoom);
    // convert Java object to JSON
    String json = new Gson().toJson(listRoom);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>
