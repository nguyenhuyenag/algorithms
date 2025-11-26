import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

    Giả sử word là số dưới dạng chuỗi và số nguyên m. Gọi div[i] là số tạo từ word[0,...,i].

    Mảng divisibility (gọi là div) của word là một mảng số nguyên có độ dài n sao cho:

        - div[i] = 1 nếu giá trị số tạo bởi chuỗi con word[0,...,i] (tức từ ký tự đầu đến ký
        tự thứ i) chia hết cho m.

        - div[i] = 0 nếu không chia hết.

    Trả về mảng divisibility của chuỗi word.
"""


class Solution(unittest.TestCase):

    def divisibilityArray(self, word: str, m: int) -> List[int]:
        size = len(word)
        div = [0] * size
        rem = 0
        for i in range(size):
            rem = (rem * 10 + ord(word[i]) - ord('0')) % m
            div[i] = 1 if rem == 0 else 0
        return div

    def test_1(self):
        self.assertEqual([1, 1, 0, 0, 0, 1, 1, 0, 0], self.divisibilityArray("998244353", 3))
        self.assertEqual([0, 1, 0, 1], self.divisibilityArray(word="1010", m=10))


if __name__ == '__main__':
    unittest.main()
