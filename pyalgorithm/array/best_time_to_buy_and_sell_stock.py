import unittest
from typing import List

"""
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Cho mảng số nguyên nums, tìm hai vị trí i < j sao cho nums[i] - nums[j] lớn nhất 
"""


class Solution(unittest.TestCase):

    def maxProfit(self, nums: List[int]) -> int:
        min_value = nums[0]
        max_different = 0

        for num in nums:
            max_different = max(max_different, num - min_value)
            min_value = min(num, min_value)

        return max_different

    def test(self):
        self.assertEqual(5, self.maxProfit([7, 1, 5, 3, 6, 4]));
        self.assertEqual(0, self.maxProfit([7, 6, 4, 3, 1]));
        self.assertEqual(3, self.maxProfit([2, 1, 4]));


if __name__ == '__main__':
    unittest.main()
