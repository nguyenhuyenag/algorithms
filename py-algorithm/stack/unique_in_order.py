import unittest
from typing import List

"""
    https://www.codewars.com/kata/54e6533c92449cc251001667/
    
    Xóa các phần tử trùng (giữ lại một) mà vẫn giữ nguyên thứ tự
"""
class Solution(unittest.TestCase):

    def unique_in_order(self, sequence):
        if len(sequence) == 0: return []
        result = []
        for v in sequence:
            if len(result) == 0 or v != result.pop():
                result.append(v)
        return result

    def test(self):
        self.assertEqual([1, 2, 3, 4], self.unique_in_order([1, 1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
