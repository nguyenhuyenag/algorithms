import unittest

from typing import List

"""
    https://leetcode.com/problems/single-element-in-a-sorted-array/
    
    Cho mảng đã sắp xếp, có duy nhất một phần tử xuất hiện 1 lần, các phần tử còn
    lại xuất hiện 2 lần. Tìm phần tử duy nhất đó.

    Your solution must run in O(log(n)) time and O(1) space.
"""


class Solution(unittest.TestCase):

    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)

        # Nếu chỉ có 1 phần tử thì trả về chính nó
        if n == 1: return nums[0]

        # Tìm trong khoảng [1, n-1]
        for i in range(1, n - 2):
            if nums[i - 1] != nums[i] and nums[i] != nums[i + 1]:
                return nums[i]

        #  Nếu không nằm ở giữa thì chắc chắn ở đầu hoặc cuối
        return nums[n - 1] if nums[0] == nums[1] else nums[0]

    def test_1(self):
        self.assertEqual(2, self.singleNonDuplicate([1, 1, 2, 3, 3, 4, 4, 8, 8]))
        self.assertEqual(10, self.singleNonDuplicate([3, 3, 7, 7, 10, 11, 11]))


if __name__ == '__main__':
    unittest.main()
