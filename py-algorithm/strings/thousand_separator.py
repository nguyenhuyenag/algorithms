import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/thousand-separator/
"""


class Solution(unittest.TestCase):

    def thousand_separator(self, n: int) -> str:
        return format(n, ',').replace(',', '.')

    def thousandSeparator(self, n: int) -> str:
        s = str(n)
        parts = []
        while s:
            parts.append(s[-3:])
            s = s[:-3]
        return '.'.join(reversed(parts))

    def test_1(self):
        self.assertEqual("123", self.thousandSeparator(123))

    def test_2(self):
        self.assertEqual("1.234", self.thousandSeparator(1234))


if __name__ == '__main__':
    unittest.main()
