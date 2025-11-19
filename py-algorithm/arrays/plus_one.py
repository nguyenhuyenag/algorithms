import unittest

from typing import List

"""
    https://leetcode.com/problems/plus-one/

    Cho một số nguyên biểu diễn dưới dạng mảng, trả về mảng kết quả của số đó + 1
"""


class Solution(unittest.TestCase):

    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for v in digits:
            num = 10 * num + v
        digits = []
        num += 1
        while num > 0:
            digits.append(num % 10)
            num //= 10

        return digits.reverse()

        def test(self):
            self.assertEqual([1, 2, 4], self.plusOne([1, 2, 3]))


if __name__ == '__main__':
    unittest.main()
