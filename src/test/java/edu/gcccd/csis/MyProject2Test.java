package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyProject2Test {

    @Before
    public void setUp() throws Exception {
        final Project2 p = new MyProject2();
        final NodeList<Integer> n1 = new NodeList<>();
        final NodeList<Integer> n2 = new NodeList<>();
        n1.append(9);

        int k = 2;
        for (int i = 0; i < k; i++) {
            n2.append(9);
        }
    }

    @Test
    public void reverse() {
        //reverse 1 = 1;
        //reverse 12=21
        //reverse 123=321
        //reverse 000=000
    }

    @Test
    public void addition() {
//test both nodeList are null
        final Project2 p = new MyProject2();
        NodeList<Integer> nEmpty =new NodeList<>();
        NodeList<Integer> n0=new NodeList<>();
        NodeList<Integer> n9=new NodeList<>();
        NodeList<Integer> n99=new NodeList<>();
        n0.append(0);
        n9.append(0);n9.append(9);
        n99. append(9); n99. append(9);
        Project2.print(n0);

        // test one node list is null
        //assertEquals("node 1 and 2 can not be empty", p.addition(nEmpty,nEmpty));
        //test no leading 0's
        assertEquals(9, String.valueOf(p.addition(n0, n9)));
        //test 9+9=18
        assertEquals(18, String.valueOf(p.addition(n9, n9)));
        //test 9+99=108
        assertEquals(108, String.valueOf(p.addition(n9, n99)));
        //0+0=0
        assertEquals(0, String.valueOf(p.addition(n0, n0)));
    }

    @Test
    public void addition1() {
    // test if list is null;
    //test if list only has one nodeList
    //test if 0+9=9
    //test if 9+9+9=27
    //test if 0+9+99=108;
    }

    @Test
    public void save() {
        // save null NodeList
        //save larg NodeList
    }

    @Test
    public void load() {
        //load file not there
        //load file open;
        //load large NodeList;
    }
}