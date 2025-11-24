import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/binary-prefix-divisible-by-5/
    
    Cho mảng nums và x[i] là số nguyên có dạng biểu diễn nhị phân được tạo bởi đoạn con nums[0..i].
    Trả về mảng boolean xem x[i] có chia hết cho 5 hay không.
    
    Ý tưởng là tính giá trị thập phân của từng x[i]:
      x₀ = nums[0]
      x₁ = nums[0..1] = nums[0]*2 + nums[1]
      x₂ = nums[0..2] = ((nums[0]*2 + nums[1])*2 + nums[2])
    Tuy nhiên cách này sẽ bị tràn số.
    
    Cải tiến: Vì bài toán yêu cầu xem x[i] có chia hết cho 5 hay không, cho nên ta chỉ cần lưu phần dư của 
    x[i] khi chia cho 5.
"""


class Solution(unittest.TestCase):

    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        results = []
        x_new = 0
        for x in nums:
            x_new = (x_new * 2 + x) % 5
            results.append(x_new == 0)
        return results

    def test_1(self):
        self.assertEqual([True, False, False], self.prefixesDivBy5([0, 1, 1]))
        self.assertEqual([False, False, False], self.prefixesDivBy5([1, 1, 1]))


if __name__ == '__main__':
    unittest.main()
