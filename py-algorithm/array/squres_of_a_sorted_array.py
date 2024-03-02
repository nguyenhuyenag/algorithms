import unittest
from typing import List
from queue import PriorityQueue

"""
    https://leetcode.com/problems/squares-of-a-sorted-array/
    
    Cho mảng số nguyên được sắp xếp, trả về mảng mới là bình phương
    của mỗi phần tử cũng được sắp xếp.
"""
class Solution(unittest.TestCase):

    def sortedSquares(self, nums: List[int]) -> List[int]:
        queue = PriorityQueue()

        for num in nums:
            queue.put(num ** 2)

        for i in range(len(nums)):
            nums[i] = queue.get()

        return nums

    def test(self):
        self.assertEqual([0, 1, 9, 16, 100], self.sortedSquares([-4, -1, 0, 3, 10]))


if __name__ == '__main__':
    unittest.main()
