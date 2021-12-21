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
import java.util.*;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class SkillDAO extends DAO {
    
    public SkillDAO(){
    }
    
    public Skill findById(int id){
        Skill skill = null;
        String sql = "SELECT * FROM tbl_skill WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return skill;
    }
    
    public List<Skill> getAllSkill(){
        List<Skill> list = null;
        String sql = "SELECT * FROM tbl_skill";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
             
            while(rs.next()){
                if(list == null) list = new ArrayList<>();
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
                list.add(skill);
            }
        }catch(Exception e){
            e.printStackTrace();
            list = null;
        }
        
        return list;
    }
}
