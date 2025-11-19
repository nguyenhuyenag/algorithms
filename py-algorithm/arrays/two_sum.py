import unittest

from typing import List

"""
    https://www.codewars.com/kata/52c31f8e6605bcc646000082/
    
    Tìm 2 số trong mảng có tổng bằng n. Trả về index của 2 số đó
"""


class Solution(unittest.TestCase):

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        the_dict = {}
        for i, n1 in enumerate(nums):
            n2 = target - n1
            j = the_dict.get(n2, -1)
            if j != -1:
                return [i, j]

            the_dict[n1] = i

        return [-1, -1]

    def pre_test(self, list1, list2):
        self.assertEqual(sorted(list1), sorted(list2))

    def test(self):
        self.pre_test([0, 1], self.twoSum([2, 7, 11, 15], 9))


if __name__ == '__main__':
    unittest.main()
