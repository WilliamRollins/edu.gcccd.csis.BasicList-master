package edu.gcccd.csis;

import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;

//reverse a nodeList
public class MyProject2 implements Project2 {
    public static NodeList<Integer> reverse(Iterator<Integer> iterator, NodeList<Integer> nodeList) {
        if (iterator.hasNext()) {
            int k = iterator.next();
            nodeList.remove(k);
            reverse(iterator, nodeList);
            nodeList.append(k);
        }
        return nodeList;
    }

    //add 2 nodeList
    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
       if (nodeList1==null && nodeList2==null){
           throw new IllegalArgumentException("node 1 or 2 can not be empty");
       }
        NodeList<Integer> nodeListTotal = new NodeList<>();
        reverse(nodeList1.iterator(), nodeList1);
        reverse(nodeList2.iterator(), nodeList2);
        int c = 0;
        for (int a : nodeList1) {
            nodeList1.remove(a);
            for (int b : nodeList2) {
                nodeList2.remove(b);
                int nodeTotal = a + b + c;
                if (nodeTotal > 9 && nodeList1.getLength() > 0 || (nodeTotal > 9 && nodeList2.getLength() > 0)) {
                    nodeTotal -= 10;
                    c = 1;
                }
                nodeListTotal.append(nodeTotal);
                if (nodeList1.getLength() == 0 && nodeList2.getLength() > 0) {
                    for (int B : nodeList2) {
                        nodeList2.remove(B);
                        if (B + c > 9 && nodeList2.getLength() > 0) {
                            B -= 10;
                            c = 1;
                        }else{c=0;}
                        B+=c;
                        nodeListTotal.append(B);
                    } }
                if (nodeList2.getLength() == 0 && nodeList1.getLength() > 0) {
                    for (int A : nodeList1) {
                        nodeList1.remove(A);
                        if (A + c > 9 && nodeList1.getLength() > 0) {
                            A -= 10;
                            c = 1;
                        }else{c=0;}
                        A+=c;
                        nodeListTotal.append(A);
                    } }
                break;
            } }
        reverse(nodeListTotal.iterator(), nodeListTotal);
        return nodeListTotal;
    }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        NodeList<Integer> nodeListTotal = new NodeList<>();
        nodeListTotal.append(0);
        while (iterator.hasNext()) {
            nodeListTotal = addition(iterator.next(), nodeListTotal);
            System.out.print("NT=: ");
            Project2.print(nodeListTotal);
        }
        System.out.print("nodeListTotal: ");
        Project2.print(nodeListTotal);
        return nodeListTotal;
    }

    @Override
    public void save(NodeList<Integer> nodeList, String fileName)  {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (int x : nodeList) {
                    writer.write(Integer.toString(x), 0,1);
                    nodeList.remove(x);
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public NodeList<Integer> load(String fileName) {
        NodeList<Integer> nodeList = new NodeList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            int nextVal = in.read();
            while (nextVal != -1) {
                nodeList.append(nextVal);
                nextVal = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return nodeList;
    }

    public static void main(final String[] args) {
        final int L = 30;

        final NodeList<Integer> n1 = Project2.generateNumber(L); // (head 1st) e.g. 3457
        final NodeList<Integer> n2 = Project2.generateNumber(L); // (head 1st) e.g. 682
        final Project2 p = new MyProject2();

        Project2.print(p.addition(n1, n2)); //  n1+n2, e.g. 4139

        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < L; i++) {
            listOfLists.append(Project2.generateNumber(L));
        }
        p.save(p.addition(listOfLists.iterator()), "result.txt");
        System.out.println("Loading: ");
        Project2.print(p.load("result.txt"));
    }
}