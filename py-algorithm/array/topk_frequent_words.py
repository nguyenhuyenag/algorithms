import unittest
from typing import List
from collections import Counter

"""
    https://leetcode.com/problems/top-k-frequent-words/
    
    Cho mảng các chuỗi và số nguyên k. Trả về mảng k phần tử có số lần
    xuất hiện nhiều nhất, nếu bằng nhau thì ưu tiên theo thứ tự từ điển
"""
class Solution(unittest.TestCase):

    @staticmethod
    def topKFrequent(words: List[str], k: int) -> List[str]:
        counter = Counter(words)
        result = list(counter.keys())
        result.sort(key=lambda w: (-counter.get(w), w))
        return result[:k]

    def test(self):
        self.assertEqual(["i", "love"], self.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2))
        self.assertEqual(["the", "is", "sunny", "day"],
                         self.topKFrequent(["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 4))


if __name__ == '__main__':
    unittest.main()
