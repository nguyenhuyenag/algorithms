package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/526989a41034285187000de4/
 *
 * Chuyển 1 địa chỉ IPv4 thành kiểu int. Công thức
 *
 *      S = octet1 * 256³ + octet2 * 256² + octet3 * 256 + octet4
 *
 *      192.168.1.2 => 192 * 256^3 + 168 * 256^2 + ...
 */
public class CountIpAddresses {

    // example : 192.168.1.2
    public long ipToLong(String ipAddress) {
        long result = 0;
        String[] ips = ipAddress.split("\\.");
        for (int i = 0; i < ips.length; i++) {
            int octetValue = Integer.parseInt(ips[i]);
            result += (octetValue * Math.pow(256, 3 - i));
        }
        return result;
    }

    public long ipsBetween(String start, String end) {
        return ipToLong(end) - ipToLong(start);
    }

    @Test
    public void test() {
        assertEquals(50, ipsBetween("10.0.0.0", "10.0.0.50"));
        assertEquals(246, ipsBetween("20.0.0.10", "20.0.1.0"));
    }

}
