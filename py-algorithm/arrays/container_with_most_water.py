from typing import List

import unittest


class Solution(unittest.TestCase):

    def maxArea(self, nums: List[int]) -> bool:
        area_max = 0
        left, right = 0, len(nums) - 1
        while left < right:
            width = right - left
            heigh = min(nums[left], nums[right])
            area = width * heigh
            area_max = max(area, area_max)
            if nums[left] < nums[right]:
                left += 1
            elif nums[left] > nums[right]:
                right -= 1
            else:
                left += 1
                right -= 1

        return area_max

    def test(self):
        self.assertEqual(49, self.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))


if __name__ == '__main__':
    unittest.main()
