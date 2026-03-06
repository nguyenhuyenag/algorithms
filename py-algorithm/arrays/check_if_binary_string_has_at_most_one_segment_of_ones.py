import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
    
    Cho một chuỗi nh phân không có số 0 ở đầu. Trả về TRUE nếu có nhiều nhất một đoạn liên
    tiếp các số 1, ngược lại trả về FALSE.

    Ví dụ:

        s	        Kết quả	    Giải thích
        111000	    true	    chỉ có 1 đoạn 111
        110011	    false	    có 2 đoạn 11
        1	        true	    một đoạn 1
        101	        false	    hai đoạn 1
"""


class Solution(unittest.TestCase):

    def checkOnesSegment_OK(self, s: str) -> bool:
        return not s.__contains__('01')

    def checkOnesSegment(self, s: str) -> bool:
        count = 0
        for i in range(len(s) - 1):
            if s[i] != s[i + 1]:
                count += 1
                if count > 1:
                    return False

        return True

    def test_1(self):
        test_cases = [
            ("110011", False),
            ("110", True),
            ("1001", False),
            ("1", True),
            ("10", True),
            ("111", True),
            ("1000", True),
        ]
        for s, expected in test_cases:
            self.assertEqual(expected, self.checkOnesSegment(s))


if __name__ == '__main__':
    unittest.main()
