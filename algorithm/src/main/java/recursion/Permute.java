package recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Permute {

    public static void showAllPermuteByCommons(List<?> list) {
        CollectionUtils.permutations(list).forEach(System.out::println);
    }

    private static void backtrack(List<?> currentList, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(currentList.toArray()));
        } else {
            for (int i = left; i <= right; i++) {
                Collections.swap(currentList, left, i);
                backtrack(currentList, left + 1, right);
                Collections.swap(currentList, left, i); // backtrack
            }
        }
    }

    public static void showAllPermute(List<?> list) {
        int size = list.size();
        backtrack(list, 0, list.size() - 1);
        System.out.println("Total: " + CombinatoricsUtils.factorial(size));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        showAllPermute(list);
    }

}
