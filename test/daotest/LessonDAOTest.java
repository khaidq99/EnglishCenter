/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotest;
import java.util.*;
import java.text.*;
import dao.*;
import static dao.DAO.con;
import model.*;
import org.junit.*;

public class LessonDAOTest {
    private LessonDAO lessonDAO = new LessonDAO();
    
    /**
     * DK moi du so buoi hoc cua chuong trinh hoc
     */
    @Test
    public void testSaveScheduleForClass1() throws ParseException{
        User user = new User();
        user.setId(3);
        int levelId = 5;
        Level level = new LevelDAO().findById(levelId);
        EnglishClass englishClass = new EnglishClass("IELTS 5.5", 40, 0, true, "", user, level);
        
        List<Lesson> listLesson = new ArrayList<>();
        // add lesson 1
        Lesson lesson1 = new Lesson();
        String strDate = "15/12/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        Room room = new Room();
        room.setId(1);
        Skill skill = new Skill();
        skill.setId(1);
        Shift shift = new Shift();
        shift.setId(1);
        lesson1.setDate(date);
        lesson1.setRoom(room);
        lesson1.setShift(shift);
        lesson1.setSkill(skill);
        lesson1.setEnglishClass(englishClass);
        
        // add lesson 2
        Lesson lesson2 = new Lesson();
        String strDate2 = "22/12/2021";
        Date date2 = sdf.parse(strDate2);
        Room room2 = new Room();
        room2.setId(1);
        Skill skill2 = new Skill();
        skill2.setId(1);
        Shift shift2 = new Shift();
        shift2.setId(1);
        lesson2.setDate(date2);
        lesson2.setRoom(room2);
        lesson2.setShift(shift2);
        lesson2.setSkill(skill2);
        lesson2.setEnglishClass(englishClass);
        
        listLesson.add(lesson1);
        listLesson.add(lesson2);
        
        try {
            con.setAutoCommit(false);
            boolean result = lessonDAO.saveScheduleForClass(listLesson);
            Assert.assertTrue(result);
            
            // lay ra kiem tra
            // last: 20
            int englishClassId = 20;
            List<Lesson> listAdded = lessonDAO.getLessonByEnglishClass(englishClassId);
            Assert.assertNotNull(listAdded);
            Assert.assertEquals(2, listAdded.size());
            Assert.assertEquals(englishClassId, listAdded.get(0).getEnglishClass().getId());
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * DK moi khong co buoi hoc nao
     */
    @Test
    public void testSaveScheduleForClass2(){
        User user = new User();
        user.setId(3);
        int levelId = 5;
        Level level = new LevelDAO().findById(levelId);
        EnglishClass englishClass = new EnglishClass("IELTS 5.5", 40, 0, true, "", user, level);
        
        List<Lesson> listLesson = null;
        try {
            con.setAutoCommit(false);
            boolean result = lessonDAO.saveScheduleForClass(listLesson);
            Assert.assertFalse(result);
     
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * DK moi khong co buoi hoc nao
     */
    @Test
    public void testSaveScheduleForClass3(){
        User user = new User();
        user.setId(3);
        int levelId = 5;
        Level level = new LevelDAO().findById(levelId);
        EnglishClass englishClass = new EnglishClass("IELTS 5.5", 40, 0, true, "", user, level);
        
        List<Lesson> listLesson = new ArrayList<>();
        try {
            con.setAutoCommit(false);
            boolean result = lessonDAO.saveScheduleForClass(listLesson);
            Assert.assertFalse(result);
     
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * DK moi co nhieu buoi hoc hon chuong trinh hoc
     */
    @Test
    public void testSaveScheduleForClass4() throws ParseException{
        User user = new User();
        user.setId(3);
        int levelId = 5;
        Level level = new LevelDAO().findById(levelId);
        EnglishClass englishClass = new EnglishClass("IELTS 5.5", 40, 0, true, "", user, level);
        
        List<Lesson> listLesson = new ArrayList<>();
        // add lesson 1
        Lesson lesson1 = new Lesson();
        String strDate = "15/12/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        Room room = new Room();
        room.setId(1);
        Skill skill = new Skill();
        skill.setId(1);
        Shift shift = new Shift();
        shift.setId(1);
        lesson1.setDate(date);
        lesson1.setRoom(room);
        lesson1.setShift(shift);
        lesson1.setSkill(skill);
        lesson1.setEnglishClass(englishClass);
        
        // add lesson 2
        Lesson lesson2 = new Lesson();
        String strDate2 = "22/12/2021";
        Date date2 = sdf.parse(strDate2);
        Room room2 = new Room();
        room2.setId(1);
        Skill skill2 = new Skill();
        skill2.setId(1);
        Shift shift2 = new Shift();
        shift2.setId(1);
        lesson2.setDate(date2);
        lesson2.setRoom(room2);
        lesson2.setShift(shift2);
        lesson2.setSkill(skill2);
        lesson2.setEnglishClass(englishClass);
        
        // add lesson 3
        Lesson lesson3 = new Lesson();
        String strDate3 = "29/12/2021";
        Date date3 = sdf.parse(strDate3);
        Room room3 = new Room();
        room3.setId(1);
        Skill skill3 = new Skill();
        skill3.setId(1);
        Shift shift3 = new Shift();
        shift3.setId(1);
        lesson3.setDate(date3);
        lesson3.setRoom(room3);
        lesson3.setShift(shift3);
        lesson3.setSkill(skill3);
        lesson3.setEnglishClass(englishClass);
        
        listLesson.add(lesson1);
        listLesson.add(lesson2);
        listLesson.add(lesson3);
        
        try {
            con.setAutoCommit(false);
            boolean result = lessonDAO.saveScheduleForClass(listLesson);
            Assert.assertFalse(result);
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
