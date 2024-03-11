import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/minimum-common-value/
"""


class Solution(unittest.TestCase):

    @staticmethod
    def getCommon(nums1: List[int], nums2: List[int]) -> int:
        result = set(nums1) & set(nums2)
        return min(result, default=-1)

    def test(self):
        self.assertEqual(2, self.getCommon([1, 2, 3], [2, 4]))


if __name__ == '__main__':
    unittest.main()
