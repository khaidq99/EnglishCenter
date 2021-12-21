/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class FullnameDAO extends DAO {

    public FullnameDAO() {
    }
    
    public Fullname findById(int id){
        Fullname fullname = null;
        String sql = "SELECT * FROM tbl_fullname WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                fullname = new Fullname();
                fullname.setId(id);
                fullname.setFirstName(rs.getString("first_name"));
                fullname.setMidName(rs.getString("mid_name"));
                fullname.setLastName(rs.getString("last_name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fullname; 
    }
}
