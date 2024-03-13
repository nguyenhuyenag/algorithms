import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
    
    Hai chuỗi s1, s2 được goi là anagrams nếu sort(s1) = sort(s2).
    Cho mảng words chứa các chuỗi. Nếu words[i-1] và words[i] là anagrams thì xóa word[i].
    Trả về mảng sau khi xóa.
"""


class Solution(unittest.TestCase):

    @staticmethod
    def is_anagram(s1: str, s2: str):
        return Counter(s1) == Counter(s2)

    def removeAnagrams(self, words: List[str]) -> List[str]:
        i = 0
        while i < len(words) - 1:
            s1 = words[i]
            s2 = words[i + 1]
            if self.is_anagram(s1, s2):
                del words[i + 1]
            else:
                i += 1
        return words

    def test(self):
        self.assertEqual(["abba", "cd"], self.removeAnagrams(["abba", "baba", "bbaa", "cd", "cd"]))
        self.assertEqual(["a", "b", "c", "d", "e"], self.removeAnagrams(["a", "b", "c", "d", "e"]))


if __name__ == '__main__':
    unittest.main()
