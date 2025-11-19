import unittest

from typing import List

"""
    https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

 	Tạo mảng n số nguyên khác nhau có tổng = 0.

 	=> Gán n - 1 số (>= 1) đầu tiên là sum, gán số cuối cùng -sum.
"""
class Solution(unittest.TestCase):

    def sumZero(self, n: int) -> List[int]:
        result = []
        for i in range(1, n):
            result.append(i)
        csum = sum(result)
        result.append(-csum)
        return result

    def test(self):
        self.assertEqual(0, sum(self.sumZero(8)))


if __name__ == '__main__':
    unittest.main()
