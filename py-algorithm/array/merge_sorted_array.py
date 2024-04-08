import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
  https://leetcode.com/problems/merge-sorted-array/

  Cho mảng nums1 gồm m + n phần tử. Với m phần tử khác 0 được sắp xếp ở
  đầu mảng và n phần tử 0 được đặt ở cuối mảng.

  Cho mảng nums2 có kích thước n được sắp xếp.

  Gộp nums2 vào nums1 bằng cách thay các số 0 trong nums1 bởi các phần tử
  trong nums2 sau cho nums1 cũng là mảng được sắp xếp.
"""
class Solution(unittest.TestCase):

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1[(m + n) - n:] = nums2
        nums1.sort()

    def test(self):
        nums1 = [1, 2, 3, 0, 0, 0]
        m = 3
        nums2 = [4, 5, 6]
        m = 3
        self.merge(nums1, m, nums2, n)
        # self.assertEqual(True, self.doTest([]))


if __name__ == '__main__':
    unittest.main()
