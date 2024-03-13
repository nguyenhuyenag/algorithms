import unittest
from collections import Counter

from typing import List

"""
    https://leetcode.com/problems/contains-duplicate/
    
    Cho mảng số nguyên, trả về true nếu có phần tử xuất hiện 2 lần
"""


class Solution(unittest.TestCase):

    @staticmethod
    def containsDuplicate_1(nums: List[int]) -> bool:
        counter = Counter(nums)
        # Có phần tử xuất hiện 2 lần
        return any(v >= 2 for v in counter.values())

    @staticmethod
    def containsDuplicate(nums: List[int]) -> bool:
        return len(nums) != len(set(nums))

    def test(self):
        self.assertEqual(True, self.containsDuplicate([1, 1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
