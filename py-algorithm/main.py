import unittest

"""
    https://www.codewars.com/kata/54d512e62a5e54c96200019e/
"""


def prime_factors(n):
    pass


class Solution(unittest.TestCase):

    def test_1(self):
        self.assertEqual("(2**5)(5)(7**2)(11)", prime_factors(86240))
        self.assertEqual("(2**2)(3**3)(5)(7)(11**2)(17)", prime_factors(7775460))
        self.assertEqual("(7919)", prime_factors(7919))


if __name__ == '__main__':
    unittest.main()
