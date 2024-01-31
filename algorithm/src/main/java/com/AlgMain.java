package com;

import java.util.*;
import java.util.stream.Collectors;

public class AlgMain {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7, 8};
        List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        list1.retainAll(list2);
        System.out.println("list1 = " + list1);
    }

}
