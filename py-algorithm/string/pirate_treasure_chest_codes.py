import math
import re
import unittest
from functools import reduce

"""
    https://www.codewars.com/kata/595fb7d8de9d34743f000162/
    
    Cho chuỗi bao gồm các chữ cái viết hoa và các số, trả về chuỗi mới với các số đã được chia cho ước số chung lớn nhất (GCD) của tất cả các số trong chuỗi, và giữ nguyên các chữ cái.
"""


def gcd_of_array(arr):
    return reduce(math.gcd, arr)


def treasure_code(s):
    letters = re.findall(r'[A-Z]', s)
    numbers = list(map(int, re.findall(r'\d+', s)))

    gcd_val = gcd_of_array(numbers)
    result = ""
    for i in range(len(letters)):
        result += letters[i] + str(numbers[i] // gcd_val)

    return result


class Solution(unittest.TestCase):

    def test_1(self):
        sample_test_cases = [
            ('A2B1', 'A2B1'),
            ('A2B4C6', 'A1B2C3'),
            ('T3Y3U9E6', 'T1Y1U3E2'),
            ('M3H7', 'M3H7'),
            ('Y14U7I7P21', 'Y2U1I1P3'),
            ('A112B333C4', 'A112B333C4'),
            ('R2D2C4', 'R1D1C2')
        ]
        for clue, expected in sample_test_cases:
            self.assertEqual(expected, treasure_code(clue))


if __name__ == '__main__':
    unittest.main()
