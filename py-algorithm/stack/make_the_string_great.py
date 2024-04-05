import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/make-the-string-great/

    Cho chuỗi s, nếu s[i] và s[i+1] mà 'một viết hoa, một viết thường' của cùng 1 ký tự
    thì tiến hành xóa cặp ký tự này. Trả về chuỗi s sau khi xóa tất cả các cặp như trên.

    Ví dụ:
        leEeetcode -> l(eE)eetcode -> leetcode
        abBAcC -> (ab)BAcC -> (BA)cC -> (cC) -> ""
"""


class Solution(unittest.TestCase):

    @staticmethod
    def isNotGoodPair(c1:str, c2:str):
        return c1 != c2 and c1.lower() == c2.lower()
        # return c1 != c2 and (c1 == c2.lower() or c1 == c2.upper())

    def makeGood(self, s: str) -> str:
        stack = []
        for c in s:
            if stack and self.isNotGoodPair(stack[-1], c):
                stack.pop()
            else:
                stack.append(c)
        return "".join(stack)

    def test(self):
        self.assertEqual("leetcode", self.makeGood("leEeetcode"))
        self.assertEqual("", self.makeGood("abBAcC"))


if __name__ == '__main__':
    unittest.main()
