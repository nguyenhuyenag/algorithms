import unittest

"""

"""

class Solution(unittest.TestCase):

    def reversePrefix(self, word: str, ch: str) -> str:
        l = 0
        r = word.find(ch)
        word = list(word)
        while l < r:
            word[l], word[r] = word[r], word[l]
            l += 1
            r -= 1

        return ''.join(word)

    def test(self):
        self.assertEqual("dcbaefd", self.reversePrefix("abcdefd", "d"))
        self.assertEqual("zxyxxe", self.reversePrefix("xyxzxe", "z"))


if __name__ == '__main__':
    unittest.main()
