import math
import unittest

"""
    https://www.codewars.com/kata/57be674b93687de78c0001d9/
    
    Cho số nguyên dương N, trả về số nguyên dương lớn nhất k sao cho 3^k < N.
    
    For example,
    
        3 --> 0
        4 --> 1
    
    You may assume that the input to your function is always a positive integer.
"""


def largest_power_1(N: int) -> int:
    k = math.log(N, 3)
    return int(k) if 3 ** int(k) < N else int(k) - 1


def largest_power(N: int) -> int:
    k = 0
    while 3 ** k < N:
        k += 1

    return k - 1


class Solution(unittest.TestCase):

    def test(self):
        self.assertEqual(0, largest_power(2))
        self.assertEqual(0, largest_power(3))
        self.assertEqual(1, largest_power(4))
        self.assertEqual(1, largest_power(5))
        self.assertEqual(1, largest_power(7))


if __name__ == '__main__':
    unittest.main()
