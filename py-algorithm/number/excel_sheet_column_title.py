import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/excel-sheet-column-title/

    Cho số nguyên, in ra chuỗi đại diện của cột đó.

        1   ->  A
        2   ->  B
        3   ->  C
        ...
        26  ->  Z
        
        27  ->  AA
        28  ->  AB
        
    Từ [A, Z] có 26 ký tự.
"""


class Solution(unittest.TestCase):

    def convertToTitle(self, n: int) -> str:
        result = []
        while n > 0:
            # Convert to 0-indexed
            n -= 1
            # Find the remainder
            mod = n % 26
            char = chr(mod + ord('A'))
            result.append(char)
            # Move to the next digit
            n //= 26

        # Reverse the result list since characters are appended in reverse order
        return ''.join(result[::-1])

    def test(self):
        self.assertEqual('A', self.convertToTitle(1))
        self.assertEqual('AA', self.convertToTitle(27))
        self.assertEqual('ABC', self.convertToTitle(731))


if __name__ == '__main__':
    unittest.main()
