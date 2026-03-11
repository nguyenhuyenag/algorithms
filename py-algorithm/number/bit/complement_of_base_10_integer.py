import unittest

"""
    https://leetcode.com/problems/complement-of-base-10-integer/

    Cho số nguyên n -> Chuyển nó sang nhị phân
                    -> Đảo ngược các bit: '0' -> '1', '1' -> '0'
                    -> Trả về gía trị thập phân.
    Ví dụ:

        10110 = 1×2⁴ + 0×2³ + 1×2² + 1×2¹ + 0×2⁰
"""


class Solution(unittest.TestCase):

    def bitwiseComplement_OK1(self, n: int) -> int:
        binary = list(format(n, 'b'))
        flipped = ['1' if b == '0' else '0' for b in binary]
        return int(''.join(flipped), 2)

    def bitwiseComplement(self, n: int) -> int:
        if n == 0: return  1

        res = 0
        base = 1

        while n > 0:
            b = 1 if n % 2 == 0 else 0
            res += b * base
            base *= 2
            n //= 2

        return res

    def test_case(self):
        # (input, expected)
        test_cases = [
            (5, 2),
            (7, 0),
            (10, 5)
        ]
        for n, expected in test_cases:
            self.assertEqual(expected, self.bitwiseComplement(n))


if __name__ == '__main__':
    unittest.main()
