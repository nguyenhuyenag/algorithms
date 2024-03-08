import heapq
import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/first-missing-positive/
    
    Cho mảng số nguyên. Tìm số nguyên còn thiếu đầu tiên nhỏ nhất của mảng số nguyên
"""


class Solution(unittest.TestCase):

    @staticmethod
    def firstMissingPositive(nums: List[int]) -> int:
        # Xóa các phần tử < 0 và trùng nhau
        nums = list(set(filter(lambda t: t > 0, nums)))
        heapq.heapify(nums)
        missing = 0
        while nums:
            # Nếu missing + 1 không phải là số ở đỉnh heap thì nó là số cần tìm
            if missing + 1 != nums[0]:
                return missing + 1

            missing = heapq.heappop(nums)
        # Chạy hết mảng thì phần tử là số lớn nhất (giờ là missing) + 1
        return missing + 1

    def test(self):
        # self.assertEqual(3, self.firstMissingPositive([1, 2, 0]))
        self.assertEqual(2, self.firstMissingPositive([3, 4, -1, 1]))


if __name__ == '__main__':
    unittest.main()
