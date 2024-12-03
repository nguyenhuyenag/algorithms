import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/adding-spaces-to-a-string/
"""


class Solution(unittest.TestCase):

    def addSpaces(self, s: str, spaces: List[int]) -> str:
        j = 0
        result = []
        for i, c in enumerate(s):
            if j < len(spaces) and i == spaces[j]:
                result.append(" ")
                j += 1
            result.append(s[i])
        return "".join(result)

    def test(self):
        self.assertEqual("Leetcode Helps Me Learn", self.addSpaces("LeetcodeHelpsMeLearn", [8, 13, 15]))


if __name__ == '__main__':
    unittest.main()
