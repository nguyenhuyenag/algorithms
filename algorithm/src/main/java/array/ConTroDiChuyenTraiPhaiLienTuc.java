package array;

import java.util.concurrent.TimeUnit;

public class ConTroDiChuyenTraiPhaiLienTuc {

    public static void method1() {
        boolean increment = true;
        int min = 0, max = 9;
        int number = min;
        for (int i = 0; i < 4; i++) {
            while (increment ? number <= max : number >= min) {
                System.out.print(number + " ");
                number += increment ? 1 : -1;
            }
            increment = !increment;
            number = increment ? min : max; // Reset number for next row
            System.out.println();
        }
    }

    public static void method2() throws InterruptedException {
        int maxNumber = 9; // Giá trị tối đa của chuỗi số
        int currentNumber = 0; // Giá trị đang được in
        boolean increasing = true; // Biến xác định việc tăng hay giảm giá trị
        while (true) {
            System.out.print(currentNumber + " ");
            if (currentNumber == maxNumber) {
                // Khi đạt giá trị tối đa, đảo chiều
                increasing = false;
                System.out.println();
            } else if (currentNumber == 0) {
                // Khi đạt giá trị tối thiểu, đảo chiều
                increasing = true;
                System.out.println();
            }
            // Tăng hoặc giảm giá trị tùy thuộc vào biến increasing
            currentNumber += increasing ? 1 : -1;
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        method1();
        // method2();
    }

}
