import unittest
import collections

from typing import List

"""
    https://leetcode.com/problems/contains-duplicate-ii/
    
    Cho mảng số nguyên, trả về true nếu tồn tại i != j sao cho nums[i] == nums[j] và abs(i - j) <= k
"""


class Solution(unittest.TestCase):

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        thedict = {}
        for i in range(len(nums)):
            j = thedict.get(nums[i], -1)
            if nums[i] in thedict and abs(i - j) <= k:
                return True

            thedict[nums[i]] = i

        return False

    def test(self):
        self.assertEqual(True, self.containsNearbyDuplicate([1, 2, 3, 1], 3))
        self.assertEqual(True, self.containsNearbyDuplicate([1, 0, 1, 1], 1))
        self.assertEqual(False, self.containsNearbyDuplicate([1, 2, 3, 1, 2, 3], 2))


if __name__ == '__main__':
    unittest.main()
