package leetcode.array;

/**
 * Cho mảng số nguyên A và số nguyên k. Tìm phần tử gần k nhất
 *
 * VD: A = { -1, 2, 1, -4 } va k = 2. Ta co kq = 2
 *
 * Xem thêm: FindKClosestElements.java
 */
public class FindClosestElement {

    public static int nearest(int[] A, int k) {
        int closest = k;
        int min = Integer.MAX_VALUE;
        for (int x : A) {
            int diff = Math.abs(x - k);
            if (min > diff) {
                min = diff;
                closest = x;
            }
        }
        return closest;
    }

    public static int nearest2(int[] A, int k) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            min = findClosest(min, A[i], k);
        }
        return min;
    }

    public static int findClosest(int x1, int x2, int k) {
        if (Math.abs(x1 - k) < Math.abs(x2 - k)) {
            return x1;
        }
        return x2;
    }

    public static void main(String[] args) {
        int k = 5; // RandomUtils.getInt();
        int[] nums = {2, -1, 6, 8, 0, 2};
        System.out.println(nearest(nums, k) + ", " + nearest2(nums, k));
    }

}
