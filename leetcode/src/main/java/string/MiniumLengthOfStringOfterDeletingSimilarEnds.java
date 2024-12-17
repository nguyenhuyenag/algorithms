package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Chủ đề: Two pointer
 *
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * Tìm độ dài ngắn nhất sau khi xóa các ký tự giống nhau ở 2 đầu của chuỗi
 *
 * Ví dụ:
 * s = 'ab'      ->  2 ~ Không thể xóa ký tự nào
 * s = 'aabaa'   ->  1 ~ Xóa 'aa' ở 2 đầu
 * s = 'aaabca'  ->  2 ~ Xóa 'aaa' ở đầu và 'a' ở cuối
 */
public class MiniumLengthOfStringOfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        int ans = s.length();
        int l = 0, r = ans - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) {
                l++;
                ans--;
            }
            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) {
                r--;
                ans--;
            }
            l++;
            r--;
            ans -= 2;
        }
        return ans;
    }

    @Test
    public void test() {
        assertEquals(2, minimumLength("ab"));
        assertEquals(0, minimumLength("cabaabac"));
        assertEquals(3, minimumLength("aabccabba"));
        assertEquals(1, minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

//    public int minimumLength(String s) {
//        int l = 0, r = s.length() - 1;
//        while (l < r && s.charAt(l) == s.charAt(r)) {
//            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) {
//                l++;
//            }
//            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) {
//                r--;
//            }
//            l++;
//            r--;
//        }
//        return r - l + 1;
//    }

    //    public int minimumLength(String s) {
//        int left = 0, right = s.length() - 1;
//
//        while (left < right && s.charAt(left) == s.charAt(right)) {
//            char currentChar = s.charAt(left);
//            // Move the left pointer to the right until a different character is encountered
//            while (left <= right && currentChar == s.charAt(left)) {
//                left++;
//            }
//
//            // Move the right pointer to the left until a different character is encountered
//            while (left <= right && currentChar == s.charAt(right)) {
//                right--;
//            }
//        }
//
//        // Calculate the remaining length after removing matching prefixes and suffixes
//        return right - left + 1;
//    }

    //    public int minimumLength(String s) {
//        int ans = s.length();
//        int l = 0, r = s.length() - 1;
//        while (l < r && s.charAt(l) == s.charAt(r)) {
//            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) {
//                l++;
//                ans--;
//            }
//            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) {
//                r--;
//                ans--;
//            }
//            l++;
//            r--;
//            ans -= 2;
//        }
//        return ans;
//    }

}
