package com;

import java.util.PriorityQueue;
import java.util.Queue;

public class AlgMain {

    public static void main(String[] args) {
        // ['a','b','c','d','f'] -> 'e'
        // ['O','Q','R','S'] -> 'P'
        // char[] arr = {'a', 'b', 'c', 'd', 'f'};
        char[] arr = {'O','Q','R','S'};
        Queue<Character> mark = new PriorityQueue<>();
        for (char c = arr[0]; c <= arr[arr.length - 1]; c++) {
            mark.add(c);
        }
        System.out.println("mark = " + mark);
        for (char c : arr) {
            // System.out.println(c + "," + mark.poll());
            char t = mark.poll();
            if (c != t) {
                System.out.println("miss: " + t);
                return;
            }
        }
    }

}
