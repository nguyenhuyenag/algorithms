package array;

/**
 * Cho mảng số nguyên A và số nguyên k. Tìm phần tử gần k nhất
 *
 * arr = { -1, 2, 1, -4 }, k = 2 => kq = 2
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

    public static int findClosest(int x1, int x2, int k) {
        return Math.abs(x1 - k) < Math.abs(x2 - k) ? x1 : x2;
    }

    public static int nearest2(int[] arr, int k) {
        int closest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            closest = findClosest(closest, arr[i], k);
        }
        return closest;
    }

    public static void main(String[] args) {
        int k = 5; // RandomUtils.getInt();
        int[] nums = {2, -1, 6, 8, 0, 2};
        System.out.println(nearest(nums, k) + ", " + nearest2(nums, k));
    }

}
