import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/number-of-1-bits/
    Đếm số bit 1 trong biểu diễn nhị phân của số n > 0
"""


class Solution(unittest.TestCase):

    @staticmethod
    def hammingWeight(n: int) -> int:
        count = 0
        while n > 0:
            if n % 2 == 1:
                count += 1
            n //= 2
        return count

    def test(self):
        self.assertEqual(3, self.hammingWeight(11))
        self.assertEqual(1, self.hammingWeight(128))


if __name__ == '__main__':
    unittest.main()
