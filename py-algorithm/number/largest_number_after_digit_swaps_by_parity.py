import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
    
    Cho số nguyên dương n. Ta có thể hoán đổi vị trí 2 chữ số nếu chúng có cùng
    tính chẵn - lẻ

    Hãy trả về giá trị lớn nhất.

    Ý tưởng:

        - Giữ nguyên cấu trúc chẵn - lẽ của số ban đầu.
        - Chia các chữ số ra 2 dãy chẵn và lẽ, sắp xếp chúng theo thứ tự giảm dần.
        - Duyệt số ban đầu, tùy thuộc vào tính chẵn lẽ mà lấy các phần tử của 2 dãy
          ghép vào lần lượt.
"""


class Solution(unittest.TestCase):

    def largestInteger(self, num: int) -> int:
        digits = list(map(int, str(num)))

        even = []
        odd = []

        for digit in digits:
            if digit % 2 == 0:
                even.append(digit)
            else:
                odd.append(digit)

        even.sort(reverse=True)
        odd.sort(reverse=True)

        result = 0
        pe = 0
        po = 0
        for d in digits:
            if d % 2 == 0:
                result = 10 * result + even[pe]
                pe += 1
            else:
                result = 10 * result + odd[po]
                po += 1

        return result

    def test_1(self):
        self.assertEqual(3412, self.largestInteger(1234))

    def test_2(self):
        self.assertEqual(87655, self.largestInteger(65875))


if __name__ == '__main__':
    unittest.main()
