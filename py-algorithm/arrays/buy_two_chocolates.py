import unittest
from typing import List

"""
https://leetcode.com/problems/buy-two-chocolates/

Cho mảng số nguyên, tìm hai số a, b sao cho a + b <= x. Trả về x - a - b hoặc x (nếu không tồn tại a, b)
"""


class Solution(unittest.TestCase):

    def buyChoco(self, nums: List[int], x: int) -> int:
        nums.sort()
        a, b = nums[:2]
        return x - a - b if a + b <= x else x

    def test(self):
        self.assertEqual(0, self.buyChoco([1, 2, 2], 3))


if __name__ == '__main__':
    unittest.main()
