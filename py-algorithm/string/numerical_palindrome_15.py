import unittest

from parameterized import parameterized

"""
    https://www.codewars.com/kata/58e09234ca6895c7b300008c/
"""


def is_palindrome(num: int) -> bool:
    return num >= 10 and str(num) == str(num)[::-1]


def palindrome(num, s):
    if not isinstance(num, int) or not isinstance(s, int) or num < 0 or s < 0:
        return "Not valid"

    result = []

    while s > 0:
        if is_palindrome(num):
            result.append(num)
            s -= 1
        num += 1

    return result


class TestSolution(unittest.TestCase):

    @parameterized.expand([
        (6, 4, [11, 22, 33, 44]),
        (75, 1, [77]),
        (19, 3, [22, 33, 44]),
        (101, 2, [101, 111]),
        ("ACCDDCCA", 3, "Not valid")
    ])
    def test_is_cleanly_nested(self, num, size, expected):
        self.assertEqual(palindrome(num, size), expected)


if __name__ == '__main__':
    unittest.main()
