import unittest
from collections import Counter
from typing import List

"""
    https://leetcode.com/problems/unique-number-of-occurrences/
"""


class Solution(unittest.TestCase):

    def uniqueOccurrences(self, nums: List[int]) -> bool:
        counter = Counter(nums)
        values = counter.values()
        return len(values) == len(set(values))

    def test(self):
        self.assertEqual(True, self.uniqueOccurrences([1, 2, 2, 1, 1, 3]))


if __name__ == '__main__':
    unittest.main()
