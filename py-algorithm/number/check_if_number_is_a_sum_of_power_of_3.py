import unittest

from typing import List

"""
    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

    Cho số nguyên dương n. Kiểm tra xem n có phải dạng

        n = 3^0 + 3^1 + ... +
"""


class Solution(unittest.TestCase):

    def checkPowersOfThree(self, n: int) -> bool:
        # 1 = 3^0
        if n == 1: return True
        if n % 3 == 2: return False
        return self.checkPowersOfThree(n // 3)

    def test(self):
        self.assertEqual(True, self.checkPowersOfThree(3))
        self.assertEqual(True, self.checkPowersOfThree(12))


if __name__ == '__main__':
    unittest.main()
