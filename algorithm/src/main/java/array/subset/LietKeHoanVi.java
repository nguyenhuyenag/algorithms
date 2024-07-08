package array.subset;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

import static org.apache.commons.math3.util.CombinatoricsUtils.*;

/*
    Tìm tất cả các hoán vị (n!)

    Xem thêm algorithm: array > recursion > backtracking > Permute.java
 */
public class LietKeHoanVi {

    private static <T> void permute(List<List<T>> result, List<T> currentList, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(currentList)); // Ensure to add a copy of the list
        } else {
            for (int i = start; i <= end; i++) {
                Collections.swap(currentList, start, i);
                permute(result, currentList, start + 1, end);
                Collections.swap(currentList, start, i); // backtrack
            }
        }
    }

    public static void permuteOfListInt() {
        List<Integer> input = Arrays.asList(1, 2, 3);

        List<List<Integer>> permute = new ArrayList<>();
        permute(permute, input, 0, input.size() - 1);

        System.out.println("Check size: " + permute.size() + " & " + factorial(input.size()));
        System.out.println("permute = " + permute);
    }

    public static void permuteOfListString() {
        List<String> input = Arrays.asList("a", "b");

        List<List<String>> permute = new ArrayList<>();
        permute(permute, input, 0, input.size() - 1);

        System.out.println("permute = " + permute);
    }

    public static void main(String[] args) {
        // permuteOfListInt();
        permuteOfListString();
    }

}
