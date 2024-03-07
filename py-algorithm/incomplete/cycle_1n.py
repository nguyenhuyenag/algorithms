import unittest
from decimal import Decimal, getcontext
getcontext().prec = 1_00

"""
    https://www.codewars.com/kata/5a057ec846d843c81a0000ad/
    
    1/11 = 0.09_09_09_09
"""
class Solution(unittest.TestCase):

    @staticmethod
    def cycle(n: int) -> int:
        # Set precision for Decimal calculations
        getcontext().prec = 2 * n

        # Tính giá trị phân số và chuyển sang chuỗi
        fraction = Decimal(1) / Decimal(n)
        fraction_str = str(fraction)

        # Tìm vị trí của dấu chấm thập phân
        index = fraction_str.index('.')

        for length in range(1, n):
            # Lấy chuỗi con có độ dài length từ vị trí sau dấu chấm thập phân
            substring = fraction_str[index + 1:index + 1 + length]

            # Kiểm tra xem chuỗi con có lặp lại hay không
            if substring * (n // length) == fraction_str[index + 1:index + 1 + length * (n // length)]:
                return length

        return -1
    # def cycle(n: int) -> int:
    #     s = str(Decimal(1) / Decimal(n))
    #     index = s.index('.')
    #     j = 1
    #     if index != -1:
    #         for i in range(index + 1, len(s)):
    #             x = s[index + 1:i + 1]
    #             y = s[i + 1:i + 1 + j]
    #             j += 1
    #             if x == y:
    #                 return j - 1
    #
    #         return -1

    def test(self):
        # self.assertEqual(2, self.cycle(11))
        # self.assertEqual(6, self.cycle(13))
        # self.assertEqual(-1, self.cycle(5))
        # self.assertEqual(22, self.cycle(69))
        # self.assertEqual(2, self.cycle(33))
        self.assertEqual(-1, self.cycle(18118))


if __name__ == '__main__':
    unittest.main()
