package sort.basic;

/*
    https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

    Tương tự QuickSort3.java nhưng so sánh bằng một comparator tổng quát.
 */
public class QuickSort4 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Tạo bộ so sánh
    private int compare(int a, int b) {
        int bitA = Integer.bitCount(a);
        int bitB = Integer.bitCount(b);
        if (bitA != bitB) {
            return bitA - bitB;
        }
        return a - b;
    }

    private void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        int pivot = nums[(left + right) / 2];

        while (i <= j) {
            while (compare(nums[i], pivot) < 0) {
                i++;
            }
            while (compare(nums[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(nums, left, j);
        }
        if (i < right) {
            quickSort(nums, i, right);
        }
    }

}
