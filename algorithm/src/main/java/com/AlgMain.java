package com;

import java.util.*;
import java.util.stream.Collectors;

public class AlgMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2, 3, 4);
        System.out.println("list = " + list);
        list.add(1, -1);
        System.out.println("list = " + list);
    }

}
