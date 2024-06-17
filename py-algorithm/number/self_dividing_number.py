import unittest

from typing import List

"""
    https://leetcode.com/problems/self-dividing-numbers/
    
    Gọi số n là `self-dividing number` nếu nó chia hết cho tất cả các chữ số của nó.

    Tìm self-dividing number trong đoan [x,y] cho trước.
"""


class Solution(unittest.TestCase):

    def validate(self, n: int):
        for digit in str(n):
            if digit == '0' or n % int(digit) != 0:
                return False

        return True

    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        result = []
        for i in range(left, right + 1):
            if self.validate(i):
                result.append(i)

        return result

    def test(self):
        self.assertEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22], self.selfDividingNumbers(1, 22))


if __name__ == '__main__':
    unittest.main()
