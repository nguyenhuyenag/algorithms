import unittest

"""
    https://leetcode.com/problems/maximum-odd-binary-number/
    
    Cho số nguyên dạng nhị phân, tìm số nguyên lẻ lớn nhất từ dãy nhị phân này.
    
    Ý tưởng:
        (1) Số lớn nhất khi tất cả các bit 1 ở trên đầu
        (2) Số nguyên lẻ khi biểu diễn nhị phân luôn luôn có một bit 1 ở cuối.
"""
class Solution(unittest.TestCase):

    def maximumOddBinaryNumber_OK(self, s: str) -> str:
        chars = list(s)
        for i in range(len(chars)):
            if chars[i] == '1':
                chars.insert(0, chars.pop(i))

        return ''.join(chars[1:]) + chars[0]

    def maximumOddBinaryNumber(self, s: str) -> str:
        c, n = s.count('1'), len(s)
        return '1' * (c - 1) + '0' * (n - c) + '1'

    def test(self):
        self.assertEqual("001", self.maximumOddBinaryNumber("100"))
        self.assertEqual("1001", self.maximumOddBinaryNumber("0101"))
        self.assertEqual("101", self.maximumOddBinaryNumber("110"))


if __name__ == '__main__':
    unittest.main()
