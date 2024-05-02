import unittest
from typing import List

"""
    
"""
class Solution(unittest.TestCase):

    def doTest(self, nums: List[int]) -> bool:
        pass

    """
        Các phương thức phải có tên dạng `test_xyz()`
    """
    def test(self):
        self.assertEqual(True, self.doTest([1, 1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
