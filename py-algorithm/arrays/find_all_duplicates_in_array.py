import unittest

from typing import List

"""
    https://leetcode.com/problems/find-all-duplicates-in-an-array/
    
    Tim các phần tử xuất hiện 2 lần trong mảng
"""


class Solution(unittest.TestCase):

    @staticmethod
    def findDuplicates(nums: List[int]) -> List[int]:
        unique = set()
        duplicates = []

        for num in nums:
            if num in unique:
                duplicates.append(num)

            unique.add(num)

        return duplicates

    def test(self):
        self.assertEqual([2, 3], self.findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))


if __name__ == '__main__':
    unittest.main()
