package sort.basic;

import java.util.Arrays;

public class MergeSort {

    // Left subarray is arr[left..mid]
    // Right subarray is arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        // Chia mảng làm 2 đoạn arr[left...mid] và arr[mid+1...right]
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);       // = arr[left...mid]
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1); // arr.length = right + 1

        // Merge the temp arrays
        int p = left;
        int i = 0, j = 0;
        int n1 = leftArray.length, n2 = rightArray.length;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[p++] = leftArray[i++];
            } else {
                arr[p++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[p++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[p++] = rightArray[j++];
        }
    }

    /**
     * Ta thấy:
     * - Mảng ban đầu được lặp lại hành động chia cho tới khi kích thước các mảng sau chia là 1.
     * - Khi kích thước các mảng con là 1, tiến trình gộp sẽ bắt đầu.
     * - Thực hiện gộp lại các mảng này cho tới khi hoàn thành và chỉ còn một mảng đã sắp xếp.
     */
    public static void mergerSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergerSort(arr, left, mid);
            mergerSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        // int[] arr = {9, 0, 1, 8, 6, 3, 1};
        int[] arr = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -1};
        System.out.println("Before: " + Arrays.toString(arr));
        mergerSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
    }

    // Left subarray is arr[left..mid]
    // Right subarray is arr[mid+1..right]
//    public static void merge(int[] arr, int left, int mid, int right) {
//        // Find sizes of two subarrays to be merged
//        int n1 = (mid + 1) - left;
//        int n2 = right - mid;
//
//        // Create temp arrays
//        int[] leftArray = new int[n1];
//        int[] rightArray = new int[n2];
//
//        System.arraycopy(arr, left, leftArray, 0, n1);
//        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
//
//        // Merge the temp arrays
//        int i = 0, j = 0;
//        int p = left;
//        while (i < n1 && j < n2) {
//            if (leftArray[i] <= rightArray[j]) {
//                arr[p++] = leftArray[i++];
//            } else {
//                arr[p++] = rightArray[j++];
//            }
//        }
//
//        // Copy remaining elements of leftArray[] if any
//        while (i < n1) {
//            arr[p++] = leftArray[i++];
//        }
//
//        // Copy remaining elements of rightArray[] if any
//        while (j < n2) {
//            arr[p++] = rightArray[j++];
//        }
//    }

    //    private static void merge(int[] arr, int left, int mid, int right) {
//        int[] temp = new int[right - left + 1]; // Create temp array with appropriate size
//
//        // Copy elements from arr to temp array
//        System.arraycopy(arr, left, temp, 0, temp.length);
//
//        int i = 0;
//        int j = mid + 1 - left;
//        int k = left;
//
//        while (i <= mid - left && j <= right - left) {
//            if (temp[i] <= temp[j]) {
//                arr[k++] = temp[i++];
//            } else {
//                arr[k++] = temp[j++];
//            }
//        }
//
//        // Copy remaining elements of temp[] if any
//        while (i <= mid - left) {
//            arr[k++] = temp[i++];
//        }
//    }

}
