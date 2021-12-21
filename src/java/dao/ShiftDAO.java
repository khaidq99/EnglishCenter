/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.*;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class ShiftDAO extends DAO {
    public ShiftDAO(){
    }
    
    public Shift findById(int id){
        Shift shift = null;
        String sql = "SELECT * FROM tbl_shift WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                shift = new Shift();
                shift.setId(rs.getInt("id"));
                shift.setName(rs.getString("name"));
                shift.setStartTime(rs.getDate("start_time"));
                shift.setStartTime(rs.getDate("end_time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return shift;
    }
    
    public List<Shift> getAllShift(){
        List<Shift> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_shift";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
             
            while(rs.next()){
                Shift shift = new Shift();
                shift.setId(rs.getInt("id"));
                shift.setName(rs.getString("name"));
                shift.setStartTime(rs.getDate("start_time"));
                shift.setEndTime(rs.getDate("end_time"));
                list.add(shift);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
}
