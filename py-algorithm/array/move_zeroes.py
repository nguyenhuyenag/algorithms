import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""

"""


class Solution(unittest.TestCase):

    @staticmethod
    def moveZeroes(nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        p = 0
        for i in range(n):
            if nums[i] != 0:
                nums[p] = nums[i]
                p += 1

        for i in range(p, n):
            nums[i] = 0

    def test1(self):
        nums = [1, 0, 1]
        self.moveZeroes(nums)
        self.assertEqual([1, 1, 0], nums)

    def test1(self):
        nums = [0, 1, 2, 3, 4, 5]
        self.moveZeroes(nums)
        self.assertEqual([1, 2, 3, 4, 5, 0], nums)


if __name__ == '__main__':
    unittest.main()
