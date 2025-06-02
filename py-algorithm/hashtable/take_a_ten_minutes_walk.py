import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://www.codewars.com/kata/54da539698b8a2ad76000228/
    
    Bạn đến sớm buổi tiệc 10p và quyết định nên quyết định đi dạo xung quanh. Cho mảng ['n', 's', 'w', 'e'] đại biểu các hướng sẽ đi. Mỗi hướng sẽ cần 1p để đi hết. Viết hàm kiểm tra để đảm rằng liệu mảng đã cho có đủ thời gian để đi dạo 10p hay không. Nếu có thì trả về True, nếu không thì trả về False.
    
    Giai thích:   
        Độ dài khác 10 → false.
        Tổng dịch chuyển theo trục Bắc-Nam (n - s) và Đông-Tây (e - w) phải bằng 0.
"""


def is_valid_walk(walk):
    return len(walk) == 10 and walk.count('n') == walk.count('s') and walk.count('e') == walk.count('w')


class Solution(unittest.TestCase):

    def test_something(self):
        test_cases = [
            (True, ['n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's']),
            (False, ['w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e']),
            (False, ['w']),
            (False, ['n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'])
        ]
        for expected, case in test_cases:
            self.assertEqual(expected, is_valid_walk(case))


if __name__ == '__main__':
    unittest.main()
