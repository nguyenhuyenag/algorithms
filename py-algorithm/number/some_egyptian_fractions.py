import unittest
from fractions import Fraction

"""
    https://www.codewars.com/kata/54f8693ea58bce689100065f/train/python
    
    Biểu diễn phân số a/b thành tổng của các phân số Ai Cập khác nhau.
    
    a/b = 1/(x + 1) + [a(x + 1) - b] / [b(x + 1)]
"""
class Solution(unittest.TestCase):

    @staticmethod
    def decompose(n):
        result = []
        frac = Fraction(n)
        if frac.numerator == 0: return []
        if frac.denominator == 1: return [str(frac.numerator)]
        while frac.numerator != 1:
            a, b = frac.numerator, frac.denominator
            if a > b:
                x = a // b
                m = a % b
                n = b
                s = str(x)
            else:
                x = b // a
                m = a * (x + 1) - b
                n = b * (x + 1)
                s = "1" if x == 0 else f"1/{x + 1}"

            result.append(s)
            frac = Fraction(m, n)

        result.append(str(frac))
        return result

    def test(self):
        self.assertEqual([], self.decompose('0'))
        self.assertEqual(["1/2", "1/4"], self.decompose('3/4'))
        self.assertEqual(["1/2", "1/4", "1/20"], self.decompose('4/5'))
        self.assertEqual(["25"], self.decompose('25'))
        self.assertEqual(["1"], self.decompose('1.0'))
        self.assertEqual(["1/2", "1/7", "1/59", "1/5163", "1/53307975"], self.decompose('0.66'))
        self.assertEqual(['429', '1/2', '1/10'], self.decompose('429.6'))


if __name__ == '__main__':
    unittest.main()
