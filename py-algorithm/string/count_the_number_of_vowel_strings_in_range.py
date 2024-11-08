import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
"""


class Solution(unittest.TestCase):

    # def vowelStrings_OK(self, words: List[str], left: int, right: int) -> int:
    #     vowels = {'a', 'e', 'o', 'u', 'i'}
    #     count = 0
    #     for i in range(left, right + 1):
    #         word = words[i]
    #         start = word[0]
    #         end = word[-1]
    #         if vowels.__contains__(start) and vowels.__contains__(end):
    #             count += 1
    #
    #     return count

    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        count = 0
        vowels = {'a', 'e', 'o', 'u', 'i'}
        for i in range(left, right + 1):
            if words[i][0] in vowels and words[i][-1] in vowels:
                count += 1

        return count

    def test(self):
        self.assertEqual(2, self.vowelStrings(["are", "amy", "u"], 0, 2))
        self.assertEqual(3, self.vowelStrings(["hey", "aeo", "mu", "ooo", "artro"], 1, 4))


if __name__ == '__main__':
    unittest.main()
