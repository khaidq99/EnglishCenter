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

/**
 *
 * @author KHAI-PC
 */
public class CurriculumDAO extends DAO {

    public CurriculumDAO() {
    }
    
    public List<Curriculum> getAllCurriculum(){
        List<Curriculum> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_curriculum";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
             
            while(rs.next()){
                Curriculum curri = new Curriculum();
                curri.setId(rs.getInt("id"));
                curri.setName(rs.getString("name"));
                list.add(curri);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public Curriculum findById(int id){
        Curriculum curri = null;
        String sql = "SELECT * FROM tbl_curriculum WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                curri = new Curriculum();
                curri.setId(rs.getInt("id"));
                curri.setName(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return curri;
    }
}
