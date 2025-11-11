package incomplete;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/compare-version-numbers
 *
 * Cho hai chuỗi phiên bản, version1 và version2, hãy so sánh chúng. Một chuỗi phiên bản bao gồm các revision (phiên bản con) được phân tách bằng dấu chấm '.', giá trị của mỗi revision là giá trị nguyên của nó khi bỏ qua các số 0 đứng đầu.
 *
 * Để so sánh hai chuỗi phiên bản, so sánh các giá trị revision từ trái sang phải. Nếu một chuỗi phiên bản có ít revision hơn, coi các revision bị thiếu là 0.
 *
 * Trả về kết quả như sau:
 *      - Nếu version1 > version2, trả về 1.
 *      - Nếu version1 < version2, trả về -1.
 *      - Nếu bằng nhau, trả về 0.
 */
public class CompareVersionNumber {

    public int compareVersion(String version1, String version2) {
        version1 = version1.replace(".", "\\.");
        version2 = version2.replace(".", "\\.");
        int maxLength = Math.max(version1.length(), version2.length());
        version1 = version1 + "0".repeat(maxLength - version1.length());
        version2 = version2 + "0".repeat(maxLength - version2.length());
        return version1.compareTo(version2);
    }

    @org.junit.jupiter.api.Test
    public void test() {
        assertEquals(-1, compareVersion("1.2", "1.10"));
    }

}
