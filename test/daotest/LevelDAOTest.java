package daotest;
import java.util.*;
import dao.*;
import model.*;
import org.junit.*;

public class LevelDAOTest {
    private LevelDAO levelDAO = new LevelDAO();
    
    /**
     * Ton tai chuong trinh, ton tai muc do
     */
    @Test
    public void testGetLevelByCurri1(){
        int curri_id = 3;
        List<Level> listLevel = levelDAO.getLevelByCurri(curri_id);
        
        Assert.assertNotNull(listLevel);
        Assert.assertEquals(3, listLevel.size());
        Assert.assertEquals(curri_id, listLevel.get(0).getCurri().getId());
    }
    
    /**
     * Ton tai chuong trinh, khong ton tai muc do
     */
    @Test
    public void testGetLevelByCurri2(){
        int curri_id = 8;
        List<Level> listLevel = levelDAO.getLevelByCurri(curri_id);
        
        Assert.assertNotNull(listLevel);
        Assert.assertEquals(0, listLevel.size());
    }
    
    /**
     * Khong tai chuong trinh
     */
    @Test
    public void testGetLevelByCurri3(){
        int curri_id = 1000;
        List<Level> listLevel = levelDAO.getLevelByCurri(curri_id);
        
        Assert.assertNotNull(listLevel);
        Assert.assertEquals(0, listLevel.size());
    }
    
}
