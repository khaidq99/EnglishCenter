package daotest;
import java.util.*;
import dao.*;
import model.*;
import org.junit.*;

public class CurriculumDAOTest {
    private CurriculumDAO curriculumDAO = new CurriculumDAO();
    
    /**
     * Co it nhat 1 chuong trinh hoc
     */
    @Test
    public void testGetAllCurriculum1(){
        List<Curriculum> listCurriculum = curriculumDAO.getAllCurriculum();
        Assert.assertNotNull(listCurriculum);
        Assert.assertEquals(6, listCurriculum.size());
    }
}
