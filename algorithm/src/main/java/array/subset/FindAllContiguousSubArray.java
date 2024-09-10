package array.subset;

import java.util.Arrays;

public class FindAllContiguousSubArray {

    public static void find1() {
        int[] arr = {1, 2, 3, 4};
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                int[] subs = Arrays.copyOfRange(arr, i, j);
                System.out.println(Arrays.toString(subs));
            }
        }
    }

    public static void main(String[] args) {
        find1();
    }

}
