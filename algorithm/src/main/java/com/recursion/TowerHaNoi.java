package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TowerHaNoi {

    public static void main(String[] args) {
        List<List<Integer>> towers = new ArrayList<>();

        int n = 3; // Number of discs

        // Initialize the towers
        for (int i = 0; i < 3; i++) {
            towers.add(new ArrayList<>());
        }

        // Add discs to the first tower
        for (int i = n; i > 0; i--) {
            towers.get(0).add(i);
        }

        // Print initial state
        printTowers(towers);

        // Move discs from tower 1 to tower 3 using tower 2 as auxiliary
        moveTower(n, towers, 0, 2, 1);
    }

    private static void moveTower(int n, List<List<Integer>> towers, int A, int C, int B) {
        if (n > 0) {
            // Move n-1 discs from source to auxiliary tower using destination tower as auxiliary
            moveTower(n - 1, towers, A, B, C);

            // Move the nth disc from source to destination
            int disc = towers.get(A).remove(towers.get(A).size() - 1);
            towers.get(C).add(disc);

            // Print the current state of towers
            printTowers(towers);

            // Move the n-1 discs from auxiliary tower to destination using source tower as auxiliary
            moveTower(n - 1, towers, B, C, A);
        }
    }

    private static void printTowers(List<List<Integer>> towers) {
        System.out.println(towers);
    }

}
