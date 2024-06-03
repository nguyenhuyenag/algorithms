import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/single-number/
    
    Tìm số duy nhất trong mảng
"""


class Solution(unittest.TestCase):

    def singleNumber_OK(self, nums: List[int]) -> int:
        counter = Counter(nums)
        for key, value in counter.items():
            if value == 1: return key

        return -1

    # Cách này chỉ đúng nếu các số khác xuất hiện đúng 2 lần, số cần tìm xuất hiện 1 lần.
    def singleNumber(self, nums: List[int]) -> int:
        result = nums[0]
        for i in range(1, len(nums)):
            result ^= nums[i]

        return result

    def test(self):
        self.assertEqual(2, self.singleNumber([1, 2, 1]))


if __name__ == '__main__':
    unittest.main()
