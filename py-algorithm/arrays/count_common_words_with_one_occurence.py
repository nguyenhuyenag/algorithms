import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/count-common-words-with-one-occurrence/
    
    Đếm số phần tử chung chỉ xuất hiện 1 lần của 2 mảng
"""


class Solution(unittest.TestCase):

    @staticmethod
    def countWords_OK(words1: List[str], words2: List[str]) -> int:
        counter1, counter2 = Counter(words1), Counter(words2)
        commons = set(words1) & set(words2)
        count = 0
        for word in commons:
            if counter1.get(word) == 1 and counter2.get(word) == 1:
                count += 1

        return count

    @staticmethod
    def countWords(words1: List[str], words2: List[str]) -> int:
        counter1, counter2 = Counter(words1), Counter(words2)
        count = 0
        # Chỉ cần duyệt trong words 1 là được
        for word in words1:
            if counter1.get(word, -1) == 1 and counter2.get(word, -1) == 1:
                count += 1

        return count

    def test(self):
        self.assertEqual(2, self.countWords(["leetcode", "is", "amazing", "as", "is"], ["amazing", "leetcode", "is"]))
        self.assertEqual(0, self.countWords(["b", "bb", "bbb"], ["a", "aa", "aaa"]))


if __name__ == '__main__':
    unittest.main()
