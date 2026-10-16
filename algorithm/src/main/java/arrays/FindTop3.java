package arrays;

public class FindTop3 {

    public static void main(String[] args) {
        // findTop3();
        findTop3Duplicate();
    }

    private static void findTop3Duplicate() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};
        int top1 = Integer.MIN_VALUE;
        int top2 = Integer.MIN_VALUE;
        int top3 = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > top1) {
                top3 = top2;
                top2 = top1;
                top1 = x;
            } else if (x > top2) {
                top3 = top2;
                top2 = x;
            } else if (x > top3) {
                top3 = x;
            }
        }
        System.out.println("Top 3 elements are: " + top1 + ", " + top2 + ", " + top3);
    }

    public static void findTop3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int top1 = Integer.MIN_VALUE;
        int top2 = Integer.MIN_VALUE;
        int top3 = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > top1) { // Nếu x > top1 thì gán top1 = x, top1 cũ trở thành top2, top2 trở thành top3 (nâng hạng)
                top3 = top2;
                top2 = top1;
                top1 = x;
            } else if (x > top2 && x != top1) { // Nếu x > top2 và không phải top1 thì gán top2 = x, top2 cũ trở thành top3 (nâng hạng).
                top3 = top2;
                top2 = x;
            } else if (x > top3 && x != top1 && x != top2) { // Nếu x > top3 và không phải top1 và top2 thì gán top3 = x.
                top3 = x;
            }
        }

        System.out.println("Top 3 elements are: " + top1 + ", " + top2 + ", " + top3);
    }

}
