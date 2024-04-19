import math
import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/maximum-prime-difference/
    Cho mảng số nguyên. Giả sử arr[i], arr[j] là 2 số nguyên tố. Tìm giá trị lớn nhất của |arr[i] - arr[j]|.
 
    Ví dụ: nums = [4,2,9,5,3] -> Kết quả là 3
 
    Vì nums[1], nums[3], và nums[4] là số nguyên tố. Nên |4 - 1| = 3 là GTLN.
"""


class Solution(unittest.TestCase):

    def prime_check(self, n: int) -> bool:
        if n < 2: return False
        _sqrt = int(math.sqrt(n))
        for i in range(2, _sqrt + 1):
            if n % i == 0: return False

        return True

    def maximumPrimeDifference(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r:
            left_check = self.prime_check(nums[l])
            if left_check and self.prime_check(nums[r]):
                return r - l
            elif not left_check:
                l += 1
            else:
                r -= 1

        return 0

    def test(self):
        self.assertEqual(3, self.maximumPrimeDifference([4, 2, 9, 5, 3]))
        self.assertEqual(0, self.maximumPrimeDifference([4, 8, 2, 8]))


if __name__ == '__main__':
    unittest.main()
