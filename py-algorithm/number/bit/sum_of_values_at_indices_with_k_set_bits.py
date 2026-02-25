import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
    
    https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/

    Cho mảng số nguyên nums và một số nguyên k. Tính tổng các phần tử mà số bit
    trong biểu diễn nhị phân của chỉ số bằng k.

    Ví dụ: arr = [5, 10, 1, 5, 2], k = 1
        index = 0 -> bitCount(0) = 0
                1 -> bitCount(1) = 1    -> arr[1] = 10  -> ok
                2 -> bitCount(2) = 1    -> arr[2] = 1   -> ok
                3 -> bitCount(3) = 2
                4 -> bitCount(4) = 1    -> arr[4] = 2   -> ok
        => sum = 10 + 1 + 2 = 13
"""


class Solution(unittest.TestCase):

    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        s = 0
        for i, num in enumerate(nums):
            bit_count = i.bit_count()
            if bit_count == k:
                s += num

        return s

    def test_1(self):
        self.assertEqual(13, self.sumIndicesWithKSetBits([5, 10, 1, 5, 2], 1))

    def test_2(self):
        self.assertEqual(1, self.sumIndicesWithKSetBits([4, 3, 2, 1], 2))


if __name__ == '__main__':
    unittest.main()
