package array.daycon;

/*
    Tìm tổng lớn nhất của một chuỗi con liên tiếp trong mảng một chiều.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] a) {
        int size = a.length;
        int currentMax = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            currentMax = currentMax + a[i];
            if (max < currentMax)
                max = currentMax;
            if (currentMax < 0)
                currentMax = 0;
        }
        return max;
    }

}
