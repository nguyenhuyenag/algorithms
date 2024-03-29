import collections
from collections import Counter

import unittest

"""
    https://leetcode.com/problems/valid-anagram/
    
    Hai chuỗi s1, s2 được gọi là anagram nếu chúng có các ký tự bằng nhau (không tính tứ tự)
    
    Ví dụ: "abc" và "bca" là anagram
"""


class Solution(unittest.TestCase):

    def isAnagram_1(self: str, s2: str) -> bool:
        return Counter(self) == Counter(s2)

    # def isAnagram_3(s1: str, s2: str) -> bool:
    #     mark = 26 * [0]
    #     if len(s1) != len(s2):
    #         return False
    #
    #     for c1, c2 in zip(s1, s2):
    #         mark[ord(c1) - ord('a')] += 1
    #         mark[ord(c2) - ord('a')] -= 1
    #
    #     return all(v == 0 for v in mark)

    def isAnagram_2(self, s1: str, s2: str) -> bool:
        mark = collections.defaultdict(int)
        for k in s1: mark[k] += 1
        for k in s2: mark[k] += -1
        return all(v == 0 for v in mark.values())

    def isAnagram(self, s1: str, s2: str) -> bool:
        mark1 = [0] * 26
        mark2 = [0] * 26
        for c in s1: mark1[c - 'a'] += 1
        for c in s2: mark2[c - 'a'] += 1
        return mark1 == mark2

    def test(self):
        self.assertEqual(False, self.isAnagram("cat", "rat"))
        self.assertEqual(True, self.isAnagram("anagram", "nagaram"))


if __name__ == "__main__":
    unittest.main()
