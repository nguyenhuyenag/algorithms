import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    
"""


class Solution(unittest.TestCase):

    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        result = []

        # num < pivot
        for num in nums:
            if num < pivot:
                result.append(num)

        # num == pivot
        for num in nums:
            if num == pivot:
                result.append(num)

        # num > pivot
        for num in nums:
            if num > pivot:
                result.append(num)

        return result

    def test1(self):
        self.assertEqual([-3, 2, 4, 3], self.pivotArray([-3, 4, 3, 2], 2))

    def test2(self):
        self.assertEqual([9, 5, 3, 10, 10, 12, 14], self.pivotArray([9, 12, 5, 10, 14, 3, 10], 10))


if __name__ == '__main__':
    unittest.main()
