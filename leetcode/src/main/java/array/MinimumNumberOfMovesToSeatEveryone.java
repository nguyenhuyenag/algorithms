package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

    Cho mảng students[] đại diện cho vị trí hiện tại của học sinh và mảng seats[]
    đại diện cho vị trí ghế. Tìm số bước di chuyển ít nhất để mỗi học sinh ngồi vào
    một ghế sao cho không có 2 học sinh nào ngồi cùng một ghế.

    Ví dụ: Input: students = [2,7,4], seats = [3,1,5] => Output: 4
    Giải thích: Ta di chuyển như sau:
    - Học sinh đầu tiên di chuyển từ vị trí thứ 2 -> 1 => 1 bước
    - Học sinh đầu tiên di chuyển từ vị trí thứ 7 -> 5 => 2 bước
    - Học sinh đầu tiên di chuyển từ vị trí thứ 4 -> 3 => 1 bước
    Vậy có 1 + 2 + 1 = 4 bước di chuyển.

    Chiến lượt là học sinh ở nhỏ nhất di chuyển đến vị trí ghế nhỏ nhất, học sinh ở vị
    trí nhỏ thứ hai di chuyển đến vị trí ghế nhỏ thứ hai,...
 */
public class MinimumNumberOfMovesToSeatEveryone {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int totalMoves = 0;
        for (int i = 0; i < seats.length; i++) {
            totalMoves += Math.abs(students[i] - seats[i]);
        }
        return totalMoves;
    }

    @Test
    public void test() {
        assertEquals(4, minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
    }

}
