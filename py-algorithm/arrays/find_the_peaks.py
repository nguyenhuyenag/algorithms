import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/find-the-peaks/
    
    Bạn được cho mảng mountain. Hãy tìm các chỉ số của phần tử là đỉnh, tức là lớn
    hơn cả hai phần tử lân cận.

    Lưu ý: phần tử đầu và cuối không được coi là đỉnh.
"""


class Solution(unittest.TestCase):

    def findPeaks(self, mountain: List[int]) -> List[int]:
        result = []
        for i in range(1, len(mountain) - 1):
            if mountain[i - 1] < mountain[i] and mountain[i] > mountain[i + 1]:
                result.append(i)

        return result

    def test_1(self):
        self.assertEqual([], self.findPeaks([2, 4, 4]))
        self.assertEqual([1, 3], self.findPeaks([1, 4, 3, 8, 5]))


if __name__ == '__main__':
    unittest.main()
