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
        k = -1
        seen = set(nums)
        for num in nums:
            if num > 0 and -num in seen:
                k = max(k, num)

            seen.add(num)

        return k

    def test(self):
        self.assertEqual(3, self.findMaxK([-1, 2, -3, 3]))


if __name__ == '__main__':
    unittest.main()
