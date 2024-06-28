package array.subset;

import java.util.ArrayList;
import java.util.List;

public class LietKeTapCon2 {

    private static List<Integer> createList(int[] arr, int index) {
        List<Integer> list = new ArrayList<>();
        String s = Integer.toBinaryString(index);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int maximum = (int) Math.pow(2, arr.length);

        int j = 1;
        for (int i = maximum - 1; i >= 0; i--) {
            List<Integer> list = createList(arr, i);
            String s = String.format("%3d", j++);
            System.out.println(s + " " + list);
        }
    }

}
