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
    
    // get params
    String dateString = request.getParameter("date");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date date = sdf.parse(dateString);
    int shiftId = Integer.parseInt(request.getParameter("shift"));
    int roomId = Integer.parseInt(request.getParameter("room"));
    int skillId = Integer.parseInt(request.getParameter("skill"));
    
    Shift shift = new ShiftDAO().findById(shiftId);
    Room room = new RoomDAO().findById(roomId);
    Skill skill = new SkillDAO().findById(skillId);
    
    lesson.setDate(date);
    lesson.setShift(shift);
    lesson.setRoom(room);
    lesson.setSkill(skill);
    
    session.setAttribute("listLesson", listLesson);
    session.setAttribute("level", level);
    response.sendRedirect("scheduleLesson.jsp?action=edit");
%>
