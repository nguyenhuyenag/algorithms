package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
    https://leetcode.com/problems/count-and-say/

    3322251  ->  23 32 15 11   ->   23321511

    Viết hàm countAndSay() thực hiện theo quy tắc:

        countAndSay(1) = "1"
        countAndSay(n) = say countAndSay(n - 1)

    Ví dụ:

        countAndSay(1)  = "1"
        countAndSay(2) = say countAndSay(1) = say "1" = one "1" (một số 1) = "11"
        countAndSay(3) = say "11" = two's "1" (hai số 1) = "21"
        countAndSay(4) = say "21“” = một hai một một = "1211"
 */
public class CountAndSay {

    public String say(String text) {
        // @formatter:off
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i - 1) == text.charAt(i)) {
                count++;
            } else {
                result.append(count)
                        .append(text.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count)
                .append(text.charAt(text.length() - 1));
        // @formatter:on
        return result.toString();
    }

    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        return result;
    }

    @Test
    public void doTest() {
        assertEquals("1", countAndSay(1));
        assertEquals("1211", countAndSay(4));
    }

    public static String say_OK(String text) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(text.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }

//    public static String say0(String str) {
//        StringBuilder result = new StringBuilder();
//        int count = 1;
//        for (int i = 0; i < str.length(); i++) {
//            // Ký tự hiện tại = ký tự tiếp theo và chưa phải là ký tự cuối cùng (để i + 1 tồn tại)
//            if (str.charAt(i) == str.charAt(i + 1) && i < str.length() - 1) {
//                count++;
//            } else {
//                result.append(count).append(str.charAt(i));
//                count = 1;
//            }
//        }
//        return result.toString();
//    }

}
