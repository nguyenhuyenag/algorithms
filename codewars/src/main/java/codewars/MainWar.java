package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/56f3a1e899b386da78000732/
 */
public class MainWar {

    public int sum(List<?> mixed) {
        return mixed.stream().map(String::valueOf).mapToInt(Integer::parseInt).sum();
    }

    @Test
    public void test() {

    }


}
