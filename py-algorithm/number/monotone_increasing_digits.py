import unittest

"""
    https://leetcode.com/problems/monotone-increasing-digits/

    Một số gọi là tăng dần nếu chữ số bên trái luôn <= chữ số bên phải, ví dụ 1234.
    Cho số nguyên n, tìm số tăng dần lớn nhất <= n.
"""


class Solution(unittest.TestCase):

    def monotoneIncreasingDigits(self, n: int) -> int:
        digits = list(map(int, str(n)))
        size = len(digits)
        idx_to_modify = size

        # Traverse the digits from right to left
        for i in range(size - 1, 0, -1):
            if digits[i - 1] > digits[i]:
                idx_to_modify = i
                digits[i - 1] -= 1

        # Set all digits after the idx_to_modify  to 9
        for i in range(idx_to_modify, size):
            digits[i] = 9

        return int(''.join(map(str, digits)))

    def test(self):
        # self.assertEqual(9, self.monotoneIncreasingDigits(10))
        self.assertEqual(1234, self.monotoneIncreasingDigits(1234))
        # self.assertEqual(1239, self.monotoneIncreasingDigits(1243))
        # self.assertEqual(899999999, self.monotoneIncreasingDigits(963856657))


if __name__ == '__main__':
    unittest.main()
