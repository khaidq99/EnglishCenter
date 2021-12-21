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

public class SkillDAOTest {
    private SkillDAO skillDAO = new SkillDAO();
    
    /**
     * Co it nhat 1 ki nang
     */
    @Test
    public void testGetAllSkill1(){
        List<Skill> listSkill = skillDAO.getAllSkill();
        Assert.assertNotNull(listSkill);
        Assert.assertEquals(4, listSkill.size());
    }
}
