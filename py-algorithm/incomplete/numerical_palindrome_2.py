import unittest

from parameterized import parameterized

"""
    https://www.codewars.com/kata/58de819eb76cf778fe00005c/
"""


def is_palindrome(num: int) -> bool:
    return num >= 10 and str(num) == str(num)[::-1]


def palindrome(num):
    ns = str(num)
    i = 0
    j = 0
    while i < len(ns) and j < len(ns):
        if ns[i] == ns[j]:
            i += 1
            j -= 1
        else:
            return False


class TestSolution(unittest.TestCase):

    @parameterized.expand([
        (868, True),
        (1321, False),
        (1215, True),
        (2, False),
        (123322367, True),
        (1551, True)
    ])
    def test_is_cleanly_nested(self, num, expected):
        self.assertEqual(palindrome(num), expected)


if __name__ == '__main__':
    unittest.main()
