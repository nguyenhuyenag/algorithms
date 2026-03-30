import unittest

"""
    https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/

    Cho 2 chuỗi s1 và s2. Ta có thể hoán đổi ký tự tại 2 vị trí i, j bất kỳ nếu i < j và
    (j - i) chẵn.

    Trả về true nếu có thể làm cho s1 == s2, ngược lại trả về false.

    Ý tưởng:

        - Vì chỉ được swap khi j - i chẵn, tức (i,j) cùng chẵn hoặc lẽ (cùng parity).

        Vì:
            Ta có thể swap tự do trong cùng parity.
                → Thứ tự không quan trọng
                → Chỉ cần số lượng giống nhau (multiset).
"""


class Solution(unittest.TestCase):

    def checkStrings(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False

        even = [0] * 26
        odd = [0] * 26

        for i in range(len(s1)):
            if i % 2 == 0:
                even[ord(s1[i]) - ord('a')] += 1
                even[ord(s2[i]) - ord('a')] -= 1
            else:
                odd[ord(s1[i]) - ord('a')] += 1
                odd[ord(s2[i]) - ord('a')] -= 1

        for i in range(26):
            if even[i] != 0 or odd[i] != 0:
                return False

        return True

    def test_1(self):
        self.assertEqual(False, self.checkStrings("abe", "bea"))
        self.assertEqual(True, self.checkStrings("abcdba", "cabdab"))


if __name__ == '__main__':
    unittest.main()
