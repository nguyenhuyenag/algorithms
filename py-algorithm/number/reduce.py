import math
import unittest
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""

"""
class Solution(unittest.TestCase):

    @staticmethod
    def gcd_1(a, b):
        while a != b:
            if a > b:
                a -= b
            else:
                b -= a
        return a

    @staticmethod
    def reduce_fraction_1(f):
        a, b = f
        _gcd = math.gcd(a,b)
        if _gcd == 0:
            return f
        return [a / _gcd, b / _gcd]

    @staticmethod
    def reduce_fraction(f):
        t = Fraction(*f)
        return [t.numerator, t.denominator]

    def test(self):
        self.assertEqual([3, 1], self.reduce_fraction([60, 20]))


if __name__ == '__main__':
    unittest.main()
