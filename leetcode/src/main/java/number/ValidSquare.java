package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/valid-square/

    Cho tọa độ của 4 điểm, kiểm xem chúng có tạo được hình vuông hay không?
 */
public class ValidSquare {

    // Tính bình phương khoảng cách của 2 điểm
    public int distanceSquare(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distanceSquare(p1, p2));
        set.add(distanceSquare(p1, p3));
        set.add(distanceSquare(p1, p4));
        set.add(distanceSquare(p2, p3));
        set.add(distanceSquare(p2, p4));
        set.add(distanceSquare(p3, p4));
        /**
         * - Không chứa số 0 vì khi đó có 2 điểm trùng nhau.
         * - Set chỉ chứa bình phương của 4 cạnh và 2 đường chéo nên size = 2.
         */
        return !set.contains(0) && set.size() == 2;
    }

    @Test
    public void test() {
        assertEquals(true, validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }

}
