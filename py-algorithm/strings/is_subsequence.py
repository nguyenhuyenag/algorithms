import unittest

"""
    Chủ đề: Two pointer

    https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

    Kiểm tra chuỗi con:

        Chuỗi s1 là con của s2 nếu ta xóa một vài ký tự trong s2 (không thay đổi thứ tự) sẽ thu được s1.

    Xem thêm: leetcode > AppendCharactersToStringToMakeSubsequence.java
"""


class Solution(unittest.TestCase):

    def isSubsequence(self, s1: str, s2: str) -> bool:
        p1 = 0
        p2 = 0
        while p1 < len(s1) and p2 < len(s2):
            # Tìm được vị trí khớp của s1 trong s2
            if s1[p1] == s2[p2]:
                p1 += 1

            p2 += 1

        # Nếu p1 đi đến hết chuỗi -> Tìm được tất cả các vị trị khớp của s1 trong s2
        return p1 == len(s1)

    def test(self):
        self.assertEqual(True, self.isSubsequence("abc", "ahbgdc"))
        self.assertEqual(False, self.isSubsequence("axc", "ahbgdc"))


if __name__ == '__main__':
    unittest.main()
