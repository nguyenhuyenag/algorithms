package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a9c35e9ba1bb5c54a0001ac/
 *
 * Công 2 số
 *
 * Xem thêm: SumStringsAsNumbers.java
 */
public class WarMain {

//    public static int add(int x, int y) {
//        int signX = (int) Math.signum(x);
//        int signy = (int) Math.signum(y);
//        return 0;
//    }

//    @Test
//    public void doTest() {
//        double realNumber = 3.14;
//        int sign = (int) Math.signum(realNumber);
//        System.out.println("sign = " + sign);
//    }

    public static String addStrings(String num1, String num2) {
        // Chuyển đổi chuỗi số thành mảng int
        int[] arr1 = convertStringToArray(num1);
        int[] arr2 = convertStringToArray(num2);

        // Tìm độ dài lớn nhất giữa hai mảng
        int maxLength = Math.max(arr1.length, arr2.length);

        // Mảng để lưu trữ kết quả
        int[] result = new int[maxLength + 1];

        // Biến để lưu trữ giá trị nhớ
        int carry = 0;

        // Thực hiện phép cộng từ cuối mảng đến đầu mảng
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = arr1[i] + arr2[i] + carry;
            result[i + 1] = sum % 10; // Lưu chữ số thấp của tổng vào mảng kết quả
            carry = sum / 10; // Lưu giá trị nhớ cho phép cộng tiếp theo
        }

        // Xử lý giá trị nhớ cuối cùng (nếu có)
        result[0] = carry;

        // Chuyển đổi mảng kết quả thành chuỗi
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);
        }

        // Loại bỏ các số 0 không cần thiết ở đầu chuỗi kết quả
        int startIndex = 0;
        while (startIndex < sb.length() - 1 && sb.charAt(startIndex) == '0') {
            startIndex++;
        }

        return sb.substring(startIndex);
    }

    private static int[] convertStringToArray(String num) {
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }
        return arr;
    }

    public static String product(String a, long b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; --i) {
            // Lấy tích chữ số và số nhỏ, cộng thêm biến nhớ từ hàng bên phải.
            long s = (a.charAt(i) - '0') * b + carry;
            carry = (int) (s / 10); // Giá trị nhớ đẩy sang hàng bên trái.
            res.append((char) (s % 10 + '0'));
        }

        // Nếu vẫn còn nhớ thì viết nốt nó sang bên trái kết quả.
        while (carry != 0) {
            res.append((char) (carry % 10 + '0'));
            carry /= 10;
        }

        // Đảo ngược chuỗi kết quả để thu được kết quả đúng.
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "123456789";
        long b = 2;
        String result = product(a, b);
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        String num1 = "123";
//        String num2 = "46";
//
//        String sum = addStrings(num1, num2);
//
//        System.out.println("Test = " + (Integer.valueOf(num1) + Integer.valueOf(num2)));
//        System.out.println("Sum: " + sum); // Kết quả: 579
//    }

}
