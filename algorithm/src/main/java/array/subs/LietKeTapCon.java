package array.subs;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Tìm tất cả các tập con (2^n)

    int allMasks = (1 << N);
    for (int i = 1; i < allMasks; i++) {
        for (int j = 0; j < N; j++) {
            if ((i & (1 << j)) > 0) { // The j-th element is used
               System.out.print((j + 1) + " ");
            }
        }
        System.out.println();
    }

    Here are all bitmasks:
        1 = 001 = {1}
        2 = 010 = {2}
        3 = 011 = {1, 2}
        4 = 100 = {3}
        5 = 101 = {1, 3}
        6 = 110 = {2, 3}
        7 = 111 = {1, 2, 3}
 */
public class LietKeTapCon {

    // Print all subsets of given array
    public static void generateSubsets_1(int[] arr) {
        int n = arr.length;
        int allMasks = 1 << n; // 2^n subsets
        for (int bit = 0; bit < allMasks; bit++) {
            var subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // (1 << j) is a number with j-th bit 1 so when we 'and' them with the subset
                // number we get which numbers are present in the subset and which are not
                if ((bit & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }
            System.out.println(subset);
        }
    }

    // Function to generate all subsets of an array with a specified size using bitwise operations
    public static void generateSubsets_3(int[] arr, int k) {
        int n = arr.length;
        int totalSubsets = 1 << n; // Total number of subsets is 2^n
        for (int i = 0; i < totalSubsets; i++) {
            // Count the number of set bits in the current subset bitmask
            int count = Integer.bitCount(i);
            if (count == k) {
                // Include elements in the subset
                var subset = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(arr[j]);
                    }
                }
                // System.out.print("Subset thứ " + (i + 1) + ": {");
                System.out.println("subset = " + subset);
            }
        }
    }

    // Find all subset using recursive (backtrack)
    public static void backtrack(int[] arr, int start, int end) {
        if (end == arr.length) {
            return; // Base case: Reached end of array
        } else if (start > end) {
            backtrack(arr, 0, end + 1);
        } else {
            int[] sub = Arrays.copyOfRange(arr, start, end + 1);
            System.out.println(Arrays.toString(sub));
            backtrack(arr, start + 1, end);
        }
    }

    public static void generateSubsets_2(int[] arr) {
        backtrack(arr, 0, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // generateSubsets_1(arr); // Show all
        generateSubsets_2(arr); // Chỉ lấy tập con có 3 phần tử
        // generateSubsets_3(arr, 3); // Chỉ lấy tập con có 3 phần tử
    }

}
