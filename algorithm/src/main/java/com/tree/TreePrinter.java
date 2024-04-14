//package com.tree;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class TreePrinter {
//
//    int N, height;
//    Node root = new Node(1, null, null);
//
//    public static void main(String[] args) {
//        new TreePrinter();
//    }
//
//    public TreePrinter() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            N = Integer.parseInt(br.readLine());
//            ArrayList<Node> q = new ArrayList<Node>();
//            q.add(root);
//            for (int i = 0; i < N && !q.isEmpty(); i++) {
//                String ab[] = br.readLine().split(" ");
//                int a = Integer.parseInt(ab[0]);
//                int b = Integer.parseInt(ab[1]);
//                Node current = q.remove(0);
//                if (a == -1) current.left = null;
//                else {
//                    current.left = new Node(a, null, null);
//                    q.add(current.left);
//                }
//
//                if (b == -1) current.right = null;
//                else {
//                    current.right = new Node(b, null, null);
//                    q.add(current.right);
//                }
//            }
//            //root.print();
//            height = root.getHeight();
//            root.prettyPrint(height);
//
//        } catch (NumberFormatException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
