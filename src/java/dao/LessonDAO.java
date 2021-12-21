/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.*;
import java.util.*;
import java.text.*;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class LessonDAO extends DAO {

    public LessonDAO() {
    }
    
    public boolean saveScheduleForClass(List<Lesson> listLesson){
        if(listLesson == null || listLesson.isEmpty()){
            return false;
        }
        
        EnglishClass englishClass = listLesson.get(0).getEnglishClass();
        int numLesson = englishClass.getLevel().getNumberLesson();
        
        if(listLesson.size() > numLesson){
            return false;
        }
        
        String sqlAddEnglishClass = "INSERT INTO tbl_english_class(name, max_size, actual_size, "
                + "is_open, des, user_id, level_id) VALUES(?,?,?,?,?,?,?)";
        String sqlAddLesson = "INSERT INTO tbl_lesson(name, des, room_id, date, skill_id, shift_id, "
                + "english_class_id) VALUES(?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        boolean result = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddEnglishClass, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, englishClass.getName());
            ps.setInt(2, englishClass.getMaxSize());
            ps.setInt(3, englishClass.getActualSize());
            ps.setBoolean(4, englishClass.isOpen());
            ps.setString(5, englishClass.getDes());
            ps.setInt(6, englishClass.getUser().getId());
            ps.setInt(7, englishClass.getLevel().getId());
            
            ps.executeUpdate();			
            //get id of the new inserted booking
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int englishClassId = generatedKeys.getInt(1);
                for(Lesson lesson : listLesson){
                    PreparedStatement ps2 = con.prepareStatement(sqlAddLesson);
                    ps2.setString(1, lesson.getName());
                    ps2.setString(2, lesson.getDes());
                    ps2.setInt(3, lesson.getRoom().getId());
                    ps2.setString(4, sdf.format(lesson.getDate()));
                    ps2.setInt(5, lesson.getSkill().getId());
                    ps2.setInt(6, lesson.getShift().getId());
                    ps2.setInt(7, englishClassId);
                    
                    ps2.executeUpdate();		
                }
                // comment dong nay de chay che do Junit test
                con.commit();
                result = true;
            }
            
        } catch(Exception e){
            try {
                // comment dong nay de chay che do Junit test
                con.rollback();
                
            } catch (SQLException ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
            result = false;
        } finally {
            try {
                // comment dong nay de chay che do Junit test
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public List<Lesson> getLessonByEnglishClass(int englishClassId){
        List<Lesson> list = new ArrayList<>();;
        String sql = "SELECT * FROM tbl_lesson WHERE english_class_id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, englishClassId);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt("id"));
                lesson.setName(rs.getString("name"));
                lesson.setDes(rs.getString("des"));
                lesson.setDate(rs.getDate("date"));
                Room room = new RoomDAO().findById(rs.getInt("room_id"));
                Skill skill = new SkillDAO().findById(rs.getInt("skill_id"));
                Shift shift = new ShiftDAO().findById(rs.getInt("shift_id"));
                EnglishClass englishClass = new EnglishClassDAO().findById(rs.getInt("english_class_id"));
                lesson.setRoom(room);
                lesson.setShift(shift);
                lesson.setSkill(skill);
                lesson.setEnglishClass(englishClass);
                list.add(lesson);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
}
