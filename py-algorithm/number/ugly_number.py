import unittest

"""
    https://leetcode.com/problems/ugly-number/
    
    Số xấu là số có dạng 2^x * 3^y * 5^z. Viết hàm kiểm tra số xấu
"""
class Solution(unittest.TestCase):

    def isUgly(self, n: int) -> bool:
        if n <= 0: return False
        for factor in [2, 3, 5]:
            while n % factor == 0:
                n //= factor

        return n == 1

    def test(self):
        self.assertEqual(True, self.isUgly(6))
        self.assertEqual(True, self.isUgly(1))


if __name__ == '__main__':
    unittest.main()
