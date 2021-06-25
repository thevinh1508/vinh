/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import entity.Student;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class MarkGroupByClassTest {
    MarkGroupByClass search;
    
    
    public MarkGroupByClassTest() {
        search = new MarkGroupByClass();
    }

    @Test
    public void testShowInfoStudent(List<Student> list) {
       // assertEquals(search.showInfoStudent(list), "Class not Found!!");
    }
    
}
