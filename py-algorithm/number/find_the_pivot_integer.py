import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/find-the-pivot-integer/
    
    Số pivot là số chia đoạn [1,n] thành 2 đoạn thỏa mãn sum([1,x]) = sum([x,n])
    Cho số n, tìm số pivot. Nếu không có trả về -1.
"""


class Solution(unittest.TestCase):

    @staticmethod
    def pivotInteger(n: int) -> int:
        total = n * (n + 1) // 2
        left_sum = 0
        for i in range(n, 0, -1):
            left_sum += i
            right_sum = total - left_sum + i
            if left_sum == right_sum: return i

        return -1


    def test(self):
        self.assertEqual(6, self.pivotInteger(8))
        self.assertEqual(-1, self.pivotInteger(4))


if __name__ == '__main__':
    unittest.main()
