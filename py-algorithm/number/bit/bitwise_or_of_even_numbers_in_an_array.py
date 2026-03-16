import unittest

from typing import List

"""
    https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/

    Cho một mảng số nguyên nums. Hãy trả về kết quả phép OR theo từng
    bit (bitwise OR) của tất cả các số chẵn trong mảng.

    Nếu trong nums không có số chẵn nào, hãy trả về 0.
"""


class Solution(unittest.TestCase):

    def evenNumberBitwiseORs(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            if num & 1 == 0:
                res |= num

        return res

    def test_todo(self):
        test_cases = [
            ([1, 2, 3, 4, 5, 6], 6),
            ([7, 9, 11], 0),
        ]
        for arr, expected in test_cases:
            self.assertEqual(expected, self.evenNumberBitwiseORs(arr))


if __name__ == '__main__':
    unittest.main()
