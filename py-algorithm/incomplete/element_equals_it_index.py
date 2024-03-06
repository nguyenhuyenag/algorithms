import unittest

"""
    https://www.codewars.com/kata/5b7176768adeae9bc9000056/
"""
class Solution(unittest.TestCase):

    @staticmethod
    def index_equals_value(arr):
        for i in range(len(arr)):
            if arr[i] == i:
                return i
        return -1

    def test(self):
        self.assertEqual(2, self.index_equals_value([-8, 0, 2, 5]))
        self.assertEqual(-1, self.index_equals_value([-1, 0, 3, 6]))


if __name__ == '__main__':
    unittest.main()
