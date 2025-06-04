import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

from parameterized import parameterized

"""
    
"""


def my_method(value):
    return value


class Solution(unittest.TestCase):

    @parameterized.expand([
        (True, True),
        (False, False),
        (1, 1)
    ])
    def test_is_cleanly_nested(self, test_input, expected):
        self.assertEqual(my_method(test_input), expected)

    @unittest.skip("Temporarily disabling this test")
    def test_2(self):
        self.assertEqual(True, True)


if __name__ == '__main__':
    unittest.main()
