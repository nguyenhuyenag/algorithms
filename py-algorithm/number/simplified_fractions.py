import unittest
from typing import List
from fractions import Fraction
from math import gcd

"""
    https://leetcode.com/problems/simplified-fractions/
    
    Cho số nguyên n. Tìm tất cả các phân số thuộc (0,1) có mẫu số <= n 
"""


class Solution(unittest.TestCase):

    @staticmethod
    def simplifiedFractions(n: int) -> List[str]:
        result = set()
        for i in range(1, n):
            for j in range(i + 1, n + 1):
                if gcd(i, j) == 1:
                    f = f"{i}/{j}"
                    result.add(f)

        return list(result)

    def test(self):
        self.assertEqual(["1/2"], self.simplifiedFractions(2))
        # self.assertEqual(["1/2", "1/3", "2/3"], self.simplifiedFractions(3))
        # self.assertEqual(["1/2", "1/3", "1/4", "2/3", "3/4"], self.simplifiedFractions(4))


if __name__ == '__main__':
    unittest.main()
