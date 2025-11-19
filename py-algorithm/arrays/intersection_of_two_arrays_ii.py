import unittest
from typing import List

"""
    https://leetcode.com/problems/intersection-of-two-arrays/
    
    Tìm giao của 2 mảng
"""
class Solution(unittest.TestCase):

    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                result.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1

        return result

    def intersection_OK(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return list(set(nums1) & set(nums2))

    def test(self):
        self.assertEqual([1, 2], self.intersection([1, 1, 2, 3, 4], [1, 2]))


if __name__ == '__main__':
    unittest.main()
