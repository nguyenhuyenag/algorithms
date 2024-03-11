import unittest
from typing import List

"""
    https://leetcode.com/problems/intersection-of-multiple-arrays/
    
    Tìm phần tử chung của n mảng
"""


class Solution(unittest.TestCase):

    @staticmethod
    def intersection(nums: List[List[int]]) -> List[int]:
        result = set(nums[0])
        for i in range(1, len(nums)):
            # result &= set(nums[i])
            result.intersection_update(nums[i])

        return sorted(list(result))

    def test(self):
        self.assertEqual([3, 4], self.intersection([[3, 1, 2, 4, 5], [1, 2, 3, 4], [3, 4, 5, 6]]))


if __name__ == '__main__':
    unittest.main()
