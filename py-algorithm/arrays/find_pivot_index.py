import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/find-pivot-index/

    Cho mảng số nguyên n phần tử, tìm vị trí i (đếm từ 1) chia mảng thành 2 phần

        arr[0] + arr[1] + ... + arr[i - 1] = arr[i + 1] + arr[i + 2] + ... + arr[n - 1]

    Nếu không có thì trả về -1.
"""


class Solution(unittest.TestCase):

    def pivotIndex(self, nums: List[int]) -> int:
        total = sum(nums)
        left_sum = 0
        for i in range(len(nums)):
            right_sum = total - left_sum - nums[i]
            if left_sum == right_sum:
                return i

            left_sum += nums[i]

        return -1

    def test(self):
        self.assertEqual(3, self.pivotIndex([1, 7, 3, 6, 5, 6]))
        self.assertEqual(-1, self.pivotIndex([1, 2, 3]))
        self.assertEqual(0, self.pivotIndex([2, 1, -1]))


if __name__ == '__main__':
    unittest.main()
