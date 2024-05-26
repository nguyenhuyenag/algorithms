import unittest
from typing import List

"""
    https://leetcode.com/problems/counting-bits/
    
    Cho số nguyên n. Với mỗi i thuộc [0, n] đếm số bit '1' trong biểu diễn nhị phân của i.
    Trả về mảng n + 1 kết quả trên.
"""


class Solution(unittest.TestCase):

    def myBitCount(self, n: int) -> int:
        count = 0
        while n > 0:
            # divmod(x, y) = divmod(x // y, x % y) = (a, b) -> a là phần nguyên, b là phần dư
            div = divmod(n, 2)
            if div[1] == 1: count += 1
            n //= 2
        return count

    # @staticmethod
    def countBits(self, n: int) -> List[int]:
        result = []
        for i in range(n + 1):
            # result.append(i.bit_count())
            result.append(self.myBitCount(i))
        return result

    def test(self):
        self.assertEqual([0, 1, 1], self.countBits(2))
        self.assertEqual([0, 1, 1, 2, 1, 2], self.countBits(5))


if __name__ == '__main__':
    unittest.main()
