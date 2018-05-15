package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyProject2Test {

    final Project2 p = new MyProject2();
    final NodeList<Integer> nEmpty = new NodeList<>();
    final NodeList<Integer> n0 = new NodeList<>();
    final NodeList<Integer> n1 = new NodeList<>();
    final NodeList<Integer> n2 = new NodeList<>();
    final NodeList<Integer> n3 = new NodeList<>();
    final NodeList<Integer> n9 = new NodeList<>();
    final NodeList<Integer> n99 = new NodeList<>();
n0.append(0);n0.append(0);n0.append(0);
n1.append(1);
n2.append(1); n2.append(2);
n3.append(1);n3.append(2);n3.append(3);
n9.append(9);
n99.append(9);n99.append(9);
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void reverse() {
        n0.append(0);n0.append(0);n0.append(0);
        n1.append(1);
        n2.append(1); n2.append(2);
        n3.append(1);n3.append(2);n3.append(3);

        //reverse 1 = 1;
        MyProject2.reverse(n1.iterator(), n1);
        //reverse 1,2=2,1
        MyProject2.reverse(n2.iterator(), n2);
        //reverse 123=321
        MyProject2.reverse(n3.iterator(), n3);
        //reverse 000=000
        MyProject2.reverse(n0.iterator(), n0);
    }

    @Test
    public void addition() {
//test both nodeList are null
        final Project2 p = new MyProject2();


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