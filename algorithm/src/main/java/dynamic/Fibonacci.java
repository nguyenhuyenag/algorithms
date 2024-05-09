package dynamic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    f(0) = 0, f(1) = 1
    f(n) = f(n - 1) + f(n - 2)
 */
public class Fibonacci {

    // Đệ quy thông thường
    public int fibo(int n) {
        if (n <= 1) return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    // Quy hoạch động
    public int fibo_dynamic(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    // Đệ quy có nhớ
    int[] mem = new int[100];

    public int fibo_memory(int n) {
        if (n <= 1) return n;
        if (mem[n] != - 1) return mem[n];
        mem[n] = fibo_memory(n - 1) + fibo_memory(n - 2);
        return mem[n];
    }

    @Test
    public void test() {
        int n = 5;
        System.out.println("f(n) = " + fibo(n));
        System.out.println("f(n) = " + fibo_dynamic(n));
        Arrays.fill(mem, -1);
        System.out.println("f(n) = " + fibo_memory(n));
    }

}
