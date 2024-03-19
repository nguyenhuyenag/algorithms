import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
   https://leetcode.com/problems/spiral-matrix-ii/ 
   
   Cho ma trận n x n. Điền các số từ 1 -> n^2 vào ma trận theo hình xoắn ốc
"""


class Solution(unittest.TestCase):

    @staticmethod
    def generateMatrix(n: int) -> List[List[int]]:
        matrix = [[0] * n for _ in range(n)]

        top, bottom = 0, n - 1  # Dòng hiện tại
        left, right = 0, n - 1  # Cột hiện tại

        p = 1
        while left <= right and top <= bottom:
            # Từ trái qua phải
            for i in range(left, right + 1):
                matrix[top][i] = p  # Cố định dòng, tăng cột
                p += 1
            top += 1  # Dòng tiếp theo (di chuyển xuống dưới)

            # Từ trên xuống dưới
            for i in range(top, bottom + 1):
                matrix[i][right] = p  # Cố định cột, tăng dòng
                p += 1
            right -= 1  # Cột tiếp theo (di chuyển qua trái)

            # Từ phải qua trái
            if top <= bottom:  # Nếu vẫn còn dòng (để thực hiện bottom++)
                for i in range(right, left - 1, -1):
                    matrix[bottom][i] = p  # Cố định dòng, giảm cột
                    p += 1

                bottom -= 1  # Dòng tiếp theo (di chuyển lên trên)

            # Từ dưới lên trên
            if left <= right:
                for i in range(bottom, top - 1, -1):
                    matrix[i][left] = p  # Cố định cột, giảm dòng
                    p += 1

                left += 1  # Cột tiếp theo (di chuyển qua phải)

        return matrix

    def test(self):
        self.assertEqual([[1, 2, 3], [8, 9, 4], [7, 6, 5]], self.generateMatrix(3))


if __name__ == '__main__':
    unittest.main()
