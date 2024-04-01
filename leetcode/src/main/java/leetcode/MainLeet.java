package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class MainLeet {

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * Nếu 2 số liền kề chưa đúng vị trí thì đổi chỗ
     */
    public void bubleSortLeftToTight(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void bubleSortRightToLeft(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * Tìm số nhỏ nhỏ nhất, nhỏ nhì,... và dời chúng lên vị trị 0, 1,....
     */
    public void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            // Tìm số nhỏ nhất
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Tìm được số nhỏ nhất thì đổi vị trí với số hiện tại
            swap(arr, i, minIndex);
        }
    }

    /**
     * - Mảng 1 phần tử luôn là mảng được sắp xếp
     * - Từ phần tử X phía sau của mảng đã sắp xếp, tiến hành di chuyển về bên phải các số > X.
     * Chèn X vào vị trí trống sau khi di chuyển
     */
    public void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int X = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > X) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Chèn X vào vị trí trống
            arr[j + 1] = X;
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        // Copy giá trị vào mảng tạm: arr[left,...mid], arr[mid+1...right]
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        // Gọp 2 mảng sắp xếp thành 1 mảng sắp xếp
        int p = left;
        int i = 0, j = 0;
        int n1 = L.length, n2 = R.length;
        while (i < n1 && j < n2) {
            arr[p++] = L[i] < R[j] ? L[i++] : R[j++];
        }

        // Copy các giá trị còn lại
        while (i < n1) {
            arr[p++] = L[i++];
        }
        while (j < n2) {
            arr[p++] = R[j++];
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Đệ quy
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // Merge
            merge(arr, left, mid, right);
        }
    }

    public void sortColors(int[] arr) {
        // bubleSortLeftToTight(arr);
        // bubleSortRightToLeft(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        MainLeet m = new MainLeet();
        int[] arr = {2, 0, 2, 1, 1, 0};
        m.sortColors(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

}
