import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/spiral-matrix/
    
    Cho ma trận m x n. In ra ma trận theo hình xoắn ốc
"""
class Solution(unittest.TestCase):

    @staticmethod
    def spiralOrder(matrix: List[List[int]]) -> List[int]:
        result = []

        m = len(matrix)  # Dòng
        n = len(matrix[0])  # Cột

        top = 0
        bottom = m - 1  # Dòng hiện tại
        left = 0
        right = n - 1  # Cột hiện tại

        while left <= right and top <= bottom:
            # In từ trái qua phải
            for i in range(left, right + 1):
                result.append(matrix[top][i])  # Cố định dòng, tăng cột
            top += 1  # Dòng tiếp theo (di chuyển xuống dưới)

            # In từ trên xuống dưới
            for i in range(top, bottom + 1):
                result.append(matrix[i][right])  # Cố định cột, tăng dòng
            right -= 1  # Cột tiếp theo (di chuyển qua trái)

            # In từ phải qua trái
            if top <= bottom:  # Nếu vẫn còn dòng (để thực hiện bottom++)
                for i in range(right, left - 1, -1):
                    result.append(matrix[bottom][i])  # Cố định dòng, giảm cột
                bottom -= 1  # Dòng tiếp theo (di chuyển lên trên)

            # In từ dưới lên trên
            if left <= right:
                for i in range(bottom, top - 1, -1):
                    result.append(matrix[i][left])  # Cố định cột, giảm dòng
                left += 1  # Cột tiếp theo (di chuyển qua phải)

        return result

    def test(self):
        self.assertEqual([1, 2, 3, 6, 9, 8, 7, 4, 5], self.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))


if __name__ == '__main__':
    unittest.main()
