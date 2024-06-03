import unittest
import numpy as np

"""
    https://leetcode.com/problems/base-7/

    Biểu diễn số n dưới dạng cơ số 7.
"""
class Solution(unittest.TestCase):

    @staticmethod
    def convert_to_base_7(n: int) -> str:
        return np.base_repr(n, base=7)

    @staticmethod
    def convertToBase7(n: int) -> str:
        if n == 0:
            return "0"

        result = []
        m = abs(n)
        while m > 0:
            result.append(str(m % 7))
            m //= 7

        return ('-' if n < 0 else '') + ''.join(result[::-1])

    def test(self):
        self.assertEqual("0", self.convertToBase7(0))
        self.assertEqual("202", self.convertToBase7(100))
        self.assertEqual("-10", self.convertToBase7(-7))


if __name__ == '__main__':
    unittest.main()
