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
public class EnglishClassDAO extends DAO {

    public EnglishClassDAO() {
    }
    
    public EnglishClass findById(int id){
        EnglishClass englishClass = null;
        String sql = "SELECT * FROM tbl_english_class WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                englishClass = new EnglishClass();
                englishClass.setId(rs.getInt("id"));
                englishClass.setName(rs.getString("name"));
                englishClass.setMaxSize(rs.getInt("max_size"));
                englishClass.setActualSize(rs.getInt("actual_size"));
                englishClass.setOpen(rs.getBoolean("is_open"));
                englishClass.setDes(rs.getString("des"));
                User user = new User();
                user.setId(rs.getInt("user_id"));
                Level level = new LevelDAO().findById(rs.getInt("level_id"));
                englishClass.setUser(user);
                englishClass.setLevel(level);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return englishClass;
    }
}
