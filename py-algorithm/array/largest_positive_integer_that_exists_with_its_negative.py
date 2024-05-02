import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
    
    Cho mảng gồm các số nguyên khác không. Tìm số k lớn nhất sao cho tồn tại -k trong mảng.
"""


class Solution(unittest.TestCase):

    def findMaxK(self, nums: List[int]) -> int:
        max_k = 0
        seen = set()
        for num in nums:
            if -num in seen:
                max_k = max(max_k, num, -num)

            seen.add(num)

        return -1 if max_k == 0 else max_k

    def test(self):
        self.assertEqual(3, self.findMaxK([-1, 2, -3, 3]))


if __name__ == '__main__':
    unittest.main()
