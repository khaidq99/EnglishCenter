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
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class BranchDAO extends DAO {

    public BranchDAO() {
    }
    
    public Branch getBranchOfUser(User user){
        Branch branch = null;
        String sql = "SELECT * FROM tbl_branch WHERE id IN (SELECT branch_id FROM tbl_user WHERE id = ?)";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, user.getId());
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                branch = new Branch();
                branch.setId(rs.getInt("id"));
                branch.setName(rs.getString("name"));
                branch.setName(rs.getString("des"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return branch;
    }
    
}
