package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

//    @Test
//    public void test() {
//    }


    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8_000_000; i++) {
            builder.append(i);
        }
        System.out.println("builder = " + builder.length());
    }


}
