package array.subs;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

/**
 * Tìm tất cả các hoán vị (n!)
 *
 * Xem thêm algorithm: array > recursion > backtracking > Permute.java
 */
public class LietKeHoanVi {

    private static void permute(List<List<Integer>> result,
                                List<Integer> currentList, int start, int end) {
        if (start == end) {
            result.add(currentList);
        } else {
            for (int i = start; i <= end; i++) {
                Collections.swap(currentList, start, i);
                permute(result, currentList, start + 1, end);
                Collections.swap(currentList, start, i); // backtrack
            }
        }
    }

    public static void permuteOfList() {
        List<Integer> input = Arrays.asList(1, 2, 3);

        List<List<Integer>> result = new ArrayList<>();
        permute(result, input, 0, input.size() - 1);

        System.out.println("Check: " + result.size() + " & "
                + CombinatoricsUtils.factorial(input.size()));
        System.out.println("result = " + result);
    }

    public static void main(String[] args) {
        permuteOfList();
    }

}
