package hashtable;

import java.util.HashMap;
import java.util.Map;

/*
    - Công thức hoạt động như sau:

        m − 1: Giảm m đi 1 để đưa giá trị về 0-based index.

        %n: Thực hiện phép toán modulo với n để đảm bảo giá trị luôn nằm trong khoảng từ 0 đến n-1
            (giống như quay lại đầu danh sách nếu vượt quá n).

        +1: Chuyển kết quả từ 0-based index về lại 1-based index.

    - Xem thêm: leetcode > ExcelSheetColumnTitle.java, ExcelSheetColumnNumber.java
 */
public class FindPosition {

    public static String findPosition(Map<Integer, String> table, int m) {
        int n = table.size();
        int position = (m - 1) % n + 1;
        return table.get(position);
    }

    public static void main(String[] args) {
        // Khởi tạo bảng giá trị
        Map<Integer, String> table = new HashMap<>();
        table.put(1, "A");
        table.put(2, "B");
        table.put(3, "C");
        table.put(4, "D");
        table.put(5, "E");
        table.put(6, "F");
        table.put(7, "G");
        table.put(8, "H");
        table.put(9, "I");
        table.put(10, "J");
        table.put(11, "K");
        table.put(12, "L");
        table.put(13, "M");
        table.put(14, "N");
        table.put(15, "O");
        table.put(16, "P");
        table.put(17, "Q");
        table.put(18, "R");
        table.put(19, "S");
        table.put(20, "T");
        table.put(21, "U");
        table.put(22, "V");
        table.put(23, "W");
        table.put(24, "X");
        table.put(25, "Y");
        table.put(26, "Z");

        // Giá trị m cần tìm vị trí
        int m = 99;

        String result = findPosition(table, m);
        System.out.println("Vị trí tương ứng của x khi m = " + m + " là: " + result);

    }
}
