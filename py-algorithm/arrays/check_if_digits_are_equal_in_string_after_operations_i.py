import unittest

"""
    https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

    - Cho số nguyên n. Liên tục thay chuỗi bằng dãy tổng 2 chữ số kề nhau (mod 10) cho đến
    khi còn 2 chữ số, rồi kiểm tra xem chúng có bằng nhau không.

    Ví dụ:
        Giả sử s = "1234"

        Bước 1:
            (1 + 2) % 10 = 3
            (2 + 3) % 10 = 5
            (3 + 4) % 10 = 7
            → s = "357"

        Bước 2:
            (3 + 5) % 10 = 8
            (5 + 7) % 10 = 2
            → s = "82"

        Chuỗi còn 2 chữ số là 8 và 2, không bằng nhau → trả về false.
"""


class Solution(unittest.TestCase):

    def hasSameDigits_OK(self, s: str) -> bool:
        size = len(s)
        digits = list(map(int, s))
        while size > 2:
            new_value = (size - 1) * [0]
            for i in range(size - 1):
                new_value[i] = (digits[i] + digits[i + 1]) % 10

            digits = new_value
            size -= 1

        return digits[0] == digits[1]

    def hasSameDigits(self, s: str) -> bool:
        digits = list(map(int, s))
        while len(digits) > 2:
            digits = [(digits[i] + digits[i + 1]) % 10 for i in range(len(digits) - 1)]

        return digits[0] == digits[1]

    def test_1(self):
        test_cases = [
            (True, "3902"),
            (False, "34789"),
            (False, "1234"),
        ]
        for expected, n in test_cases:
            self.assertEqual(expected, self.hasSameDigits(n))


if __name__ == '__main__':
    unittest.main()
