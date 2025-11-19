import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://www.codewars.com/kata/54d81488b981293527000c8f/train/python
    
    Tìm hai số [ai, aj] trong mảng sao cho ai + aj = k. Nếu có nhiều kết 
    quả thì ưu tiên cặp có chỉ số j nhỏ hơn.
"""
class Solution(unittest.TestCase):

    def sum_pairs_OK(self, nums, k):
        the_dict = {}
        for i, n1 in enumerate(nums):
            n2 = k - n1
            j = the_dict.get(n2, -1)
            if j != -1:
                return [n2, n1]

            if n1 not in the_dict:
                the_dict[n1] = i

    def sum_pairs(self, nums, k):
        cache = set()
        for n1 in nums:
            n2 = k - n1
            if n2 in cache:
                return [n2, n1]

            cache.add(n1)

    def test(self):
        self.assertEqual([3, 7], self.sum_pairs([11, 3, 7, 5], 10))
        self.assertEqual([4, 2], self.sum_pairs([4, 3, 2, 3, 4], 6))


if __name__ == '__main__':
    unittest.main()
