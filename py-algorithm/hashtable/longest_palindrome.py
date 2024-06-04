import unittest

from collections import Counter

"""
    https://leetcode.com/problems/longest-palindrome/

    Cho chuỗi s chỉ chứa các chữ cái. Tìm độ dài lớn nhất của chuỗi đối xứng có thể tạo từ chuỗi s.

    Ví dụ: s = 'abccccdd' -> Chuỗi dài nhất có thể tạo là 'dccaccd' -> kết quả = 7
"""
class Solution(unittest.TestCase):

    def longestPalindrome(self, s: str) -> int:
        counter = Counter(s)
        odd_count = sum(1 for val in counter.values() if val % 2 == 1)
        return len(s) - odd_count + 1 if odd_count > 1 else len(s)

    def test(self):
        self.assertEqual(7, self.longestPalindrome('abccccdd'))
        self.assertEqual(1, self.longestPalindrome('a'))


if __name__ == '__main__':
    unittest.main()
