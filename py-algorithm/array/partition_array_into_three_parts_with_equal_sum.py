import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
    
    Kiểm tra xem liệu có thể chia mảng thành 3 phần có tổng bằng nhau không?
"""


class Solution(unittest.TestCase):

    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        # Tính tổng mảng
        total = sum(arr)

        # Nếu tổng không chia hết cho 3  -> False
        if total % 3 != 0: return False

        # Tổng 1 đoạn
        part = total / 3
        csum = 0
        count = 0
        for i in range(len(arr)):
            csum += arr[i]
            if csum == part:
                csum = 0
                count += 1
                """
                    Nếu đã tìm được 2 đoạn thỏa và chưa duyệt hết mảng -> true,
                    vì total chia hết cho 3
                """
                if count == 2 and i < len(arr) - 1:
                    return True

        return False

    def test(self):
        self.assertEqual(True, self.canThreePartsEqualSum([0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1]))
        self.assertEqual(True, self.canThreePartsEqualSum([3, 3, 6, 5, -2, 2, 5, 1, -9, 4]))
        self.assertEqual(False, self.canThreePartsEqualSum([0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1]))


if __name__ == '__main__':
    unittest.main()
