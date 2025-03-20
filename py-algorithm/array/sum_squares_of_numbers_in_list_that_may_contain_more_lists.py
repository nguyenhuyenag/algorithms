import unittest

"""
    https://www.codewars.com/kata/57882daf90b2f375280000ad/
"""


class Solution(unittest.TestCase):

    def sumsquares_ok(self, arr) -> int:
        result = 0
        for value in arr:
            if isinstance(value, int):
                result += value ** 2
            elif isinstance(value, list):
                result += self.sumsquares(value)

        return result

    def sumsquares(self, arr) -> int:
        return sum([i ** 2 if isinstance(i, int) else self.sumsquares(i) for i in arr])

        return result

    def test_case(self):
        self.assertEqual(14, self.sumsquares([1, 2, 3]))
        self.assertEqual(14, self.sumsquares([[1, 2], 3]))
        self.assertEqual(1, self.sumsquares([[[[[[[[[1]]]]]]]]]))
        self.assertEqual(400, self.sumsquares([10, [[10], 10], [10]]))
        self.assertEqual(325, self.sumsquares([1, [[3], 10, 5, [2, [3], [4], [5, [6]]]], [10]]))


if __name__ == '__main__':
    unittest.main()
