package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgMain {

	public static List<List<Integer>> splitArray(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int element : arr) {
            if (!uniqueElements.add(element)) {
                result.add(new ArrayList<>(uniqueElements));
                uniqueElements.clear();
            }
        }
        
        if (!uniqueElements.isEmpty()) {
            result.add(new ArrayList<>(uniqueElements));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] myArray = {1,3,4,1,2,3,1};
        List<List<Integer>> result = splitArray(myArray);

        // Print the result
        result.forEach(System.out::println);
    }

}
