package com.util;

import java.util.concurrent.TimeUnit;

public class ConTroDiChuyenTraiPhaiLienTuc {

    public static void main(String[] args) throws InterruptedException {
        int maxNumber = 9; // Giá trị tối đa của chuỗi số
        int currentNumber = 0; // Giá trị đang được in
        boolean increasing = true; // Biến xác định việc tăng hay giảm giá trị
        while (true) {
            System.out.print(currentNumber + " ");
            if (currentNumber == maxNumber) {
                // Khi đạt giá trị tối đa, đảo chiều
                increasing = false;
            } else if (currentNumber == 0) {
                // Khi đạt giá trị tối thiểu, đảo chiều
                increasing = true;
            }
            // Tăng hoặc giảm giá trị tùy thuộc vào biến increasing
            currentNumber += increasing ? 1 : -1;
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }

}
