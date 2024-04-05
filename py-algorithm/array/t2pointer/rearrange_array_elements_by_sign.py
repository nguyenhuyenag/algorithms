import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/rearrange-array-elements-by-sign/
    - Cho mảng số nguyên, sắp xếp lại theo thứ tự dương, âm xen kẽ
        [3,1,-2,-5,2,-4] -> [3,1,2], [-2,-5,-4] -> [3,-2,1,-5,2,-4]
    - Số âm và số dương đều có số lượng bằng nhau
"""


class Solution(unittest.TestCase):

    @staticmethod
    def rearrangeArray(arr: List[int]) -> List[int]:
        result = []
        pos_index, neg_index = 0, 0
        size = len(arr)
        while len(result) < size:
            # Chỉ di chuyển trên các số duơng
            while pos_index < size and arr[pos_index] < 0:
                pos_index += 1

            # Chỉ di chuyển trên các số âm
            while neg_index < size and arr[neg_index] > 0:
                neg_index += 1

            result.extend([arr[pos_index], arr[neg_index]])
            pos_index += 1
            neg_index += 1

        return result

    def test(self):
        self.assertEqual([3, -2, 1, -5, 2, -4], self.rearrangeArray([3, 1, -2, -5, 2, -4]))


if __name__ == '__main__':
    unittest.main()
