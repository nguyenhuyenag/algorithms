import unittest

"""
    https://leetcode.com/problems/palindrome-number/
    
    Palindrome number là số mà đọc ngược và đọc xuôi đều bằng nhau
"""


class Solution(unittest.TestCase):

    @staticmethod
    def isPalindrome_OK(x: int) -> bool:
        if x < 0: return False
        return x == int(str(x)[::-1])

    @staticmethod
    def isPalindrome(n: int) -> bool:
        num = str(n)
        left, right = 0, len(num) - 1
        while left < right:
            if num[left] != num[right]:
                return False
            left += 1
            right -= 1
        return True

    def test(self):
        self.assertEqual(True, self.isPalindrome(11211))
        self.assertEqual(False, self.isPalindrome(11213))
        self.assertEqual(False, self.isPalindrome(-121))


if __name__ == '__main__':
    unittest.main()
