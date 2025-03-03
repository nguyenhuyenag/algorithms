package number;

public class NumberUtils {

    // Thập phân => nhị phân
//    public static String toBinary(int n) {
//        String s = "";
//        while (n != 0) {
//            s = n % 2 + s;
//            n = n / 2;
//        }
//        return s; // return Integer.toBinaryString(n);
//    }

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

    public static String toBinary0(int sum) {
        StringBuilder binary = new StringBuilder();
        if (sum == 0) {
            return "0";
        }
        while (sum > 0) {
            int remainder = sum % 2;
            binary.insert(0, remainder);
            sum /= 2;
        }
        return binary.toString();
    }

    public static String removeLeadingZeros(StringBuilder num) {
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0') {
            i++;
        }
        return i == num.length() ? "0" : num.substring(i);
    }

    // Convert với hệ số âm
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        int base = -2;
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int rem = n % base;
            n /= base;
            if (rem < 0) {
                rem -= base;
                n++;
            }
            builder.append(rem);
        }
        // removeLeadingZeros
        return builder.reverse().toString();
    }

    /**
     * Nhị phân => thập phân
     */
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    /**
     * Tổng các chữ số
     */
    public static int sumDigit(int n) {
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    /**
     * Chữ số đầu tiên
     */
    public static int firstDigit(int n) {
        while (n > 10) {
            n /= 10;
        }
        return n;
    }

    /**
     * Đảo ngược số
     */
    public static int reverseNumber(int n) {
        int result = 0;
        /**
         * n = ab = 10 * a + b
         * n % 10 => Lấy chữ số ra thêm vào hàng đơn vị
         */
        while (n > 0) {
            result = 10 * result + n % 10;
            n = n / 10;
        }
        return result;
    }

    /**
     * Kiểm tra các chữ số có phải tăng dần
     */
    public static boolean increment(int n) {
        int tmp, end = n % 10;
        n /= 10;
        while (n > 0) {
            tmp = n % 10;
            if (tmp > end) {
                return false;
            }
            end = tmp;
            n /= 10;
        }
        return true;
    }

    /**
     * Ước chung lớn nhất: Euclid
     *
     * gcd(3,4) = 1, gcd(4,6) = 2
     *
     * BigInteger.gcd()
     */
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a; // hay b cũng được vì lúc này a = b
    }

    /**
     * a = bq + r -> gcd(a,b) = gcd(b,r)
     */
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // n là lũy thừa của k: k^i = n
    public static boolean isPowerOfAny(int n, int k) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                return false;
            }
        }
        return true;
    }

    public void numberToArrayDigits() {
        int number = 123; // -> [1, 2, 3]
        int[] digits = Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    /**
     * Chia 1 số ra dạng 3x + 2y + z
     *
     * Mọi số nguyên > 1 đều có thể viết thành dạng 3x + 2y?
     */
    public static int[] splitNumberInto3x2y(int num) {
        int x = 0, y = 0;
        while (num > 0) {
            // Ưu tiên cho 3
            if (num - 3 == 0 || num - 3 >= 2) {
                num = num - 3;
                x++;
            } else {
                num = num - 2;
                y++;
            }
        }
        return new int[]{x, y, num}; // {x, y, 0} vì n = 0 thì mới thoát vòng lặp
    }

    public static int[] splitNumberAll(int num, int a, int b) {
        int x = 0, y = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while (num > min) {
            if (num - max == 0 || num - max >= min) {
                num = num - max;
                x++;
            } else {
                num = num - min;
                y++;
            }
        }
        return new int[]{x, y, num};
    }

    public static void main(String[] args) {
        StringBuilder n = new StringBuilder("000012356090");
        System.out.println("n = " + removeLeadingZeros(n));
    }

}
