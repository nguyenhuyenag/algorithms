package array.subs;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class DayConDuongTongLonNhat {

    public void findMaxPositiveSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0, currentLeft = 0, currentRight = 0, currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            // Nếu a[i] > 0 thì cộng vào dãy con hiện tại, và cập nhật vị trí kết thúc
            if (arr[i] > 0) {
                currentSum += arr[i];
                currentRight = i;
            } else {
                // Ngược lại, nếu tổng hiện tại lớn hơn max thì gán giá trị
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    left = currentLeft;
                    right = currentRight;
                }
                // Reset lại giá trị
                currentSum = 0;
                currentLeft = i + 1;
            }
        }
        if (currentSum > maxSum) {
            maxSum = currentSum;
            left = currentLeft;
        }
        System.out.println("maxSum = " + maxSum);
        for (int i = left; i < right; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
