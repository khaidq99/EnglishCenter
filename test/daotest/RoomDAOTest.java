/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotest;

import model.*;
import dao.*;
import java.text.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

public class RoomDAOTest {
    private RoomDAO roomDAO = new RoomDAO();
    
    
    /**
     * Co so ton tai phong trong trong khoang thoi gian chon
     */
    @Test
    public void testFindAvailableRoom1() throws ParseException{
        String strDate = "06/12/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        
        int shift_id = 1;
        int branch_id = 3;
        
        List<Room> listRoom = roomDAO.findAvailableRoom(branch_id, date, shift_id);
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(4, listRoom.size());
    }
    
    /**
     * Co so het phong trong trong khoang thoi gian chon
     */
    @Test
    public void testFindAvailableRoom2() throws ParseException{
        String strDate = "20/11/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        
        int shift_id = 1;
        int branch_id = 3;
        
        List<Room> listRoom = roomDAO.findAvailableRoom(branch_id, date, shift_id);
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(0, listRoom.size());
    }
    
    /**
     * Khong ton tai co so
     */
    @Test
    public void testFindAvailableRoom3() throws ParseException{
        String strDate = "20/11/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        
        int shift_id = 1;
        int branch_id = 1000;
        
        List<Room> listRoom = roomDAO.findAvailableRoom(branch_id, date, shift_id);
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(0, listRoom.size());
    }
    
    /**
     * Khong ton tai ca hoc
     */
    @Test
    public void testFindAvailableRoom4() throws ParseException{
        String strDate = "20/11/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(strDate);
        
        int shift_id = 1000;
        int branch_id = 3;
        
        List<Room> listRoom = roomDAO.findAvailableRoom(branch_id, date, shift_id);
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(0, listRoom.size());
    }
}
