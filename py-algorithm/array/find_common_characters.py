import sys
import unittest
from typing import List
from collections import Counter

"""
    https://leetcode.com/problems/find-common-characters/
    
    Cho mảng chuỗi. Tìm các ký tự chung của các phần tử

       ["bella","label","roller"] -> ["e", "l", "l"]
"""
class Solution(unittest.TestCase):

    @staticmethod
    def commonChars(words: List[str]) -> List[str]:
        counters = [Counter(word) for word in words]

        commons = []
        chars_of_first_item = counters[0].keys()
        for c in chars_of_first_item:
            min_value = sys.maxsize
            for map_counter in counters:
                if c not in map_counter:
                    min_value = 0
                    break
                else:
                    min_value = min(min_value, map_counter.get(c))

            commons.extend([c] * min_value)

        return commons

    def test(self):
        self.assertEqual(["e", "l", "l"], self.commonChars(["bella", "label", "roller"]))
        self.assertEqual(["c", "o"], self.commonChars(["cool", "lock", "cook"]))


if __name__ == '__main__':
    unittest.main()
