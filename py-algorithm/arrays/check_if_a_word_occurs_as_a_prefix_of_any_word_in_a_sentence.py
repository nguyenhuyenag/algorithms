import unittest

"""
    https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
"""


class Solution(unittest.TestCase):

    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        for i, word in enumerate(sentence.split(" ")):
            if word.startswith(searchWord):
                return i + 1

        return -1

    def test(self):
        self.assertEqual(4, self.isPrefixOfWord("i love eating burger", "burg"))


if __name__ == '__main__':
    unittest.main()
