package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/binary-prefix-divisible-by-5/

    Cho mảng nums và x[i] là số nguyên có dạng biểu diễn nhị phân được tạo bởi đoạn con nums[0..i].
    Trả về mảng boolean xem x[i] có chia hết cho 5 hay không.

    Ý tưởng là tính giá trị thập phân của từng x[i]:
       x₀ = nums[0]
       x₁ = nums[0..1] = nums[0]2 + nums[1]
       x₂ = nums[0..2] = ((nums[0]2 + nums[1])2 + nums[2])
    Tuy nhiên cách này sẽ bị tràn số.
    Cải tiến: Vì bài toán yêu cầu xem x[i] có chia hết cho 5 hay không, cho nên ta chỉ cần lưu
    phần dư của x[i] khi chia cho 5.
 */
public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5_Fail(int[] nums) {
        StringBuilder x = new StringBuilder();
        List<Boolean> result = new ArrayList<>();
        for (int num : nums) {
            x.append(num);
            result.add(Integer.parseInt(x.toString(), 2) % 5 == 0);
        }
        return result;
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int x_new = 0;
        List<Boolean> result = new ArrayList<>();
        for (int num : nums) {
            x_new = (x_new * 2 + num) % 5;
            result.add(x_new == 0);
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(List.of(true, false, false), prefixesDivBy5(new int[]{0, 1, 1}));
        assertEquals(List.of(false, false, false), prefixesDivBy5(new int[]{1, 1, 1}));
    }

}
