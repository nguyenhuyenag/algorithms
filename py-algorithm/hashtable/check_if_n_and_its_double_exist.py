import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/check-if-n-and-its-double-exist/
    
    - Kiểm tra xem số x và 2x có cùng tồn tại trong mảng không
"""


class Solution(unittest.TestCase):

    def checkIfExist(self, arr: List[int]) -> bool:
        seen = set()
        for x in arr:
            # if seen.__contains__(2 * x) or (x % 2 == 0 and seen.__contains__((x / 2))):
            if 2 * x in seen or (x % 2 == 0 and x / 2 in seen):
                return True

            seen.add(x)
            
        return False

    def test(self):
        self.assertEqual(True, self.checkIfExist([10, 2, 5, 3]))


if __name__ == '__main__':
    unittest.main()
