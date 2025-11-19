import unittest

from typing import List

"""
    https://leetcode.com/problems/keep-multiplying-found-values-by-two/
    
    Cho số nguyên x và mảng số nguyên nums. Nếu số đó có trong mảng nums, nhân đôi nó và tiếp tục 
    kiểm tra. Khi nào không còn thấy trong nums nữa thì dừng và trả về giá trị cuối cùng.
"""


class Solution(unittest.TestCase):

    @staticmethod
    def findFinalValue(nums: List[int], x: int) -> int:
        seen = set(nums)
        while x in seen:
            x = x * 2
        return x

    def test_1(self):
        self.assertEqual(24, self.findFinalValue([5, 3, 6, 1, 12], 3))


if __name__ == '__main__':
    unittest.main()
