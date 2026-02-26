package number.bit;

public class Binary {

    /**
     * Convert a decimal number to binary
     */
    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        // Reverse the StringBuilder to get the correct binary representation
        return binary.reverse().toString();
    }

    /**
     * Convert a decimal number to binary
     */
    public static String toBinary0(int n) {
        return Integer.toBinaryString(n);
    }

    /**
     * Nhị phân => thập phân
     */
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    /*
        > Kiểm tra một số phải dạng 2^k
            - Nếu n = 2^k thì n = '100000...'
            - Và n - 1 sẽ có dạng n - 1 = '11111....'
     */
    public static void powerOfTwo() {
        int n = 16;
        System.out.println(n + " = " + Integer.toString(n, 2));
        System.out.println(n + " = " + Integer.toBinaryString(n));
        System.out.println(n - 1 + " = " + Integer.toBinaryString(n - 1));
    }

    /*
        Kiểm tra một số nhị phân là chẵn hay lẽ. Nếu
            - Bit cuối là `0` -> chẵn,
            - Bit cuối là `1` -> lẽ
     */
    public static void checkEvenOrOdd() {
        int n = 12;
        String binary = Integer.toBinaryString(n);
        var check = binary.charAt(binary.length() - 1) == '0';
        System.out.println("Event = " + check);
    }

    public static void main(String[] args) {
        // powerOfTwo();
        // checkEvenOrOdd();
        System.out.println(Integer.toBinaryString(1));
    }

}
