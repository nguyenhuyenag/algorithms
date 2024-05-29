package number;

public class Binary {

    /*
        Nếu n = 2^k thì n = '100000...'
        Và n - 1 sẽ có dạng n - 1 = '11111....'
     */
    public static void powerOfTwo() {
        int n = 16;
        System.out.println(n + " = " + Integer.toString(n, 2));
        System.out.println(n + " = " + Integer.toBinaryString(n));
        System.out.println(n - 1 + " = " + Integer.toBinaryString(n - 1));
    }

    /*
        Kiểm tra một số nhị phân là chẵn hay lẽ. Bit cuối là `0` -> chẵn, là `1` -> lẽ
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
