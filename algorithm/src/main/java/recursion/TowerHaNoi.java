package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TowerHaNoi {

    /**
     * towerOfHaNoi(n, cột_nguồn, cột_trung_gian, cột_đích)
     *
     * - Toàn bộ quá trình là một số hữu hạn các bước, vì đến một lúc nào đó
     * thuật toán sẽ áp dụng cho n = 1. Bước này chỉ đơn giản là chuyển một
     * đĩa duy nhất từ cọc A sang cọc C.
     *
     * - Có 2^n - 1 bước di chuyển
     */
    public static void towerOfHaNoi(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println(String.format("%s ---> %s", A, C));
        } else {
            // Dùng C là trung gian, dời n - 1 đĩa từ A -> B
            towerOfHaNoi(n - 1, A, C, B);
            // Còn 1 đĩa cuối cùng thì trở về case = 1 ???
            // Di chuyển đĩa lớn nhất (thứ n) từ A -> C
            towerOfHaNoi(n - 1, A, B, C);
            // Dùng A làm trung gian, dời n - 1 đĩa từ B -> C
            towerOfHaNoi(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHaNoi(n, "A", "B", "C");
    }

}
