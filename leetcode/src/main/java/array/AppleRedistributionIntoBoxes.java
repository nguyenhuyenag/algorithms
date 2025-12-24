package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/apple-redistribution-into-boxes/

    Cho mảng apple, capacity có kích thước là n, m.
        - Có n túi, trong đó túi thứ i chứa apple[i] quả táo.
        - Có m hộp và hộp thứ i chứa capacity[i] quả táo
    Tìm số hộp ít nhất để chứa hết táo
    + Lưu ý. Táo từ cùng một túi có thể được chia vào các hộp khác nhau.

    -> Vì táo từ một túi có thể chia nhỏ, nên chỉ cần quan tâm đến TỔNG SỐ TÁO,
    không cần quan tâm từng túi riêng lẻ.

    -> Có totalApples = sum(apple) quả táo. Cần chọn ít nhất bao nhiêu hộp từ danh
    sách capacity để tổng sức chứa ≥ totalApples?

    Ví dụ:
        apple = [1, 3, 2]        → totalApples = 6
        capacity = [4, 3, 1, 5, 2]
    => Cần chọn các hộp có tổng sức chứa ≥ 6
 */
public class AppleRedistributionIntoBoxes {

    public int minimumBoxes_OK(int[] apple, int[] capacity) {
        // Bước 1: Tính tổng số táo
        int totalApples = Arrays.stream(apple).sum();

        // Bước 2: Sắp xếp giảm dần capacity
        int[] capacityBoxes = Arrays.stream(capacity)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // Bước 3: Lấy các hộp lớn nhất cho đến khi đủ sức chứa
        int boxesUsed = 0;
        int currentCapacity = 0;

        for (int cap : capacityBoxes) {
            currentCapacity += cap;
            boxesUsed++;

            if (currentCapacity >= totalApples) {
                break;
            }
        }

        return boxesUsed;
    }

    // Sort thông thường và duyệt từ phải qua trái
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Bước 1: Tính tổng số táo
        int totalApples = Arrays.stream(apple).sum();

        // Bước 2: Sắp xếp giảm dần capacity
        Arrays.sort(capacity);

        // Bước 3: Lấy các hộp lớn nhất cho đến khi đủ sức chứa
        int boxesUsed = 0;
        int currentCapacity = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;

            if (currentCapacity >= totalApples) {
                break;
            }
        }

        return boxesUsed;
    }

    @Test
    public void test1() {
        assertEquals(2, minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
    }

    @Test
    public void test2() {
        assertEquals(4, minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}));
    }


}
