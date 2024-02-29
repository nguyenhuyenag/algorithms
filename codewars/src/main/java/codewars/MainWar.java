package codewars;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }
        q.add(-1);
        System.out.println("q = " + q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }

}
