import math
import unittest

def isPP_OK(n):
    sqrt = int(math.sqrt(n))
    for a in range(2, sqrt + 1):
        b = 0
        num = n

        while num % a == 0:
            b = b + 1
            num = num / a

        if num == 1:
            return [a, b]

    return None


def isPP(n):
    a, b = 2, 2
    while a ** 2 <= n:
        if a ** b == n:
            return [a, b]

        if a * b > n:
            a += 1
            b = 1

        b += 1
    return None


class TestIsPPFunction(unittest.TestCase):

    def test_isPP_with_perfect_power(self):
        self.assertEqual([2, 2], isPP(4))
        self.assertEqual(None, isPP(5))

    # def test_isPP_with_non_perfect_power(self):


if __name__ == '__main__':
    unittest.main()
