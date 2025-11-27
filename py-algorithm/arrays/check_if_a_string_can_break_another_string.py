import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/check-if-a-string-can-break-another-string/
    
    Cho 2 chuỗi s1, s2. Kiểm tra xem có một hoán vị nào của s1 trội hơn của s2 hay không.
    Chuỗi x trội hơn y nếu tại mọi vị trí i, ký tự x[i] >= y[i].
"""


class Solution(unittest.TestCase):

    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        sort_s1 = sorted(s1)
        sort_s2 = sorted(s2)

        a_break, b_break = True, True
        for i in range(len(sort_s1)):
            if sort_s1[i] > sort_s2[i]: a_break = False
            if sort_s2[i] > sort_s1[i]: b_break = False

            # Nếu cả hai đều False, không cần kiểm tra tiếp
            if not a_break and not b_break: return False

        return a_break or b_break

    def test_1(self):
        self.assertEqual(True, self.checkIfCanBreak("abc", "xya"))


if __name__ == '__main__':
    unittest.main()
