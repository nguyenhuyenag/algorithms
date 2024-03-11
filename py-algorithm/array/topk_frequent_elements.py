import unittest
from typing import List
from collections import Counter

"""
    https://leetcode.com/problems/top-k-frequent-elements/
    
    Cho mảng số nguyên và số nguyên. Trả về mảng chưa k phần tử xuất hiện nhiều nhất 
"""
class Solution(unittest.TestCase):

    @staticmethod
    def topKFrequent(nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        result = list(counter.keys())
        result.sort(key=lambda t: -counter.get(t))
        return result[:k]

    def test(self):
        self.assertEqual([1, 2], self.topKFrequent([1, 1, 1, 2, 2, 3], 2))


if __name__ == '__main__':
    unittest.main()
