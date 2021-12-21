/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import com.sun.jmx.remote.internal.ArrayQueue;
import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author KHAI-PC
 */
public class RoomDAO extends DAO {
    public RoomDAO(){
    }
    
    public Room findById(int id){
        Room room = null;
        String sql = "SELECT * FROM tbl_room WHERE id = ?";
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setCapacity(rs.getInt("capacity"));
                room.setDes(rs.getString("des"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return room;
    }
    
    public List<Room> findAvailableRoom(int branch_id, Date date, int shift_id){
        // if shift_id doesn't exitst in DB
        Shift shift = new ShiftDAO().findById(shift_id);
        if(shift == null){
            return new ArrayList<>();
        }
        
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_room r WHERE branch_id = ? AND r.id NOT IN "
                + "(SELECT l.room_id FROM tbl_lesson l "
                + "INNER JOIN tbl_shift sh "
                + "ON l.shift_id = sh.id "
                + "WHERE date = ? AND sh.id = ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, branch_id);
            cs.setString(2, sdf.format(date));
            cs.setInt(3, shift_id);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setCapacity(rs.getInt("capacity"));
                room.setDes(rs.getString("des"));
                list.add(room);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
}
