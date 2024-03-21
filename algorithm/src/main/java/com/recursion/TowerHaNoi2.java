package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerHaNoi2 {

    public static void main(String[] args) {
        List<List<Integer>> towers = new ArrayList<>();

        // Initialize the towers
        for (int i = 0; i < 3; i++) {
            towers.add(new ArrayList<>());
        }

        int nDisc = 3; // Number of discs
        // Add discs to the first tower
        for (int i = nDisc; i > 0; i--) {
            towers.get(0).add(i);
        }

        // Print initial state
        printTowers(towers);

        // Move discs from tower 1 to tower 3 using tower 2 as auxiliary
        moveTower(nDisc, towers, 0, 1, 2);
    }

    private static void moveTower(int n, List<List<Integer>> towers, int A, int B, int C) {
        if (n > 0) {
            // Dời n-1 đĩa từ A qua B (dùng C là trung gian)
            moveTower(n - 1, towers, A, C, B);

            // Dời n đĩa từ A qua C
            int disc = towers.get(A).remove(towers.get(A).size() - 1);
            towers.get(C).add(disc);

            // Print the current state of towers
            printTowers(towers);

            // Dời n-1 đĩa từ B qua C (dùng A làm trung gian)
            moveTower(n - 1, towers, B, A, C);
        }
    }

    private static void printTowers(List<List<Integer>> towers) {
        System.out.println(towers);
    }

}
