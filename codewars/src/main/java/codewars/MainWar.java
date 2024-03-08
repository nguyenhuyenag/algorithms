package codewars;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cho số nguyên n. Với mỗi i thuộc [0, n] đếm số bit '1' trong biểu diễn của i dưới dạng nhị phân
 * Trả về mảng n + 1 kết quả trên
 */
public class MainWar {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
//            System.out.println("binary = " + Integer.toString(i, 2));
            System.out.println("bitcount = " + Integer.bitCount(i));
        }
    }

}
