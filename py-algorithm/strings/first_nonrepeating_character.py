import collections
import unittest
from typing import List

"""
    https://www.codewars.com/kata/52bc74d4ac05d0945d00054e/
"""
class Solution(unittest.TestCase):

    def first_non_repeating_letter_2(self, s):
        counter = collections.Counter(s.lower())
        for c in s:
            if counter[c.lower()] == 1:
                return c

        return ''

    def first_non_repeating_letter(self, s):
        string_lower = s.lower()
        for i, letter in enumerate(string_lower):
            if string_lower.count(letter) == 1:
                return s[i]
        return ''

    def test(self):
        self.assertEqual("a", self.first_non_repeating_letter('a'))
        self.assertEqual("t", self.first_non_repeating_letter('stress'))
        self.assertEqual("e", self.first_non_repeating_letter('moonmen'))
        self.assertEqual("T", self.first_non_repeating_letter('sTreSS'))


if __name__ == '__main__':
    unittest.main()
