import unittest

from typing import List
from collections import deque

"""
    https://leetcode.com/problems/rotate-array/
"""


class Solution(unittest.TestCase):

    @staticmethod
    def rotate(nums: List[int], k):
        result = deque(nums)
        # Rotate the deque by k positions to the right
        n = len(nums)
        k = k % n
        result.rotate(k)
        # Convert the deque back to a list
        nums[:] = list(result)

    @staticmethod
    def rotate_OK(nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n
        result = nums[n - k:] + nums[:n - k]
        nums[:] = result

    def test(self):
        self.assertEqual(self.rotate_OK([1, 2, 3, 4, 5, 6, 7], 3), self.rotate([1, 2, 3, 4, 5, 6, 7], 3))


if __name__ == '__main__':
    unittest.main()
