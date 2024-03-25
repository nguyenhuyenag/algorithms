import unittest

from typing import List

"""
    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    
    Tìm các số còn thiếu trong mảng số nguyên chưa các số từ 1 -> n
"""
class Solution(unittest.TestCase):

    @staticmethod
    def findDisappearedNumbers_2(nums: List[int]) -> List[int]:
        n = len(nums)
        mark = [0] * (n + 1)
        for num in nums:
            mark[num] = 1

        result = []
        for i in range(1, n + 1):
            if mark[i] == 0:
                result.append(i)

        return result

    @staticmethod
    def findDisappearedNumbers(nums: List[int]) -> List[int]:
        seen = set(nums)
        result = []
        for i in range(1, len(nums) + 1):
            if i not in seen:
                result.append(i)

        return result

    def test(self):
        self.assertEqual([5, 6], self.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))


if __name__ == '__main__':
    unittest.main()
