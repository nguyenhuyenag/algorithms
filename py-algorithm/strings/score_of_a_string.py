import unittest

"""
    https://leetcode.com/problems/score-of-a-string/

    Cho chuỗi s, tính tổng giá trị:

        A = |s0 - s1| + |s1 - s2| + ...

    Trong đó si là giá trị ASCII của vị trị i.
"""


class Solution(unittest.TestCase):

    def scoreOfString(self, s: str) -> int:
        score = 0
        for i in range(len(s) - 1):
            score += abs(ord(s[i]) - ord(s[i + 1]))
        return score

    def test(self):
        self.assertEqual(13, self.scoreOfString("hello"))


if __name__ == '__main__':
    unittest.main()
