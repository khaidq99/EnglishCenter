/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotest;
import java.util.*;
import dao.*;
import model.*;
import org.junit.*;

public class ShiftDAOTest {
    private ShiftDAO shiftDAO = new ShiftDAO();
    
    /**
     * Co it nhat 1 ca hoc
     */
    @Test
    public void testGetAllShift1(){
        List<Shift> listShift = shiftDAO.getAllShift();
        Assert.assertNotNull(listShift);
        Assert.assertEquals(3, listShift.size());
    }
}
