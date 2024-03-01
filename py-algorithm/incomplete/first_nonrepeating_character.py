import collections
import unittest
from typing import List

"""
    https://www.codewars.com/kata/52bc74d4ac05d0945d00054e/
"""
class Solution(unittest.TestCase):

    def first_non_repeating_letter(self, s):
        counter = collections.Counter(s)
        for k, v in counter.items():
            if v == 1:
                return k
        return ''

    def test(self):
        self.assertEqual("a", self.first_non_repeating_letter('a'))
        self.assertEqual("t", self.first_non_repeating_letter('stress'))
        self.assertEqual("e", self.first_non_repeating_letter('moonmen'))
        self.assertEqual("T", self.first_non_repeating_letter('sTreSS'))


if __name__ == '__main__':
    unittest.main()
