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
public class EnglishCenterDAO extends DAO {
    public EnglishCenterDAO(){
    }
    
    public EnglishCenter findById(int id){
        EnglishCenter englishCenter = null;
        String sql = "SELECT * FROM tbl_english_center WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                englishCenter = new EnglishCenter();
                englishCenter.setId(id);
                englishCenter.setName(rs.getString("name"));
                englishCenter.setSlogan(rs.getString("slogan"));
                englishCenter.setDes(rs.getString("des"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return englishCenter;
    }
}
