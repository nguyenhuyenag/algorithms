import unittest
from typing import List
from itertools import chain

"""
    https://www.codewars.com/kata/569d488d61b812a0f7000015/
    
    Đảo mảng dữ liệu
    
        11111111  00000000  00001111  10101010
        (byte1)   (byte2)   (byte3)   (byte4)
    
    thành
    
        10101010  00001111  00000000  11111111
        (byte4)   (byte3)   (byte2)   (byte1)
"""
class Solution(unittest.TestCase):

    def data_reverse(self, data: List[int]) -> list:
        segments = [data[i:i + 8] for i in range(0, len(data), 8)]
        return sum(segments[::-1], [])

    def test(self):
        data1 = [1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0]
        data2 = [1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]
        self.assertEqual(data2, self.data_reverse(data1))


if __name__ == '__main__':
    unittest.main()
