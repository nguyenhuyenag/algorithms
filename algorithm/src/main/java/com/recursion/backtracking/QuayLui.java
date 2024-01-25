package com.recursion.backtracking;

import java.util.Arrays;
import java.util.LinkedList;

/*-
    Mô hình quay lui

    Backtracking(k) {
        for([Mỗi phương án chọn i(thuộc tập D)]) {
 * 		    if ([Chấp nhận i]) {
 * 			    [Chọn i cho X[k]];
 * 			    if ([Thành công]) {
 * 				    [Đưa ra kết quả];
 *              } else {
                    Backtracking(k+1);
                    [Bỏ chọn i cho X[k]];
 *              }
 *          }
 * 	    }
 *  }

    public void backtrack(int pos) {
        // Trường hợp cơ sở
        if (pos là vị trí cuối cùng) {
            output/lưu lại tập hợp đã dựng nếu thoả mãn>
            return;
        }
        // Phần đệ quy
        for (tất cả giá trị i có thể ở vị trí pos) {
            thêm giá trị i vào tập đang xét
            backtrack(pos + 1);
            xoá bỏ giá trị i khỏi tập đang xét
        }
    }

    Việc thêm giá trị mới vào tập đang xét rồi cuối cùng xoá bỏ nó ra khỏi tập giải thích
    cho tên gọi "quay lui" của thuật toán. Đó là việc khôi phục lại trạng thái cũ của tập
    hợp sau khi kết thúc việc gọi đệ quy.
 */
public class QuayLui {

    // private static int n = 3;
    private static final LinkedList<String> list = new LinkedList<>();

    // Sinh dãy nhị phân độ dài n
    public static void genBinary(int n, int index) {
        if (index == n) {
            System.out.print(String.join("", list) + " ");
        } else {
            for (char c = '0'; c <= '1'; c++) {
                list.addLast(String.valueOf(c));
                genBinary(n, index + 1);
                list.removeLast();
            }
        }
    }

    public static LinkedList<Integer> listSubset = new LinkedList<>();

    // n là tập con lớn nhất, pos là sô lượng tập con hiện tại
    // Sinh dãy nhị phân, nếu bit 0 thì add vào mảng
    public static void genSubset(int n, int pos) {
        //if (pos == n) {
        System.out.println(Arrays.toString(listSubset.toArray()));
        //} else {
        for (int i = pos; i < n; i++) {
            listSubset.addLast(i);
            genSubset(n, i + 1);
            listSubset.removeLast();
        }
        // }
    }

    public static void main(String[] args) {
        // genBinary(4, 0); // Bắt đầu từ vị trí 0
        genSubset(3, 0);
    }

}
