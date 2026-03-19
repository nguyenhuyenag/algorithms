import unittest

from typing import List

"""
    https://leetcode.com/problems/adding-spaces-to-a-string/
    
    Cho một chuỗi s và một mảng chỉ số spaces. Thêm một khoảng trắng
	vào chuỗi s tại mỗi vị trí được chỉ định trong mảng spaces.
"""


class Solution(unittest.TestCase):

    def addSpaces_OK1(self, s: str, spaces: List[int]) -> str:
        j = 0
        result = []
        for i, c in enumerate(s):
            if j < len(spaces) and i == spaces[j]:
                result.append(" ")
                j += 1
            result.append(s[i])

        return "".join(result)

    def addSpaces(self, s: str, spaces: List[int]) -> str:
        res = []
        start = 0
        for i in spaces:
            res.append(s[start:i])
            start = i

        res.append(s[start:])
        return " ".join(res)

    def test(self):
        self.assertEqual(
            "Leetcode Helps Me Learn",
            self.addSpaces("LeetcodeHelpsMeLearn", [8, 13, 15])
        )


if __name__ == '__main__':
    unittest.main()
