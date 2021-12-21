/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Curriculum;
import model.Level;

/**
 *
 * @author KHAI-PC
 */
public class LevelDAO extends DAO {

    public LevelDAO() {
    }
    
    public List<Level> getLevelByCurri(int curri_id){
        List<Level> list = new ArrayList<>();;
        String sql = "SELECT * FROM tbl_level WHERE curriculum_id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, curri_id);
            ResultSet rs = cs.executeQuery();
            
            Curriculum curri = new CurriculumDAO().findById(curri_id);
             
            while(rs.next()){
                Level level = new Level();
                level.setId(rs.getInt("id"));
                level.setName(rs.getString("name"));
                level.setNumberLesson(rs.getInt("number_lesson"));
                level.setDes(rs.getString("des"));
                level.setCurri(curri);
                list.add(level);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public Level findById(int id){
        Level level = null;
        String sql = "SELECT * FROM tbl_level WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                level = new Level();
                level.setId(id);
                level.setName(rs.getString("name"));
                level.setNumberLesson(rs.getInt("number_lesson"));
                level.setDes(rs.getString("des"));
                Curriculum curri = new CurriculumDAO().findById(rs.getInt("curriculum_id"));
                level.setCurri(curri);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return level;
    }
}
