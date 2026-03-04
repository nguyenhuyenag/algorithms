import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/special-positions-in-a-binary-matrix/

    Cho một ma trận nhị phân kích thước m x n là mat, hãy trả về số lượng
    các vị trí đặc biệt trong mat.

    Một vị trí (i, j) được gọi là đặc biệt nếu:
        - mat[i][j] == 1
        - Tất cả các phần tử khác trong hàng i và cột j đều bằng 0

    (Lưu ý: Chỉ số hàng và cột được đánh số từ 0.)
"""


class Solution(unittest.TestCase):

    def numSpecial1(self, mat: List[List[int]]) -> int:
        count = 0
        m = len(mat)
        n = len(mat[0])

        row_sum = [0] * m
        col_sum = [0] * n

        for i in range(m):
            for j in range(n):
                row_sum[i] += mat[i][j]
                col_sum[j] += mat[i][j]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1 and row_sum[i] == 1 and col_sum[j] == 1:
                    count += 1

        return count

    def numSpecial(self, mat: List[List[int]]) -> int:
        count = 0

        m = len(mat)
        n = len(mat[0])

        row_sum = [sum(row) for row in mat]
        col_sum = [sum(col) for col in zip(*mat)]

        return sum(
            mat[i][j] == 1 and row_sum[i] == 1 and col_sum[j] == 1
            for i in range(len(mat))
            for j in range(len(mat[0]))
        )

    def test_1(self):
        self.assertEqual(1, self.numSpecial([[1, 0, 0], [0, 0, 1], [1, 0, 0]]))

    @unittest.skip("Skip this test")
    def test_2(self):
        self.assertEqual(3, self.numSpecial([[1, 0, 0], [0, 1, 0], [0, 0, 1]]))


if __name__ == '__main__':
    unittest.main()
