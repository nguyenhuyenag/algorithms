package sort;

import java.util.*;

/**
 * Sắp xêp mảng theo số lần xuất hiện của các phần tử
 */
public class SortByFrequency {

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 5, 8, 4, 0, 0};
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int v : arr) {
            numCount.put(v, numCount.getOrDefault(v, 0) + 1);
        }
        // Sort 1
        List<Integer> result1 = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(numCount::get))
                .toList();
        // Sort 2
        List<Integer> result2 = Arrays.stream(arr)
                .boxed()
                .sorted((u, v) -> {
                    int compareByFrequency = numCount.get(u) - numCount.get(v);
                    return compareByFrequency != 0 ? compareByFrequency : u - v;
                })
                // .sorted(Comparator.comparingInt((Integer u) -> numCount.get(u)).thenComparingInt(u -> u))
                .toList();
        System.out.println("numCount = " + numCount);
        System.out.println("result1 = " + Arrays.toString(result1.toArray()));
        System.out.println("result2 = " + Arrays.toString(result2.toArray()));
    }

}
