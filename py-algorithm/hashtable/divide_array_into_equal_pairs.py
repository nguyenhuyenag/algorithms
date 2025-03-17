import unittest
from collections import Counter
from typing import List

"""
    https://leetcode.com/problems/divide-array-into-equal-pairs/
    
    Cho một mảng số nguyên nums gồm 2 * n phần tử. Chia nums thành n cặp sao cho:
        
        - Mỗi phần tử thuộc chính xác một cặp.
        - Các phần tử trong mỗi cặp có giá trị bằng nhau.
    
    Trả về true nếu có thể chia nums thành n cặp thỏa mãn điều kiện trên, ngược lại trả về false
"""


class Solution(unittest.TestCase):

    def divideArray(self, nums: List[int]) -> bool:
        counter = Counter(nums)
        for key, value in counter.items():
            if value % 2 != 0:
                return False

        return True

    def test_1(self):
        self.assertEqual(True, self.divideArray([3, 2, 3, 2, 2, 2]))

    def test_2(self):
        self.assertEqual(False, self.divideArray([1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
