import collections
from queue import PriorityQueue
import unittest
from typing import List

"""

"""


class Solution(unittest.TestCase):

    def get_length_of_missing_array(self, arrays):
        if arrays is None or len(arrays) == 0:
            return 0

        lengths = sorted(map(lambda arr: 0 if arr is None else len(arr), arrays))

        if any(length == 0 for length in lengths):
            return 0

        for i in range(len(lengths) - 1):
            if lengths[i] + 1 != lengths[i + 1]:
                return lengths[i] + 1

        return 0

    def test(self):
        self.assertEqual(3, self.get_length_of_missing_array([[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]]))


if __name__ == '__main__':
    unittest.main()
