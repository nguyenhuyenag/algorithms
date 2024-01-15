package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 */
public class MainLeet {

    @Test
    public void test() {
        int n = 20;
        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j += i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
