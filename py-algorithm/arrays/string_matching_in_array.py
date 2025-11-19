import unittest

from typing import List

"""
    https://leetcode.com/problems/string-matching-in-an-array/description/
    
    Cho mảng các chuỗi. Trả về mảng sau cho mỗi phần tử là chuỗi con của
    một phần tử nào đó trong mảng gốc.    
"""


class Solution(unittest.TestCase):

    # Bad solution
    def stringMatching_Bad(self, words: List[str]) -> List[str]:
        result = []
        size = len(words)
        for i in range(size):
            for j in range(size):
                if i != j and words[j].__contains__(words[i]):
                    result.append(words[i])
                    break

        return result

    # Optimze solution
    def stringMatching_1(self, words: List[str]) -> List[str]:
        result = []
        words.sort(key=lambda x: len(x))
        size = len(words)
        for i in range(size):
            for j in range(i + 1, size):
                if words[j].__contains__(words[i]):
                    result.append(words[i])
                    break

        return result

    # Optimze solution
    def stringMatching(self, words: List[str]) -> List[str]:
        result = []
        words.sort(key=lambda x: len(x))
        for i, word in enumerate(words):
            for longer_word in words[i + 1:]:
                if word in longer_word:
                    result.append(word)
                    break

        return result

    def sort_and_test(self, l1: List[str], l2: List[str]):
        l1.sort()
        l2.sort()
        self.assertEqual(l1, l2)

    def test1(self):
        self.sort_and_test(["as", "hero"], self.stringMatching(["mass", "as", "hero", "superhero"]))

    def test2(self):
        self.sort_and_test(["code", "et"], self.stringMatching(["leetcode", "et", "code"]))


if __name__ == '__main__':
    unittest.main()
