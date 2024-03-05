import unittest
from typing import List
from queue import PriorityQueue
from collections import Counter

"""
    https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
    
    Tìm độ dài ngắn nhất sau khi xóa các ký tự giống nhau ở 2 đầu của chuỗi
    
     Ví dụ:
        s = 'ab'      ->  2 ~ Không thể xóa ký tự nào
        s = 'aabaa'   ->  1 ~ Xóa 'aa' ở 2 đầu
        s = 'aaabca'  ->  2 ~ Xóa 'aaa' ở đầu và 'a' ở cuối
"""
class Solution(unittest.TestCase):

    def minimumLength(self, s: str) -> int:
        left, right = 0, len(s) - 1
        while left < right and s[left] == s[right]:
            while left + 1 < right and s[left] == s[left + 1]:
                left += 1

            while left < right - 1 and s[right] == s[right - 1]:
                right -= 1

            left += 1
            right -= 1

        return right - left + 1

    def test(self):
        self.assertEqual(2, self.minimumLength("ab"))
        self.assertEqual(0, self.minimumLength("cabaabac"))
        self.assertEqual(3, self.minimumLength("aabccabba"))
        self.assertEqual(1, self.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"))


if __name__ == '__main__':
    unittest.main()
