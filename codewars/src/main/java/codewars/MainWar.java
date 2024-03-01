package codewars;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public static Double calculate(final double n1, final String operation, final double n2) {
        return switch (operation) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> {
                if (n2 == 0) {
                    yield null;
                }
                yield n1 / n2;
            }
            default -> null;
        };
    }

}
