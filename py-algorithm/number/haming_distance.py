import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/hamming-distance/

    Đếm số khác nhau tương tứng của 2 số nguyên trong biểu diễn nhị phân

        1   (0 0 0 1)
        4   (0 1 0 0)
              ↑   ↑     -> Kết quả = 2
"""


class Solution(unittest.TestCase):

    def hammingDistance(self, x: int, y: int) -> int:
        b1 = format(x, 'b')
        b2 = format(y, 'b')
        len1, len2 = len(b1), len(b2)
        max_len = max(len1, len2)
        count = 0
        for i in range(max_len):
            c1 = b1[- 1 - i] if i < len1 else '0'
            c2 = b2[- 1 - i] if i < len2 else '0'
            if c1 != c2: count += 1

        return count

    def test(self):
        self.assertEqual(2, self.hammingDistance(1, 4))
        self.assertEqual(1, self.hammingDistance(1, 3))


if __name__ == '__main__':
    unittest.main()
