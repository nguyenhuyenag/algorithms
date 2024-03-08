import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""

"""


class Solution(unittest.TestCase):

    @staticmethod
    def countBits(n: int) -> List[int]:
        result = []
        for i in range(n + 1):
            result.append(i.bit_count())
        return result

    def test(self):
        self.assertEqual([0, 1, 1], self.countBits(2))
        self.assertEqual([0, 1, 1, 2, 1, 2], self.countBits(5))


if __name__ == '__main__':
    unittest.main()
