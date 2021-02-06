/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mili Risal
 */
public class GiveExamTest {
    
    public GiveExamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setnext method, of class GiveExam.
     */
    @Test
    public void testSetnext() {
        System.out.println("setnext");
        GiveExam instance = new GiveExam();
        instance.setnext();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class GiveExam.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        GiveExam instance = new GiveExam();
        instance.check();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of showAnswerKey method, of class GiveExam.
     */
    @Test
    public void testShowAnswerKey() {
        System.out.println("showAnswerKey");
        GiveExam instance = new GiveExam();
        instance.showAnswerKey();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class GiveExam.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        GiveExam instance = new GiveExam();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
