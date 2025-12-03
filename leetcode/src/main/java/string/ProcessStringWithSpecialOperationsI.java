package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/process-string-with-special-operations-i/

    Bạn được cho một chuỗi s gồm các chữ cái tiếng Anh viết thường và các ký tự đặc biệt: *, #, %.

    Hãy xây dựng một chuỗi mới result bằng cách xử lý s từ trái sang phải theo các quy tắc sau:

        - Nếu ký tự là một chữ cái viết thường, thêm nó vào cuối result.
        - Ký tự ‘*’ sẽ xóa ký tự cuối cùng của result, nếu tồn tại.
        - Ký tự ‘#’ sẽ nhân đôi result hiện tại và nối nó vào chính nó (tức là result ← result + result).
        - Ký tự ‘%’ sẽ đảo ngược chuỗi result.

    Hãy trả về chuỗi result cuối cùng sau khi xử lý toàn bộ các ký tự trong s.
 */
public class ProcessStringWithSpecialOperationsI {

    public String processStr_OK(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '*' -> {
                    if (!sb.isEmpty()) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                case '#' -> {
                    sb.append(sb);
                }
                case '%' -> sb.reverse();
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("ba", processStr("a#b%*"));
        assertEquals("", processStr("z*#"));
    }

}
