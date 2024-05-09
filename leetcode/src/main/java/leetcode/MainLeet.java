package leetcode;


import org.junit.jupiter.api.Test;

/**
 *
 */
public class MainLeet {

    private int rank = 0;

    public void test1() {
        rank++;
        System.out.println(rank);
    }

    public void test2() {
        System.out.println(rank + 10);
    }

    public static void main(String[] args) {
        MainLeet m = new MainLeet();
        m.test1();
        m.test2();
    }

}
