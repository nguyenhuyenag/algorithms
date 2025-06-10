import unittest
from collections import Counter

from parameterized import parameterized

"""    
    https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/

    Cho chuỗi s, giả sử xi là số lần xuất hiện lẽ và yi là số lần xuất hiện chẵn của
    các ký tự trong s.

    Tìm hiệu lớn nhất của xi - yi.

    Sol: Đếm số lần xuất hiện của các ký tự trong chuỗi s, sau đó tìm số lẽ lớn nhất
    và số chẵn nhỏ nhất. Trả về hiệu của chúng.
"""


class Solution(unittest.TestCase):

    def maxDifference_1(self, s: str) -> int:
        # Đếm số lần xuất hiện của mỗi ký tự trong chuỗi
        counter = Counter(s)

        # Tìm tần suất lớn nhất của ký tự có tần suất lẻ
        max_odd = max(x for x in counter.values() if x % 2 == 1)
        # Tìm tần suất nhỏ nhất của ký tự có tần suất chẵn
        min_even = min(x for x in counter.values() if x % 2 == 0)

        return max_odd - min_even

    def maxDifference(self, s: str) -> int:
        # Đếm số lần xuất hiện của mỗi ký tự trong chuỗi
        counter = Counter(s)

        max_odd, min_even = 0, len(s) + 1  # Khởi tạo min_even lớn hơn độ dài chuỗi

        for freq in counter.values():
            if freq % 2 == 1:
                max_odd = max(max_odd, freq)
            else:
                min_even = min(min_even, freq)

        return max_odd - min_even

    @parameterized.expand([
        # ("aaaaabbc", 3),
        # ("abcabcab", 1),
        ("mmsmsym", -1)
    ])
    def test_is_cleanly_nested(self, test_input, expected):
        self.assertEqual(self.maxDifference(test_input), expected)


if __name__ == '__main__':
    unittest.main()
