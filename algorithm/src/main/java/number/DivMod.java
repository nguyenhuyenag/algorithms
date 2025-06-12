package number;

/*-
    Modulo (a % b) trả về phần dư khi chia a cho b:

        + 7 % 3 = 1 (vì 7 chia 3 được 2 dư 1)
        + 5 % 5 = 0 (chia hết)
        + 2 % 5 = 2 (nhỏ hơn nên giữ nguyên)

    Ứng Dụng Đếm Vòng Tròn: Cho số n, tìm vị trí của nó trong mảng, nếu vượt quá số phần tử thì quay về đầu:

        + index = n % số_phần_tử luôn cho kết quả nằm trong khoảng [0, số_phần_tử - 1]
        + Nếu vượt quá số phần tử, nó tự động quay về đầu
 */
public class DivMod {

    // Tìm vị trí của số n trong mảng numbers với n > length
    public static void findIndexOutOfRange() {
        int[] numbers = {7, 5, 2, 10, 15};
        int n = 5;
        int index = 5 % numbers.length;
        System.out.println("index: " + index);
        System.out.println("value: " + numbers[index]);
    }

    // Hiển thị mảng theo kiểu vòng tròn
    public static void showCircular() {
        int i = 0;
        int[] numbers = {44, 12, 65, 84, 23, 90};
        while (true) {
            int index = (i++) % numbers.length;
            System.out.println("i = " + index + ", value = " + numbers[index]);
            try {
                Thread.sleep(1000); // Dừng 1 giây để dễ quan sát
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // findIndexOutOfRange();
        showCircular();
    }

}
