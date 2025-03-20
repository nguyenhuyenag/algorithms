import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://www.codewars.com/kata/58067088c27998b119000451/train/python
    
    Tìm giai thừa của số n cho trước, ví dụ: 120 = 5!   
"""


class Solution(unittest.TestCase):

    def reverse_factorial_ok(self, num) -> int:
        dp = [1]
        i = 1;
        while dp[-1] <= num:
            dp.append(dp[-1] * i)
            if dp[-1] == num:
                return f"{i}!"
            i += 1

        return 'None'

    def reverse_factorial(self, num) -> str:
        if num < 1:
            return 'None'  # Giai thừa chỉ áp dụng cho số nguyên dương

        i = 1
        current_factorial = 1
        while current_factorial <= num:
            if current_factorial == num:
                return f"{i}!"
            i += 1

            current_factorial *= i

        return 'None'

    def test(self):
        self.assertEqual('5!', self.reverse_factorial(120))
        self.assertEqual('10!', self.reverse_factorial(3628800))
        self.assertEqual('None', self.reverse_factorial(150))
        self.assertEqual('1!', self.reverse_factorial(1))


if __name__ == '__main__':
    unittest.main()
