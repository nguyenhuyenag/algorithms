import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
    
    Cho 1 mảng thành các mảng con không giao nhau
    
    Lưu ý: Số lượng mảng con = max frequency
"""
class Solution(unittest.TestCase):

    @staticmethod
    def findMatrix(nums: List[int]) -> List[List[int]]:
        # {1: 3, 3: 2, 4: 1, 2: 1}
        counter = Counter(nums)
        max_frequency = max(counter.values())
        result = []
        for i in range(max_frequency):
            one_result = []
            for k, v in counter.items():
                if v > 0:
                    one_result.append(k)
                    counter[k] -= 1
            result.append(one_result)

        return result

    def test(self):
        self.assertEqual([[1, 3, 4, 2], [1, 3], [1]], self.findMatrix([1, 3, 4, 1, 2, 3, 1]))
        self.assertEqual([[1, 2, 3, 4]], self.findMatrix([1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
