/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class UserDAO extends DAO {

    public UserDAO() {
    }
    
    public boolean checkLogin(User u){
        boolean kq = false;
        if(u.getUsername().contains("true") || u.getUsername().contains("=")||
           u.getPassword().contains("true") || u.getPassword().contains("=")){
            return false;
        }
        String sql = "SELECT * FROM tbl_user WHERE username = ? AND password = ?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, u.getUsername());
            cs.setString(2, u.getPassword());
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setRole(rs.getString("role"));
                //Fullname
                Fullname fullname = new FullnameDAO().findById(rs.getInt("fullname_id"));
                u.setFullname(fullname);
                // Address
                Address address = new AddressDAO().findById(rs.getInt("address_id"));
                u.setAddress(address);
                kq = true;
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
}
