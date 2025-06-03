import unittest

"""
    https://www.codewars.com/kata/54d512e62a5e54c96200019e/
"""


def prime_factors(n):
    result = []
    i = 2
    while i * i <= n:
        count = 0
        while n % i == 0:
            count += 1
            n = n // i

        if count > 0:
            result.append(f"({i}**{count})" if count > 1 else f"({i})")
        i += 1

    if n > 1:
        result.append(f"({n})")

    return ''.join(result)


class Solution(unittest.TestCase):

    def test_1(self):
        self.assertEqual("(2**5)(5)(7**2)(11)", prime_factors(86240))
        self.assertEqual("(2**2)(3**3)(5)(7)(11**2)(17)", prime_factors(7775460))
        self.assertEqual("(7919)", prime_factors(7919))


if __name__ == '__main__':
    unittest.main()
