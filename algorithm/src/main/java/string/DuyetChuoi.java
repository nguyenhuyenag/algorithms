package string;

public class DuyetChuoi {

    // In k phần tử liên tiếp
    public static void printKPhanTuLienTiep() {
        int k = 5;
        String s = "axd9ftnt";
        for (int i = 0; i < s.length() - k + 1; i++) {
            System.out.println(s.substring(i, i + k));
        }
    }

    public static void main(String[] args) {
        printKPhanTuLienTiep();
    }

}
