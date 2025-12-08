import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/count-square-sum-triples/
"""


class Solution(unittest.TestCase):

    def countTriples(self, n: int) -> int:
        max_c2 = 2 * n * n
        is_perfect = [False] * (max_c2 + 1)

        limit = int(max_c2 ** 0.5)
        for c in range(1, limit + 1):
            is_perfect[c * c] = True

        count = 0
        for a in range(1, n + 1):
            aa = a * a
            for b in range(1, n + 1):
                c2 = aa + b * b
                if c2 <= n * n and is_perfect[c2]:
                    count += 1

        return count

    def test_1(self):
        self.assertEqual(2, self.countTriples(5))


if __name__ == '__main__':
    unittest.main()
