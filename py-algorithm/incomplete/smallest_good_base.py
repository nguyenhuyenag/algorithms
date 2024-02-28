import unittest

"""
    https://leetcode.com/problems/smallest-good-base/
    
    Good-base là base mà khi biểu diễn số n theo base, kết quả chỉ toàn số 1.
    
    Cho số nguyên n, tìm good-base của nó.
    
    Ví dụ 13 biểu diễn ở dạng cơ số 3 là 111
"""
class Solution(unittest.TestCase):

    def convert_to_base(self, n: int, base: int) -> str:
        if n == 0: return "0"
        result = []
        while n > 0:
            result.append(str(n % base))
            n //= base
        return ''.join(result[::-1])

    def check_digit_one(self, s: str) -> bool:
        for c in s:
            if c != '1':
                return False
        return True

    def smallestGoodBase(self, ns: str) -> str:
        n = int(ns)
        for i in range(2, n + 1):
            val = self.convert_to_base(n, i)
            if self.check_digit_one(val):
                # print(val)
                return str(i)

        return ""

    def test(self):
        self.assertEqual("3", self.smallestGoodBase("13"))
        self.assertEqual("8", self.smallestGoodBase("4681"))
        # Time limit exceeded
        # self.assertEqual("999999999999999999", self.smallestGoodBase("1000000000000000000"))


if __name__ == '__main__':
    unittest.main()
