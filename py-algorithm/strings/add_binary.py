import unittest

"""
    https://leetcode.com/problems/add-binary/description/
    
    Cộng 2 chuỗi nhị phân
    
    Nguyên tắc cơ bản để cộng hai số nhị phân như sau:
     
           0 + 0 = 0
           1 + 0 = 1
           0 + 1 = 1
           1 + 1 = 10 (ghi 0 nhớ 1)
"""
class Solution(unittest.TestCase):

    def addBinary(self, a: str, b: str) -> str:
        result = []
        len1, len2 = len(a), len(b)
        len_max = max(len1, len2)
        rem = 0
        for i in range(len_max):
            n1 = ord(a[-(i + 1)]) - ord('0') if i < len1 else 0
            n2 = ord(b[-(i + 1)]) - ord('0') if i < len2 else 0
            _sum = n1 + n2 + rem
            result.append(_sum % 2)
            rem = _sum // 2

        if rem > 0:
            result.append(rem)

        return ''.join(map(str, result[::-1]))

    def test(self):
        self.assertEqual("100", self.addBinary("1", "11"))
        self.assertEqual("10101", self.addBinary("1010", "1011"))


if __name__ == '__main__':
    unittest.main()
