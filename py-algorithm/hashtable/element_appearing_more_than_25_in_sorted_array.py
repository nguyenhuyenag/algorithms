import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
    
    Tìm phần tử xuất hiện > 25% số các phần tử
"""
class Solution(unittest.TestCase):

    @staticmethod
    def findSpecialInteger(nums: List[int]) -> int:
        counter = Counter(nums)
        target = len(nums) / 4 # > 25%
        for k, v in counter.items():
            if v > target:
                return k

        return -1

    def test(self):
        self.assertEqual(6, self.findSpecialInteger([1, 2, 2, 6, 6, 6, 6, 7, 10]))


if __name__ == '__main__':
    unittest.main()
