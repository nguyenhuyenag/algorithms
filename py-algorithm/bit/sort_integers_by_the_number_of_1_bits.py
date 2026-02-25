import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
   https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
   Cho mảng số số nguyên:
   - Sắp xếp theo số lượng bit '1' khi biểu diễn nhị phân.
   - Nếu số lượng bit bằng nhau thì sắp xếp theo giá trị thập phân.
"""


class Solution(unittest.TestCase):

    def sortByBits_1(self, arr: List[int]) -> List[int]:
        return sorted(arr, key=lambda x: (bin(x).count('1'), x))

    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort(key=lambda x: (x.bit_count(), x))
        return arr

    def test_1(self):
        arr_in = [0, 1, 2, 3, 4, 5, 6, 7, 8]
        arr_out = [0, 1, 2, 4, 8, 3, 5, 6, 7]
        self.assertEqual(arr_out, self.sortByBits(arr_in))

    def test_2(self):
        arr_in = [1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1]
        arr_out = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]
        self.assertEqual(arr_out, self.sortByBits(arr_in))


if __name__ == '__main__':
    unittest.main()
