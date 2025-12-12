import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/check-if-it-is-a-straight-line/
    
    Cho mảng chứa các điểm tọa độ, kiểm tra xem chúng có thẳng hàng không.
    
    Xét 3 điểm A(x₁,y₁), B(x₂,y₂), C(x₃,y₃). Nếu diện tích S(ABC) = 0 thì 3 điểm thẳng hàng.
    
    Công thức: 2 * S(ABC) = |(x2 - x1)(y3 - y1) - (x3 - x1)(y2 - y1)| = 0
"""


class Solution(unittest.TestCase):

    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        x1, y1 = coordinates[0]
        x3, y3 = coordinates[1]

        for x2, y2 in coordinates[2:]:
            if (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) != 0:
                return False

        return True

    def test_1(self):
        self.assertEqual(True, self.checkStraightLine([[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]))
        self.assertEqual(False, self.checkStraightLine([[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]))


if __name__ == '__main__':
    unittest.main()
