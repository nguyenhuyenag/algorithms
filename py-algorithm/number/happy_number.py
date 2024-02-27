import unittest

"""
    https://leetcode.com/problems/happy-number/
    
    Số hạnh phúc là số mà tổng bình phương các chữ số liên tục, sau cho kết quả cuối cùng là số 1
    
    Input: n = 19 -> true
       12 + 92 = 82
       82 + 22 = 68
       62 + 82 = 100
       12 + 02 + 02 = 1
"""


class Solution(unittest.TestCase):

    def sum_of_digits_squared(self, n: int) -> int:
        return sum(int(d) ** 2 for d in str(n))

    def isHappy(self, n: int) -> bool:
        while n > 9:
            n = self.sum_of_digits_squared(n)
        return n == 1 or n == 7

    def test(self):
        # self.assertEqual(True, self.isHappy(19))
        # self.assertEqual(False, self.isHappy(2))
        # self.assertEqual(True, self.isHappy(7))
        self.assertEqual(True, self.isHappy(13))


if __name__ == '__main__':
    unittest.main()
