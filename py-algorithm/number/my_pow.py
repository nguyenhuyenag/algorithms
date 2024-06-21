import unittest

"""
    https://leetcode.com/problems/powx-n/
    Viết hàm tính a^n
"""
class Solution(unittest.TestCase):

    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        if n < 0:
            x = 1 / x
            n = -n

        if n % 2 == 0:
            t = self.myPow(x, n / 2)
            return t * t
        else:
            return x * self.myPow(x, n - 1)

    def test(self):
        self.assertEqual(pow(6, 6), self.myPow(6, 6))


if __name__ == '__main__':
    unittest.main()
