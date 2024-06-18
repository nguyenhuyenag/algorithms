//package recursion.backtracking;
//
///**
// * Liệt kê hoán vị của n phần tử của một tập gồm các số từ 1 -> n
// *
// * Với n = 3 => 123 132 213 231 312 321
// */
//public class LietKeHoanVi {
//
//    static int n;
//    static int[] arr = new int[n];
//    static int[] res = new int[10];
//    static boolean[] dd = new boolean[10];
//
//    static void output() {
//        StringBuilder builder = new StringBuilder();
//        for (int k : res) {
//            if (k != 0) {
//                builder.append(k);
//            }
//        }
//        System.out.println(builder.toString());
//    }
//
//    public static void quaylui(int i) {
//        if (n < i) {
//            output();
//        } else {
//            for (int j = 1; j <= n; j++) {
//                if (!dd[j]) {
//                    dd[j] = true;
//                    res[i] = j;
//                    quaylui(i + 1);
//                    dd[j] = false;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        n = 3;
//        quaylui(1);
//    }
//}
