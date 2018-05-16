package edu.gcccd.csis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

public class MyProject2Test {

    private final NodeList<Integer> n1 = new NodeList<>();
    private final NodeList<Integer> n2 = new NodeList<>();
    private final NodeList<Integer> n3 = new NodeList<>();
    private final NodeList<Integer> n4 = new NodeList<>();
    private final NodeList<Integer> n10 = Project2.generateNumber(10);
    private final NodeList<Integer> n20 = Project2.generateNumber(20);
    private final NodeList<Integer> n30 = Project2.generateNumber(30);
    private final NodeList<Integer> n30x = Project2.generateNumber(30);

    private BigInteger bigInt;
    private NodeList<Integer> nodeList = new NodeList<>();
    private NodeList<Integer> nodeList1 = new NodeList<>();

    private BigInteger N20;
    private BigInteger N30;
    private BigInteger N30x;


    @Before
    public void setUp() {
        n2.append(1);
        n3.append(0);
        n3.append(0);
        n4.append(1);
        n4.append(2);
        n4.append(3);

        N20 = genBigInteger(n20);
        N30 = genBigInteger(n30);
        N30x = genBigInteger(n30x);
    }

    private static BigInteger genBigInteger(NodeList<Integer> nodeList) {
        if (nodeList.getLength() == 0) {
            return BigInteger.valueOf(0);
        }
        StringBuilder s = new StringBuilder();
        for (int node : nodeList) {
            s.append(String.valueOf(node));
        }
        return new BigInteger(String.valueOf(s));
    }

    @Test
    public void reverse() {

        //test 1 int nodeList;
        bigInt = BigInteger.valueOf(1);
        nodeList = MyProject2.reverse(n2.iterator(),n2);
        assertEquals(bigInt,genBigInteger(nodeList));

        //test basic case
        bigInt = BigInteger.valueOf(321);
        nodeList = MyProject2.reverse(n4.iterator(),n4);
        assertEquals(bigInt,genBigInteger(n4));

        //test null
        nodeList = MyProject2.reverse(n1.iterator(),n1);
        bigInt = BigInteger.valueOf(0);
        assertEquals(bigInt,genBigInteger(n1));
    }

    @Test
    public void addition() {
        final Project2 p = new MyProject2();

        //test same nodeList passed in.
        // nodeList = p.addition(n10, n10);
        //bigInt = N30.add(N30);
        //assertEquals(bigInt, genBigInteger(nodeList));

        //test null node handaling returns 0.
        bigInt = BigInteger.valueOf(0);
        nodeList = new MyProject2().addition(n1,n3);
        assertEquals(bigInt,genBigInteger(nodeList));

        //test removal of leading Zeros
        nodeList = p.addition(n1,n4);
        bigInt = BigInteger.valueOf(123);
        assertEquals(bigInt,genBigInteger(nodeList));

        // test removal of leading zeros returns 1.
        nodeList = p.addition(n1,n3);
        bigInt = genBigInteger(n1);
        assertEquals(bigInt,genBigInteger(nodeList));

        //test addition of two large numbers.
        nodeList = new MyProject2().addition(n30,n30x);
        bigInt = N30.add(N30x);
        assertEquals(bigInt,genBigInteger(nodeList));
    }

    @Test
    public void addition1() {
        final Project2 p = new MyProject2();
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();

        // test if list is null;
        nodeList = p.addition(listOfLists.iterator());
        bigInt = BigInteger.valueOf(0);
        assertEquals(bigInt,genBigInteger(nodeList));

        //test if list only has one nodeList
        listOfLists.append(n10);
        bigInt = genBigInteger(n10);
        nodeList = p.addition(listOfLists.iterator());
        assertEquals(bigInt,genBigInteger(nodeList));
        Project2.print(nodeList);

        //test adding 3 larg numbers in a list.
        listOfLists.append(n10);
        listOfLists.append(n20);
        listOfLists.append(n30);
        listOfLists.append(n30x);
        NodeList<Integer> nodeA = p.addition(listOfLists.iterator());
        bigInt = N20.add(N30);
        bigInt = bigInt.add(N30x);
        assertEquals(bigInt,genBigInteger(nodeA));
    }

    @Test
    public void save() {
        final Project2 p = new MyProject2();

        //saving null nodeList
        bigInt = genBigInteger(n1);
        p.save(n1,"result.bin");
        nodeList = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList));

        //save larg and load NodeList
        bigInt = genBigInteger(n10);
        p.save(n10,"result.bin");
        nodeList = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList));

        //test saving over file
        bigInt = genBigInteger(n30);
        p.save(n30,"result.bin");
        nodeList1 = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList1));
        Assert.assertTrue(genBigInteger(nodeList) != genBigInteger(nodeList1));
    }

    @Test
    public void load() {
        final Project2 p = new MyProject2();

        //load null nodeList
        bigInt = genBigInteger(n1);
        p.save(n1,"result.bin");
        nodeList = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList));

        //load large NodeList
        bigInt = genBigInteger(n10);
        p.save(n10,"result.bin");
        nodeList = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList));

        //test saving over file
        bigInt = genBigInteger(n30);
        p.save(n30,"result.bin");
        nodeList1 = p.load("result.bin");
        assertEquals(bigInt,genBigInteger(nodeList1));
        Assert.assertTrue(genBigInteger(nodeList) != genBigInteger(nodeList1));

    }
}