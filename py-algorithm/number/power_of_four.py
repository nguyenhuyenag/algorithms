import unittest

"""
    https://leetcode.com/problems/power-of-four/
    
    Kiểm tra số n có phải là lũy thừa của 4 hay không?
"""
class Solution(unittest.TestCase):

    def isPowerOfFour(self, n: int) -> bool:
        if n == 0: return False
        while n % 4 == 0:
            n //= 4
        return n == 1

    def test(self):
        self.assertEqual(True, self.isPowerOfFour(1))
        self.assertEqual(True, self.isPowerOfFour(16))


if __name__ == '__main__':
    unittest.main()
