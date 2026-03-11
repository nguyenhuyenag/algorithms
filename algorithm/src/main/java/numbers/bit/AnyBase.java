package numbers.bit;

/*
    Các cơ số khác.
 */
public class AnyBase {

    public static void main(String[] args) {
        String s = "1011001";

        int result = 0;
        int base = 2;

        for (char c : s.toCharArray()) {
            result = result * base + (c - '0');
        }

        System.out.println(result);
    }

}
