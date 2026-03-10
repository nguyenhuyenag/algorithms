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

    def rearrangeArray_OK1(self, arr: List[int]) -> List[int]:
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

    def rearrangeArray(self, nums: List[int]) -> List[int]:
        res = len(nums) * [0]
        pos, neg = 0, 1  # Index của số âm dương
        for num in nums:
            if num > 0:
                res[pos] = num
                pos += 2  # Mỗi số dương sẽ cách nhau 2
            else:
                res[neg] = num
                neg += 2  # Mỗi số âm cũng sẽ cách nhau 2

        return res

    def test(self):
        test_cases = [
            ([3, -2, 1, -5, 2, -4], [3, -2, 1, -5, 2, -4]),
            ([2, -2], [2, -2])
        ]
        for arr, expected in test_cases:
            self.assertEqual(expected, self.rearrangeArray(arr))


if __name__ == '__main__':
    unittest.main()
