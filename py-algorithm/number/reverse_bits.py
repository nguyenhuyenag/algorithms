import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""

"""
class Solution(unittest.TestCase):

    @staticmethod
    def reverseBits(n: int) -> int:
        binary = format(n, '032b')[::-1]
        return int(binary, 2)

    def test(self):
        self.assertEqual(805306368, self.reverseBits(12))
        self.assertEqual(2013265920, self.reverseBits(30))


if __name__ == '__main__':
    unittest.main()
