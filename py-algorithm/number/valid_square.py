import unittest

from typing import List

"""
    https://leetcode.com/problems/valid-square/

    Cho tọa độ của 4 điểm, kiểm xem chúng có tạo được hình vuông hay không?
"""


class Solution(unittest.TestCase):

    # Tính bình phương khoảng cách của 2 điểm
    def distance_square(self, A: List[int], B: List[int]):
        return (A[0] - B[0]) ** 2 + (A[1] - B[1]) ** 2

    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        unique = set()
        unique.add(self.distance_square(p1, p2))
        unique.add(self.distance_square(p1, p3))
        unique.add(self.distance_square(p1, p4))
        unique.add(self.distance_square(p2, p3))
        unique.add(self.distance_square(p2, p4))
        unique.add(self.distance_square(p3, p4))
        # Nếu 4 điểm tạo thành hình vuông thì unique chỉ chứa 2 số là bình phương
        # độ dài cạnh và canh huyền.
        return 0 not in unique and len(unique) == 2

    def test(self):
        self.assertEqual(True, self.validSquare([0, 0], [1, 1], [1, 0], [0, 1]))
        self.assertEqual(False, self.validSquare([0, 0], [1, 1], [1, 0], [0, 12]))


if __name__ == '__main__':
    unittest.main()
