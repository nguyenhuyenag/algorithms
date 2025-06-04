import math
import unittest
from parameterized import parameterized

"""
    https://www.codewars.com/kata/67c9c1cdf96c66388eb35cd4/
"""


def is_triangle_number(n):
    if not isinstance(n, int) or n < 0:
        return False

    delta = 1 + 8 * n
    sqrt_delta = math.isqrt(delta)

    if sqrt_delta * sqrt_delta != delta:
        return False

    return (-1 + sqrt_delta) % 2 == 0


class TestSolution(unittest.TestCase):

    @parameterized.expand([
        (3, True),
        (5, False),
        (6.15, False),
        ("hello!", False),
        (0, True),
        (1, True)
    ])
    def test_is_cleanly_nested(self, test_input, expected):
        self.assertEqual(is_triangle_number(test_input), expected)


if __name__ == '__main__':
    unittest.main()
