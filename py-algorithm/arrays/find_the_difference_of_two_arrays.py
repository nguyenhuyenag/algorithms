import unittest
from typing import List

"""
    https://leetcode.com/problems/find-the-difference-of-two-arrays/
    
    Tìm phần tử khác nhau của 2 mảng:
        [1,2,3], [2,4,6] -> [[1,3],[4,6]]
"""
class Solution(unittest.TestCase):

    @staticmethod
    def findDifference(nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set1, set2 = set(nums1), set(nums2)
        return [list(set1 - set2), list(set2 - set1)]

    def test(self):
        self.assertEqual([1, 3], [4, 6], self.findDifference([1, 2, 3], [2, 4, 6]))


if __name__ == '__main__':
    unittest.main()
