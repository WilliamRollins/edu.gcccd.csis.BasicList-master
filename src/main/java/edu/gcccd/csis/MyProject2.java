package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;

public class MyProject2 implements Project2 {

    public static NodeList<Integer> reverse(Iterator<Integer> iterator,NodeList<Integer> nodeList) {                    //reverse a NodeList
        if (nodeList.getLength() == 0 && nodeList.getLength() == 0) {
            NodeList<Integer> nodeList3 = new NodeList<>();
            nodeList3.append(0);
            return nodeList;
        }

        if (iterator.hasNext()) {
            int k = iterator.next();
            nodeList.remove(k);
            reverse(iterator,nodeList);
            nodeList.append(k);
        }
        return nodeList;
    }
    //add 2 nodeList
    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1,NodeList<Integer> nodeList2) {

        if (nodeList1.getLength() == 0 && nodeList2.getLength() == 0) {
            NodeList<Integer> nodeList3 = new NodeList<>();
            nodeList3.append(0);
            return nodeList1;
        }

        if (nodeList1 == nodeList2) {
            throw new IllegalArgumentException("can not pass in the same nodeList");
        }
//set k for loop count.
        int k = (nodeList1.getLength() > nodeList2.getLength()) ? nodeList1.getLength() : nodeList2.getLength();
//creats NodeList to hold totals.
        NodeList<Integer> nodeList3 = new NodeList<>();
//c is used to hold a carryover digit to the next node.
        int c = 0;
        reverse(nodeList1.iterator(),nodeList1);
//reverses nodeList to add from right to left.
        reverse(nodeList2.iterator(),nodeList2);
//reverses nodeList to add from right to left.
//for loop iterates through the for the length of the longest NodeList set by k.
        for (int i = 0; i < k; i++) {
            int n1 = 0; //nodeList1 int value of current head
            int n2 = 0; //nodeList2 int value of current head
            int n3;
//gets the int value of the current node head of nodelist1 then removes it.
//gets the int value of the current node head of nodelist1 then removes it.
            for (int node1 : nodeList1) {
                nodeList1.remove(node1);
                n1 = node1;
                break;
            }
//gets the int value of the current node head of nodelist1 then removes it.
//*Node: break out for loop on purpose.
            for (int node2 : nodeList2) {
                nodeList2.remove(node2);
                n2 = node2;
                break;
            }
//sets int n3 to be added to the NodeList nodeList3. Node* c is = 0 the 1st iteration.
            n3 = n1 + n2 + c;
//if n3 is greater than three and there is a node Left to added. preform "carry the one'
            if (n3 > 9 && nodeList1.getLength() > 0 || n3 > 9 && nodeList2.getLength() > 0) {
                n3 -= 10;
                c = 1;
            } else {
                c = 0;
            }
//append n3 to the nodeList.
            nodeList3.append(n3);
        }
//reverse the nodeList3 so it may be read left to right.
        reverse(nodeList3.iterator(),nodeList3);
        Project2.print(nodeList3);
        return nodeList3;
    }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        NodeList<Integer> nodeListTotal = new NodeList<>();
        nodeListTotal.append(0);
//adds current nodeList total with the next NodeList in the iterator  variable.
        while (iterator.hasNext()) {
            nodeListTotal = addition(iterator.next(),nodeListTotal);
        }
        return nodeListTotal;
    }

    @Override
    public void save(NodeList<Integer> nodeList,String fileName) {
        try {
//creates new BufferWriter with a destination of the filename variable.
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//loops through nodeList var and writes x to file
            for (int x : nodeList) {
                writer.write(x);
                nodeList.remove(x);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NodeList<Integer> load(String fileName) {
        NodeList<Integer> nodeList = new NodeList<>();
        try {
//creates new buffer reader from fileName var.
            BufferedReader in = new BufferedReader(new FileReader(fileName));
//checks to see if file has anything left. if not return -1.
            int nextVal = in.read();
//reads next value of file and appends to nodeList.
            while (nextVal != -1) {
                nodeList.append(nextVal);
                nextVal = in.read();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodeList;
    }


    public static void main(final String[] args) {

        final int L = 3;
        final NodeList<Integer> n1 = Project2.generateNumber(L);
        final NodeList<Integer> n2 = Project2.generateNumber(L);
        final Project2 p = new MyProject2();
        Project2.print(p.addition(n1,n2)); //  n1+n2, e.g. 4139
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < L; i++) {
            listOfLists.append(Project2.generateNumber(L));
        }
        p.save(p.addition(listOfLists.iterator()),"result.bin");
        System.out.println("Loading: ");
        Project2.print(p.load("result.bin"));
    }
}