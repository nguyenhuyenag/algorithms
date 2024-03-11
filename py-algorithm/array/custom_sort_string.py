import sys
import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/custom-sort-string/
    
    Cho 2 chuỗi s1 (các ký tự là duy nhất), s2. Sắp xếp lại s2 theo thứ tự các ký tự trong s1    
"""


class Solution(unittest.TestCase):

    @staticmethod
    def customSortString(order: str, s: str) -> str:
        counter = {c: i for i, c in enumerate(order)}
        result = list(s)
        result.sort(key=lambda x: counter.get(x, float('inf')))
        return "".join(result)

    def test(self):
        self.assertEqual("cbad", self.customSortString("cba", "abcd"))


if __name__ == '__main__':
    unittest.main()
