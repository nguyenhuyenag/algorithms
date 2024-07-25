package sort.basic;

/*
    https://leetcode.com/problems/sort-an-array/
 */
public class QuickSort3 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        int pivot = nums[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
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
        if (i < right) {
            quickSort(nums, i, right);
        }
        if (j > left) {
            quickSort(nums, left, j);
        }
    }

}
