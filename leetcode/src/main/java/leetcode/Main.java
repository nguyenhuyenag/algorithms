package leetcode;

/**
 * Đếm số lượng mảng con có k số lẻ
 * <p>
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 */
public class Main {

    public static int numberOfSubarrays(int[] nums, int k) {
        int dem = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int countLe = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) {
                    countLe++;
                }
                if (countLe == k) {
                    dem++;
                }
            }
        }
        // System.out.println(dem);
        return dem;
    }

    public static void main(String[] args) {
        Main m = new Main();
        // m.numberOfSubarrays(new int[]{2, 4, 6}, 1); // 0
        // m.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        m.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2); // 16
    }

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
