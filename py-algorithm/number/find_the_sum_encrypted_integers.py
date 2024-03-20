import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/find-the-sum-of-encrypted-integers/
"""


class Solution(unittest.TestCase):

    # @staticmethod
    def encrypt(self, n: int):
        num = str(n)
        max_digit = max(int(digit) for digit in num)
        return int(str(max_digit) * len(num))

    def sumOfEncryptedInt(self, nums: List[int]) -> int:
        return sum(self.encrypt(num) for num in nums)

    def test(self):
        self.assertEqual(6, self.sumOfEncryptedInt([1, 2, 3]))
        self.assertEqual(66, self.sumOfEncryptedInt([10, 21, 31]))


if __name__ == '__main__':
    unittest.main()
