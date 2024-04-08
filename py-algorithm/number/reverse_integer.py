import unittest
from typing import List

import sys
import numpy as np

"""
    https://leetcode.com/problems/reverse-integer/
    
    Đảo ngược số nguyên n cho trước, nếu kết quả vượt quá [-2^{23}, 2^{23} - 1] thì trả về 0
"""


# MIN = -2 ** 31
# MAX = (2 ** 31) - 1
class Solution(unittest.TestCase):

    @staticmethod
    def is_within_integer(n):
        return -(2 ** 31) <= n <= pow(2, 31) - 1

    def reverse_OK(self, x: int) -> int:
        sign = np.sign(x)
        reversed_num = 0
        x = abs(x)
        while x > 0:
            digit = x % 10
            x //= 10
            reversed_num = reversed_num * 10 + digit
            if not self.is_within_integer(sign * reversed_num):
                return 0

        return sign * reversed_num if self.is_within_integer(sign * reversed_num) else 0

    @staticmethod
    def reverse(x: int) -> int:
        sign = -1 if x < 0 else 1
        rev = int(str(abs(x))[::-1])
        if not (-pow(2, 31) <= sign * rev <= pow(2, 31) - 1):
            return 0
        return sign * rev

    def test(self):
        self.assertEqual(321, self.reverse(123))
        self.assertEqual(-321, self.reverse(-123))
        self.assertEqual(0, self.reverse(1534236469))
        self.assertEqual(-2143847412, self.reverse(-2147483412))


if __name__ == '__main__':
    unittest.main()
