import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

    Cho hai số nguyên dương n, k. Chuỗi nhị phân S(n) được tạo như sau:

        S(1) = "0"
        S(i) = S(i - 1) + "1" + reverse(invert(S(i - 1))) với i > 1

    Trong đó:
        - Dấu + là phép nối chuỗi.
        - reverse(x) trả về chuỗi x sau khi đảo ngược thứ tự.
        - invert(x) đảo tất cả các bit trong x (0 đổi thành 1 và 1 đổi thành 0).

    Ví dụ, bốn chuỗi đầu tiên trong dãy là:

        S(1) = "0"
        S(2) = "011"
        S(3) = "0111001"
        S(4) = "011100110110001"

    -> Hãy trả về bit thứ k trong S(n).
"""


class Solution(unittest.TestCase):

    def findKthBit(self, n: int, k: int) -> str:
        s = "0"

        for _ in range(1, n):
            # reverse + invert
            inverted_reversed = "".join(
                '1' if bit == '0' else '0'
                for bit in reversed(s)
            )

            s = s + "1" + inverted_reversed

        return s[k - 1]

    def test_1(self):
        self.assertEqual('0', self.findKthBit(3, 1))

    def test_2(self):
        self.assertEqual('1', self.findKthBit(4, 11))


if __name__ == '__main__':
    unittest.main()
