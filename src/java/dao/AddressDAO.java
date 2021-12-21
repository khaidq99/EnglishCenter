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
public class AddressDAO extends DAO {

    public AddressDAO() {
    }
    
    public Address findById(int id){
        Address address = null;
        String sql = "SELECT * FROM tbl_address WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                address = new Address();
                address.setId(id);
                address.setNumber(rs.getString("number"));
                address.setStreet(rs.getString("street"));
                address.setDistrict(rs.getString("district"));
                address.setCity(rs.getString("city"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return address;
    }
}
