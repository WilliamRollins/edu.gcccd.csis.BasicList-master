package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyProject2Test {

    @Before
    public void setUp() throws Exception {
        final Project2 p = new MyProject2();
        final NodeList<Integer> n1 = new NodeList<>();
        final NodeList<Integer> n2 = new NodeList<>();

            n1.append(9);

        int k=2;
        for (int i=0; i<k; i++){
            n2.append(9);
        }
    }

    @Test
    public void reverse() {
        final Project2 p = new MyProject2();
        final NodeList<Integer> n1 = new NodeList<>();
        final NodeList<Integer> n2 = new NodeList<>();
        System.out.println(p.addition(n1,n2));
        assertEquals(p.addition(n1,n2),"node 1 or 2 can not be empty" );
    }

    @Test
    public void addition() {

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