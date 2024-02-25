package com.recursion.backtracking;

import java.util.*;
import java.util.spi.LocaleNameProvider;

/*-
    Mô hình quay lui

    public void backtrack(int pos) {
        // Trường hợp cơ sở
        if (pos là vị trí cuối cùng) {
            < output/lưu lại tập hợp đã dựng nếu thoả mãn >
            return;
        }
        // Phần đệ quy
        for (Tất cả giá trị i có thể ở vị trí pos) {
            <Thêm giá trị i vào tập đang xét>
            backtrack(i + 1);
            <Xoá bỏ giá trị i khỏi tập đang xét>
        }
    }

    Việc thêm giá trị mới vào tập đang xét rồi cuối cùng xoá bỏ khỏi tập giải thích cho
    tên gọi "quay lui" của thuật toán. Đó là việc khôi phục lại trạng thái cũ của tập
    hợp sau khi kết thúc việc gọi đệ quy.
 */
public class QuayLui {

    /**
     * Sinh dãy nhị phân độ dài n
     */
    private static final LinkedList<String> list = new LinkedList<>();
    public static void genBinary(int n, int i) {
        if (i == n) { // Chỉ in những chuỗi có độ dài 'n'
            System.out.print(String.join("", list) + " ");
        } else {
            for (char c = '0'; c <= '1'; c++) { // Tất cả các giá trị có thể có ở vị trí i
                list.addLast(String.valueOf(c));
                genBinary(n, i + 1); // Quay lui
                list.removeLast();
            }
        }
    }

    /**
     * Sinh tập con của {1, 2, 3,... 5}
     */
    public static LinkedList<Integer> listSubset = new LinkedList<>();
    // n = số lượng phần tử lớn nhất của 1 tập con, pos = số lượng phần tử của tập con hiện tại
    // Có thể sinh dãy nhị phân sau đếm bit 1 để add vào mảng
    public static void genSubset(int n, int pos) {
        System.out.println(Arrays.toString(listSubset.toArray()));
        for (int i = pos; i <= n; i++) {
            listSubset.addLast(i);
            genSubset(n, i + 1); // quay lui
            listSubset.removeLast();
        }
    }

    /**
     * Sinh tập con của 1 tập S = {a, b, c, d}
     */
    public static List<String> S = List.of("a", "b", "c");
    public static LinkedList<String> listSubsetS = new LinkedList<>();
    public static void genSubsetOfS(int pos) {
        System.out.println(Arrays.toString(listSubsetS.toArray()));
        for (int i = pos; i < S.size(); i++) {
            listSubsetS.addLast(S.get(i));
            genSubsetOfS(i + 1); // quay lui
            listSubsetS.removeLast();
        }
    }

    /**
     * Bài toán đổi tiền. Đổi tờ mệnh giá X ra các tờ nhỏ hơn (có nhiều cách đổ)
     */
    public static List<Integer> menhGia = List.of(10, 20, 50);
    public static Set<List<Integer>> visited = new HashSet<>();
    public static void doiTien_OK(LinkedList<Integer> combination, int n, int pos) {
        // Đã đổi đủ số tiền
        if (n == 0) {
            System.out.println(Arrays.toString(combination.toArray()));
            return;
        }
        for (int i = pos; i < menhGia.size(); i++) {
            if (menhGia.get(i) <= n) {
                // Lấy thêm 1 tờ tiền mới vào tập hợp
                combination.addLast(menhGia.get(i));
                // Đệ quy i thay vì i+1 vì có thể dùng mệnh giá đó lại nhiều lần
                doiTien_OK(combination, n - menhGia.get(i), i);
                combination.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        // genBinary(3, 0); // là 0-index

        // genSubset(3, 1); // 1 là giá trị thuộc {1, 2, 3,...}

        genSubsetOfS(0); // là 0-index

        // doiTien_OK(new LinkedList<>(), 100, 0);
        // System.out.println(" = ");
        // doiTien(new LinkedList<>(), 100);
    }

}
