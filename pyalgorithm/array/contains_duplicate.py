import unittest
import collections

from typing import List

"""
    https://leetcode.com/problems/contains-duplicate/
    
    Cho mảng số nguyên, trả về true nếu có phần tử xuất hiện 2 lần
"""


class Solution(unittest.TestCase):

    def containsDuplicate(self, nums: List[int]) -> bool:
        counter = collections.Counter(nums)
        return any(v > 1 for v in counter.values())

    def test(self):
        self.assertEqual(True, self.containsDuplicate([1, 1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
