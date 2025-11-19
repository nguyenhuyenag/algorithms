import unittest

from typing import List

"""
    https://leetcode.com/problems/sum-of-unique-elements/

	Tính tổng các phần tử duy nhất trong mảng.
"""


class Solution(unittest.TestCase):

    def sumOfUnique(self, nums: List[int]) -> int:
        the_dict = {}
        sum_unique = 0
        for x in nums:
            if the_dict.get(x, 0) == 0:
                the_dict[x] = 1
                sum_unique += x
            elif the_dict.get(x) == 1:
                the_dict[x] = 2
                sum_unique -= x

        return sum_unique

    def test(self):
        self.assertEqual(4, self.sumOfUnique([1, 2, 2, 3]))
        self.assertEqual(0, self.sumOfUnique([1, 1, 1, 1]))


if __name__ == '__main__':
    unittest.main()
