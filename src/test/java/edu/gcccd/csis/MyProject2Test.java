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
        n9.append(9);
        n99. append(9); n99. append(9);

        // test one node list is null
        assertEquals("node 1 and 2 can not be empty", p.addition(nEmpty,nEmpty));
        //test no leading 0's
        //test 9+9=18
        //test 9+99=108
        //0+0=0
    }

    @Test
    public void addition1() {

    }

    @Test
    public void save() {

    }

    @Test
    public void load() {

    }
}