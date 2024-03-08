import unittest
from typing import List
from collections import Counter

"""
    https://leetcode.com/problems/count-elements-with-maximum-frequency/
    
    Tính tổng số lần xuất hiện nhiều nhất
"""


class Solution(unittest.TestCase):

    @staticmethod
    def maxFrequencyElements_1(nums: List[int]) -> int:
        counter = Counter(nums)
        max_frequency = max(counter.values())
        return sum(filter(lambda x: x == max_frequency, counter.values()))

    @staticmethod
    def maxFrequencyElements(nums: List[int]) -> int:
        counters = Counter(nums)
        frequencies = list(counters.values())
        max_frequency = max(frequencies)
        frequency_count = frequencies.count(max_frequency)
        return max_frequency * frequency_count

    def test(self):
        self.assertEqual(4, self.maxFrequencyElements([1, 2, 2, 3, 1, 4]))
        self.assertEqual(5, self.maxFrequencyElements([1, 2, 3, 4, 5]))


if __name__ == '__main__':
    unittest.main()
