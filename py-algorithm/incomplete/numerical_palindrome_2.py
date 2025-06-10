import unittest

from parameterized import parameterized

"""
    https://www.codewars.com/kata/58de819eb76cf778fe00005c/
    
    Kiểm tra xem một số có chứa số đối xứng hay không.
    
    Với chuỗi số s, dùng đệ quy để xét đoạn s[i..j]. Với mỗi cặp (i, j):

        while i < j:
            - Nếu (i, j) là đối xứng và có độ dài ≥ 2 → return True
            - Ngược lại:
                + Thử đoạn (i+1, j) (dời con trỏ trái)
                + Thử đoạn (i, j-1) (dời con trỏ phải)
                + Thử đoạn (i+1, j-1) (dời cả 2 con trỏ)
"""


##### Dùng vòng lặp #####
def is_palindrome_substring(num: str, left: int, right: int) -> bool:
    substr = num[left:right + 1]
    return len(substr) >= 2 and substr == substr[::-1]


def palindrome_OK(n: int):
    if not isinstance(n, int) or n < 0:
        return 'Not valid'

    ns = str(n)
    length = len(ns)

    # Kiểm tra tất cả các đoạn con có độ dài từ 2 trở lên
    for i in range(length):
        for j in range(i + 1, length):
            if is_palindrome_substring(ns, i, j):
                return True
    return False


##### Dùng đệ quy #####
def is_palindrome_segment(s: str, i: int, j: int) -> bool:
    """ Kiểm tra xem đoạn s[i..j] có phải là chuỗi đối xứng hay không. """
    subs = s[i:j + 1]
    return (j - i + 1) >= 2 and subs == subs[::-1]


def check_recursive(s: str, i: int, j: int) -> bool:
    if i >= j:
        return False
    if is_palindrome_segment(s, i, j):
        return True
    return (
            check_recursive(s, i + 1, j) or
            check_recursive(s, i, j - 1) or
            check_recursive(s, i + 1, j - 1)
    )


def palindrome(n):
    if not isinstance(n, int) or n < 0:
        return "Not valid"
    s = str(n)
    return check_recursive(s, 0, len(s) - 1)


class TestSolution(unittest.TestCase):

    @parameterized.expand([
        (868, True),
        (1321, False),
        (1215, True),
        (2, False),
        (123322367, True),
        (1551, True),
        (5, False),
        (1221, True),
        (141221001, True),
        (1215, True),
        (1294, False),
        ("109982", "Not valid"),
    ])
    def test_is_cleanly_nested(self, num, expected):
        self.assertEqual(palindrome(num), expected)


if __name__ == '__main__':
    unittest.main()
