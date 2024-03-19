package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public static void printSpiralMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int leftCol = 0, rightCol = cols - 1;
        int topRow = 0, bottomRow = rows - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // In phần trên cùng từ trái sang phải
            for (int i = leftCol; i <= rightCol; i++) {
                System.out.print(matrix[topRow][i] + " ");
            }
            topRow++;

            // In phần phải cùng từ trên xuống dưới
            for (int i = topRow; i <= bottomRow; i++) {
                System.out.print(matrix[i][rightCol] + " ");
            }
            rightCol--;

            // In phần dưới cùng từ phải sang trái
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    System.out.print(matrix[bottomRow][i] + " ");
                }
                bottomRow--;
            }

            // In phần trái cùng từ dưới lên trên
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    System.out.print(matrix[i][leftCol] + " ");
                }
                leftCol++;
            }
        }
    }

    public static void main(String[] args) {
//            int[][] matrix = {
//                    {1, 2, 3, 4},
//                    {5, 6, 7, 8},
//                    {9, 10, 11, 12},
//                    {13, 14, 15, 16}
//            };

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Spiral Matrix:");
        printSpiralMatrix(matrix);
    }

}
